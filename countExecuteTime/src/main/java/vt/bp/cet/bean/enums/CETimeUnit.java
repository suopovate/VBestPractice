package vt.bp.cet.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author vate
 */
@Getter
@AllArgsConstructor
public enum CETimeUnit {
    NANOSECONDS(TimeUnit.NANOSECONDS, "ns"),
    MILLISECONDS(TimeUnit.MILLISECONDS, "ms"),
    SECONDS(TimeUnit.SECONDS, "s"),
    MINUTES(TimeUnit.MINUTES, "min");

    private TimeUnit unit;
    private String suffix;

    static Map<TimeUnit, CETimeUnit> unitMap = new HashMap();

    static {
        unitMap.put(TimeUnit.NANOSECONDS, NANOSECONDS);
        unitMap.put(TimeUnit.MILLISECONDS, MILLISECONDS);
        unitMap.put(TimeUnit.SECONDS, SECONDS);
        unitMap.put(TimeUnit.MINUTES, MINUTES);
    }

    public static CETimeUnit toEnum(TimeUnit unit) {
        return unitMap.get(unit);
    }
}
