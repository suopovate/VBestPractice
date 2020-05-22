package cn.vt.ueh.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 公共返回状态码定义
 *
 * @author vate
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum implements IResponseEnum {

    /**
     * 成功时返回的状态码
     */
    SUCCESS(200, "操作成功."),
    /**
     * 服务器内部错误时返回的状态码
     */
    SERVER_ERROR(500, "服务器内部错误."),
    ;

    int code;
    String message;
}
