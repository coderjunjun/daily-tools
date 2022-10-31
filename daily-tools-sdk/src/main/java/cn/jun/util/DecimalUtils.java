package cn.jun.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created on 2022-10-29
 */
public class DecimalUtils {

    private static final BigDecimal PERCENT = new BigDecimal(100);

    public static String format(BigDecimal value) {
        DecimalFormat df = new DecimalFormat("0.##");
        return df.format(value);
    }

    public static String formatPercent(BigDecimal value) {
        return format(value.multiply(PERCENT));
    }
}
