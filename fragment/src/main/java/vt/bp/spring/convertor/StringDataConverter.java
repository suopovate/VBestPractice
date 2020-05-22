package vt.bp.spring.convertor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author vate
 *
 * Springmvc 日期转换器,用于转换控制层方法的 Date 参数
 */
public class StringDataConverter implements Converter<String, Date> {

    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private static final String shortDateFormat_line = "yyyy-MM-dd";
    private static final String shortDateFormat_slash = "yyyy/MM/dd";
    private static final String timeStampFormat = "^\\d+$";

    @Override
    public Date convert(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        value = value.trim();
        try {
          SimpleDateFormat formatter;
          if (value.contains("-")) {
                if (value.contains(":")) {
                    //yyyy-MM-dd HH:mm:ss 格式
                    formatter = new SimpleDateFormat(dateFormat);
                } else {
                    //yyyy-MM-dd 格式
                    formatter = new SimpleDateFormat(shortDateFormat_line);
                }
                return formatter.parse(value);
            } else if (value.matches(timeStampFormat)) {
                //时间戳
                Long timeStamp = new Long(value);
                return new Date(timeStamp);
            } else if (value.contains("/")) {
                if (value.contains(":")) {
                    // yyyy/MM/dd HH:mm:ss 格式
                    formatter = new SimpleDateFormat(dateFormat);
                } else {
                    // yyyy/MM/dd 格式
                    formatter = new SimpleDateFormat(shortDateFormat_slash);
                }
                return formatter.parse(value);
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format("parser %s to Date fail", value));
        }
        throw new RuntimeException(String.format("parser %s to Date fail", value));
    }
}