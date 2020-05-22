package cn.vt.ueh.enums;

/**
 * 业务异常的相关定义信息
 */
public interface IResponseEnum {
    /**
     * @return 该异常对应的响应码
     */
    int getCode();

    /**
     * @return 该异常的默认消息
     */
    String getMessage();
}