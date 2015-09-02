package com.xiongyingqi.spring.http.convert;

import org.springframework.core.convert.converter.Converter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static com.xiongyingqi.util.EntityHelper.print;

/**
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/11/20 0020.
 */
public class SqlDateConverter implements Converter<String, Date> {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat dateFormat3 = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss zzzZ", Locale.ENGLISH);// Wed Dec 10 2014 15:19:57 GMT+0800
    public static final SimpleDateFormat dateFormat4 = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);// Dec 12, 2014

    public SqlDateConverter() {
        print("converter");
    }

    @Override
    public Date convert(String s) {
        Date date = null;
        try {
            Long time = Long.valueOf(s);
            date = new Date(time);
        } catch (Exception e) {
        }
        if (date == null) {
            try {
                date = new Date(dateFormat.parse(s).getTime());
            } catch (Exception e) {
            }
        }

        if (date == null) {
            try {
                date = new Date(dateFormat2.parse(s).getTime());
            } catch (Exception e) {
            }
        }
        if (date == null) {
            date = parse3(s);
        }
        if (date == null) {
            date = parse4(s);
        }
//        dateFormat.setLenient(false);

        return date;
    }

    private Date parse3(String s) {// angular ui
        try {
            if (s.length() > 34) {
                int i = s.indexOf("(");
                if (i > 0) {
                    s = s.substring(0, i).trim();
                }
            }
            Date date = new Date(dateFormat3.parse(s).getTime());
            return date;
        } catch (Exception e) {
        }
        return null;
    }

    private Date parse4(String s) {// angular ui
        try {
            Date date = new Date(dateFormat4.parse(s).getTime());
            return date;
        } catch (Exception e) {
        }
        return null;
    }

}
