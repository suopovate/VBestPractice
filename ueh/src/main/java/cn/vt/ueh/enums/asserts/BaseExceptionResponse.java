package cn.vt.ueh.enums.asserts;

import cn.vt.ueh.enums.IResponseEnum;
import cn.vt.ueh.exceptions.BaseException;

/**
 * <p>
 *  中间扩展接口：
*  </p>
 */
public interface BaseExceptionResponse extends Assert<BaseException> {

    @Override
    default BaseException newException(IResponseEnum iResponseEnum, String message){
        return new BaseException(iResponseEnum,message);
    }

}