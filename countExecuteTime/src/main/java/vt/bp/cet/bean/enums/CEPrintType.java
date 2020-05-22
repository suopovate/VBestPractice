package vt.bp.cet.bean.enums;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author vate
 */
@Getter
@AllArgsConstructor
public enum CEPrintType {
    /**
     * @see String#valueOf(Object)
     */
    TO_STRING(),
    /**
     * @see JSONObject#toJSONString(Object)
     */
    TO_JSON(),
    ;
}
