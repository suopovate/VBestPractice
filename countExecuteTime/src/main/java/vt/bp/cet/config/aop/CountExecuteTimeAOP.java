package vt.bp.cet.config.aop;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import vt.bp.cet.bean.enums.CETimeUnit;
import vt.bp.cet.config.annotation.CountExecuteArg;
import vt.bp.cet.config.annotation.CountExecuteTime;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author vate
 */
@Aspect
@Component
@Slf4j
public class CountExecuteTimeAOP {

    @Pointcut("@annotation(vt.bp.cet.config.annotation.CountExecuteTime)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object Interceptor(ProceedingJoinPoint pjp) throws Throwable {
        Object object;
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        CountExecuteTime cea = method.getAnnotation(CountExecuteTime.class);

        Stopwatch stopwatch = Stopwatch.createStarted();

        object = pjp.proceed();

        log.info(
                "\n方法执行时间统计:\n{}: {}{}\n参数: {}",
                StrUtil.isNotBlank(cea.value()) ? cea.value() : method.getDeclaringClass().getName() + "." + method.getName(),
                stopwatch.stop().elapsed(cea.unit()),
                CETimeUnit.toEnum(cea.unit()).getSuffix(),
                getArgStr(pjp));
        return object;
    }

    private Object resolveArgValue(Object arg, CountExecuteArg cea) {
        switch (cea.printType()) {
            case TO_JSON: {
                return JSON.toJSONString(arg);
            }
            default: {
                return String.valueOf(arg);
            }
        }
    }

    /**
     * 获取参数Map集合
     *
     * @param joinPoint
     * @return
     */
    String getArgStr(ProceedingJoinPoint joinPoint) {
        List<String> argStrings = new ArrayList<>();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        Object[] args = joinPoint.getArgs();
        String[] argNames = methodSignature.getParameterNames();
        Annotation[][] annotations = methodSignature.getMethod().getParameterAnnotations();

        for (int i = 0; i < argNames.length; i++) {
            CountExecuteArg cea = findCEA(annotations[i]);
            String argName = argNames[i];
            Object arg = args[i];
            if (Objects.nonNull(cea)) {
                argName = StrUtil.isBlank(cea.value()) ? argName : cea.value();
                argStrings.add(argName + ":" + resolveArgValue(arg, cea));
            }
        }

        return "{" + argStrings.stream().collect(Collectors.joining(",")) + "}";
    }

    CountExecuteArg findCEA(Annotation[] annotations) {
        return ArrayUtil.isEmpty(annotations) ? null :
                Arrays.stream(annotations)
                        .filter(annotation -> annotation instanceof CountExecuteArg)
                        .map(annotation -> (CountExecuteArg) annotation)
                        .findFirst().orElse(null);
    }
}
