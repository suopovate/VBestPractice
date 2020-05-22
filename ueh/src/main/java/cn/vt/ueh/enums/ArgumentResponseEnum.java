package cn.vt.ueh.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 请求参数相关的错误码定义
 *
 * @author vate
 */
@Getter
@AllArgsConstructor
public enum ArgumentResponseEnum implements IResponseEnum {

    /**
     * 参数校验错误
     */
    VALID_ERROR(2000, "请求参数校验错误."),
    ;

    int code;
    String message;
}
