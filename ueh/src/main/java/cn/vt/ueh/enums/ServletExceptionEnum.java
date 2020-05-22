package cn.vt.ueh.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Servlet 级别的异常对应的返回状态码
 */
@Getter
@AllArgsConstructor
public enum ServletExceptionEnum implements IResponseEnum {
    NoHandlerFoundException(10000, ""),
    HttpRequestMethodNotSupportedException(10001, ""),
    HttpMediaTypeNotSupportedException(10002, ""),
    MissingPathVariableException(10003, ""),
    MissingServletRequestParameterException(10004, ""),
    TypeMismatchException(10005, ""),
    HttpMessageNotReadableException(10006, ""),
    HttpMessageNotWritableException(10007, ""),
    BindException(10008, ""),
    MethodArgumentNotValidException(10009, ""),
    HttpMediaTypeNotAcceptableException(10010, ""),
    ServletRequestBindingException(10011, ""),
    ConversionNotSupportedException(10012, ""),
    MissingServletRequestPartException(10013, ""),
    AsyncRequestTimeoutException(10014, ""),
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