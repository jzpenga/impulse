package com.msp.impulse.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * @param dateStr
     * @return
     */
    public static Date dateToISODate(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(dateStr);
        return parse;
    }

    public static Date dateToTZDate(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        Date parse = sdf.parse(dateStr);
        return parse;
    }
}
