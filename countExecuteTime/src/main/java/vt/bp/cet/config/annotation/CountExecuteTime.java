package vt.bp.cet.config.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author vate
 * @see CountExecuteArg
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CountExecuteTime {
    /**
     * 打印名称
     */
    String value() default "";

    /**
     * 时间单位
     * default: 毫秒
     */
    TimeUnit unit() default TimeUnit.MILLISECONDS;
}
