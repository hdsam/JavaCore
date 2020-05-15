package org.ygy.study.javacore.datetime;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 */
public class DateTimeFormatterDemo {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        //自定义Formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm ZZZZ");
        System.out.println(formatter.format(zonedDateTime));

        //自定义带有地区的Formatter
        DateTimeFormatter zhFormatter = DateTimeFormatter.ofPattern("yyyy MM dd EE HH:mm", Locale.CHINA);
        System.out.println(zhFormatter.format(zonedDateTime));

        DateTimeFormatter usFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM/dd/yyyy, HH:mm", Locale.US);
        System.out.println(usFormatter.format(zonedDateTime));

        //内置的DateTimeFormatter,基于ISO 8601格式
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ISO_DATE.format(localDateTime));
        System.out.println(DateTimeFormatter.ISO_TIME.format(localDateTime));
        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(localDateTime));

        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime));
    }
}
