package cn.vt.ueh.enums.asserts;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.vt.ueh.enums.IResponseEnum;
import cn.vt.ueh.exceptions.BaseException;

import java.util.Collection;
import java.util.Map;

public interface Assert<E extends BaseException> extends IResponseEnum {

    /**
     * 创建异常
     *
     * @param messageTemplate 覆盖默认消息
     * @param params          messageTemplate占位符对应的参数列表
     * @return 异常对象
     */
    default E newException(String messageTemplate, Object... params) {
        if (StrUtil.isBlank(messageTemplate)) {
            messageTemplate = this.getMessage();
        }
        if (ArrayUtil.isNotEmpty(params)) {
            messageTemplate = StrUtil.format(messageTemplate, params);
        }
        return newException(this, messageTemplate);
    }

    /**
     * 创建异常(子类实现)
     *
     * @param message 覆盖默认消息
     * @return 异常对象
     */
    E newException(IResponseEnum iResponseEnum, String message);

    /**
     * <p>断言对象<code>obj</code>非空。如果对象<code>obj</code>为空，则抛出异常
     *
     * @param obj 待判断对象
     * @return 若断言通过，则返回原对象
     */
    default <T> T assertNotNull(T obj) {
        return assertNotNull(obj, null, null);
    }

    /**
     * <p>断言对象<code>obj</code>非空。如果对象<code>obj</code>为空，则抛出异常
     * <p>异常信息<code>messageTemplate</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param obj    待判断对象
     * @param params messageTemplate占位符对应的参数列表
     * @return 若断言通过，则返回原对象
     */
    default <T> T assertNotNull(T obj, String messageTemplate, Object... params) {
        if (obj == null) {
            throw newException(messageTemplate, params);
        } else {
            return obj;
        }
    }

    /**
     * <p>断言集合<code>collection</code>非空。如果集合<code>collection</code>为空，则抛出异常
     * <p>异常信息<code>messageTemplate</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param collection 待判断是否为空的对象
     * @return 若断言通过，则返回原对象
     */
    default <T extends Collection> T assertNotEmpty(T collection) {
        return assertNotEmpty(collection, null, null);
    }

    /**
     * <p>断言集合<code>collection</code>非空。如果集合<code>collection</code>为空，则抛出异常
     * <p>异常信息<code>messageTemplate</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param collection      待判断集合对象
     * @param messageTemplate 错误消息
     * @param params          messageTemplate占位符对应的参数列表
     * @return 若断言通过，则返回原对象
     */
    default <T extends Collection> T assertNotEmpty(T collection, String messageTemplate, Object... params) {
        if (collection == null || collection.isEmpty()) {
            throw newException(messageTemplate, params);
        }
        return collection;
    }

    /**
     * <p>断言集合<code>map</code>非空。如果集合<code>map</code>为空，则抛出异常
     * <p>异常信息<code>messageTemplate</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param map 待判断是否为空的对象
     * @return 若断言通过，则返回原对象
     */
    default <T extends Map> T assertNotEmpty(T map) {
        return assertNotEmpty(map, null, null);
    }

    /**
     * <p>断言集合<code>map</code>非空。如果集合<code>map</code>为空，则抛出异常
     * <p>异常信息<code>messageTemplate</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param map             待判断集合对象
     * @param messageTemplate 错误消息
     * @param params          messageTemplate占位符对应的参数列表
     * @return 若断言通过，则返回原对象
     */
    default <T extends Map> T assertNotEmpty(T map, String messageTemplate, Object... params) {
        if (map == null || map.isEmpty()) {
            throw newException(messageTemplate, params);
        }
        return map;
    }

    /**
     * <p>断言字符串<code>text</code>非空。如果字符串<code>text</code>为空，则抛出异常
     * <p>异常信息<code>messageTemplate</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param text 待判断字符串对象
     * @return 若断言通过，则返回原对象
     */
    default <T extends String> T assertNotEmpty(T text) {
        return assertNotEmpty(text, null, null);
    }

    /**
     * <p>断言字符串<code>text</code>非空。如果字符串<code>text</code>为空，则抛出异常
     * <p>异常信息<code>messageTemplate</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param text            待判断字符串对象
     * @param messageTemplate 错误消息
     * @param params          messageTemplate占位符对应的参数列表
     * @return 若断言通过，则返回原对象
     */
    default <T extends String> T assertNotEmpty(T text, String messageTemplate, Object... params) {
        if (text == null || "".equals(text.trim())) {
            throw newException(messageTemplate, params);
        }
        return text;
    }

    /**
     * <p>断言数组<code>arr</code>非空。如果数组<code>arr</code>为空，则抛出异常
     * <p>异常信息<code>messageTemplate</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param arr 待判断数组对象
     * @return 若断言通过，则返回原对象
     */
    default <T> T[] assertNotEmpty(T[] arr) {
        return assertNotEmpty(arr, null, null);
    }

    /**
     * <p>断言数组<code>arr</code>非空。如果数组<code>arr</code>为空，则抛出异常
     * <p>异常信息<code>messageTemplate</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param arr             待判断数组对象
     * @param messageTemplate 错误消息
     * @param params          messageTemplate占位符对应的参数列表
     * @return 若断言通过，则返回原对象
     */
    default <T> T[] assertNotEmpty(T[] arr, String messageTemplate, Object... params) {
        if (arr == null || arr.length == 0) {
            throw newException(messageTemplate, params);
        }
        return arr;
    }

    /**
     * <p>断言<code>express</code>非false。如果<code>express</code>为false，则抛出异常
     * <p>异常信息<code>messageTemplate</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param express 表达式的值
     */
    default void assertExpress(boolean express) {
        assertExpress(express, null, null);
    }

    /**
     * <p>断言<code>express</code>非false。如果<code>express</code>为false，则抛出异常
     * <p>异常信息<code>messageTemplate</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param express         表达式的值
     * @param messageTemplate 错误消息
     * @param params          messageTemplate占位符对应的参数列表
     */
    default void assertExpress(boolean express, String messageTemplate, Object... params) {
        if (false == express) {
            throw newException(messageTemplate, params);
        }
    }

    /**
     * <p>断言<code>express</code>非false。如果<code>express</code>为false，则抛出异常
     * <p>异常信息<code>messageTemplate</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param express 待判断对象
     */
    default void isTrue(boolean express) {
        isTrue(express, null, null);
    }

    /**
     * <p>断言<code>express</code>非false。如果<code>express</code>为false，则抛出异常
     * <p>异常信息<code>messageTemplate</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param express         待判断对象
     * @param messageTemplate 错误消息
     * @param params          messageTemplate占位符对应的参数列表
     */
    default void isTrue(boolean express, String messageTemplate, Object... params) {
        if (false == express) {
            throw newException(messageTemplate, params);
        }
    }

    /**
     * <p>断言<code>express</code>非false。如果<code>express</code>为false，则抛出异常
     * <p>异常信息<code>messageTemplate</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param express 待判断对象
     */
    default void isFalse(boolean express) {
        isFalse(express, null, null);
    }

    /**
     * <p>断言<code>express</code>非true。如果<code>express</code>为true，则抛出异常
     * <p>异常信息<code>messageTemplate</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param express         待判断对象
     * @param messageTemplate 错误消息
     * @param params          messageTemplate占位符对应的参数列表
     */
    default void isFalse(boolean express, String messageTemplate, Object... params) {
        if (true == express) {
            throw newException(messageTemplate, params);
        }
    }
}
