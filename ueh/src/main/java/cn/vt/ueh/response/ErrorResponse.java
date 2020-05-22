package cn.vt.ueh.response;

import cn.hutool.core.util.StrUtil;
import cn.vt.ueh.enums.AssertExceptionEnum;
import cn.vt.ueh.exceptions.BaseException;
import lombok.Getter;
import lombok.Setter;

/**
 * @author vate
 */
@Getter
@Setter
public class ErrorResponse extends ResponseBase {

    String message;

    public ErrorResponse(int code, String message) {
        super(code);
        this.message = message;
    }

    public static <E extends BaseException> ErrorResponse error(E e) {
        return new ErrorResponse(e.getIResponseEnum().getCode(),
                StrUtil.isBlank(e.getMessage())
                        ? e.getIResponseEnum().getMessage()
                        : e.getMessage());
    }

    public static ErrorResponse error(Exception e) {
        return new ErrorResponse(AssertExceptionEnum.DEFAULT.getCode(),
                StrUtil.isBlank(e.getMessage())
                        ? AssertExceptionEnum.DEFAULT.getMessage()
                        : e.getMessage());
    }

    public static ErrorResponse build(int code,String message) {
        return new ErrorResponse(code,message);
    }
}
