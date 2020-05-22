package cn.vt.ueh.exceptions;

import cn.vt.ueh.enums.IResponseEnum;
import lombok.Getter;

/**
 * 自定义异常的基类
 * @author vate
 */
@Getter
public class BaseException extends RuntimeException {
    IResponseEnum iResponseEnum;

    public BaseException(IResponseEnum iResponseEnum, String message, Throwable cause) {
        super(message, cause);
        this.iResponseEnum = iResponseEnum;
    }

    public BaseException(IResponseEnum iResponseEnum, String message) {
        super(message);
        this.iResponseEnum = iResponseEnum;
    }
}
