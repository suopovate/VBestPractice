package cn.vt.ueh.enums;

import cn.vt.ueh.enums.asserts.BaseExceptionResponse;
import cn.vt.ueh.exceptions.BaseException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 断言枚举
 * 该枚举包含两个功能：
 * <p>
 * 1. 定义业务异常类型(同属于一种异常，通过 code 来区分)
 * 2. 特定异常类型抛出的Assert断言功能(本枚举抛出的异常对象)
 *
 * @see BaseException  断言抛出的异常
 * </p>
 *
 * 使用方式：
 * AssertExceptionEnum.DEFAULT.assertNotNull(obj,"错误消息模板：{},{}...","对应第1个{}","对应第2个{}","对应第N个{}")
 */
@Getter
@AllArgsConstructor
public enum AssertExceptionEnum implements BaseExceptionResponse {

    /**
     * 默认异常
     */
    DEFAULT(1000, "Unknow Exception."),
    ;
    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;
}