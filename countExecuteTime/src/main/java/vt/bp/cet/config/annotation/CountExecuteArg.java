package vt.bp.cet.config.annotation;


import vt.bp.cet.bean.enums.CEPrintType;

import java.lang.annotation.*;

/**
 * @author vate
 * <p>
 * 设置在方法参数上,决定是否需要打印该参数
 * @see CountExecuteTime
 */
@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CountExecuteArg {
    /**
     * 打印时的名称
     */
    String value() default "";
    /**
     * 将参数转换为字符串打印时，转换类型
     *
     * @see CEPrintType
     */
    CEPrintType printType() default CEPrintType.TO_STRING;
}
