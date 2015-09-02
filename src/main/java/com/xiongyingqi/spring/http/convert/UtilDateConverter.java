package com.xiongyingqi.spring.http.convert;

import com.xiongyingqi.util.EntityHelper;
import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static com.xiongyingqi.util.EntityHelper.print;

/**
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/11/20 0020.
 */
public class UtilDateConverter implements Converter<String, Date> {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat dateFormat3 = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss zzzZ", Locale.ENGLISH);// Wed Dec 10 2014 15:19:57 GMT+0800
    public static final SimpleDateFormat dateFormat4 = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);// Dec 12, 2014

    public UtilDateConverter() {
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
                date = dateFormat.parse(s);
            } catch (ParseException e) {
            }
        }

        if (date == null) {
            try {
                date = dateFormat2.parse(s);
            } catch (ParseException e) {
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
            Date date = dateFormat3.parse(s);
            return date;
        } catch (Exception e) {
        }
        return null;
    }
    private Date parse4(String s) {// angular ui
        try {
            Date date = dateFormat4.parse(s);
            return date;
        } catch (Exception e) {
        }
        return null;
    }


    public static void main(String[] args) throws ParseException {
//        Dec 1, 2014

//        System.out.println(new Date());
//        SimpleDateFormat dateFormat1 = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);//EEE MMM dd HH:mm:ss zzz yyyy
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);//EEE MMM dd HH:mm:ss zzz yyyy
//        System.out.println(dateFormat2.format(new Date()));
//
        String s = "Dec 12, 2014";
        Date date = dateFormat2.parse(s);
        EntityHelper.print(date);


        String s2 = "Wed Dec 10 2014 15:19:57 GMT+0800 (中国标准时间)";
//        DateFormat formatUtc = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss zzz", Locale.ENGLISH);
        DateFormat formatUtc = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss zzzZ", Locale.ENGLISH);
        formatUtc.setTimeZone(TimeZone.getTimeZone("GMT"));
        formatUtc.setLenient(true);
        System.out.println(formatUtc.format(new Date()));


        if (s2.length() > 34) {
            int i = s2.indexOf("(");
            if (i > 0) {
                print(i);
                s2 = s2.substring(0, i).trim();
                print(s2);
            }
        }
        Date date2 = formatUtc.parse(s2);
        System.out.println(date2);
        System.out.println(s2.length());


    }

}
