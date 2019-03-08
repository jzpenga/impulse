package com.msp.impulse.util;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

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
}
