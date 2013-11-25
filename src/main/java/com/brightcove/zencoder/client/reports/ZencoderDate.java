package com.brightcove.zencoder.client.reports;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ZencoderDate {

    // Year Month Day Timezone
    private static final String DATE_FORMAT = "yyyy-mm-dd z";

    /**
     * Converts a Zencoder Date 'YYYY-MM-DD' into a Java Date.
     * @throws ParseException
     */
    public static Date fromZC(String zc) throws ParseException {
        if (zc == null || zc.length() < 8) {
            return null;
        }
        return new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH).parse(zc + " UTC");
    }

    /**
     * Converts a Java Date into a Zencoder Date 'YYYY-MM-DD' in UTC.
     */
    public static String toZC(Date d) {
        if (d == null) {
            return null;
        }
        return new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH).format(d);
    }

}
