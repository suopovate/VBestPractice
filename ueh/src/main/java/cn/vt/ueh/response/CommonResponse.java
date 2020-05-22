package cn.vt.ueh.response;

import cn.vt.ueh.enums.ResponseEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author vate
 */
@Getter
@Setter
public class CommonResponse<T> extends ResponseBase {

    T data;

    public CommonResponse(int code, T data) {
        super(code);
        this.data = data;
    }

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(ResponseEnum.SUCCESS.getCode(), data);
    }

    public static <T> CommonResponse<T> build(int code, T data) {
        return new CommonResponse<>(code, data);
    }
}
