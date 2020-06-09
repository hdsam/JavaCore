package org.ygy.study.javacore.datetime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 */
public class DateTimeInAction {

    public static void main(String[] args) {
        oldToNew();

        newToOld();

        System.out.println(
                timestampToString(System.currentTimeMillis(), Locale.CHINESE, "Asia/Shanghai")
        );

        System.out.println(
                timestampToString(System.currentTimeMillis(), Locale.US, "America/New_York")
        );

    }

    /**
     * 旧API转新API
     */
    private static void oldToNew() {
        System.out.println("DateTimeInAction.oldToNew");
        //Date --> Instant
        Instant instant = new Date().toInstant();
        System.out.println(instant);

        //Calendar --> Instant -->ZonedDateTime
        Calendar calendar = Calendar.getInstance();
        Instant instant1 = calendar.toInstant();
        ZonedDateTime zonedDateTime = instant1.atZone(calendar.getTimeZone().toZoneId());
    }


    private static void newToOld() {
        System.out.println("DateTimeInAction.newToOld");
        //ZonedDateTime --> long
        ZonedDateTime zdt = ZonedDateTime.now();
        long ts = zdt.toEpochSecond();

        //  long --> Date
        Date date = new Date(ts);
        System.out.println(date);


        //long -->Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTimeZone(TimeZone.getTimeZone(zdt.getZone()));
        calendar.setTimeInMillis(zdt.toEpochSecond() * 1000);
        System.out.println(calendar.toString());
    }

    private static String timestampToString(long epochMill, Locale locale, String zoneId) {
        Instant instant = Instant.ofEpochMilli(epochMill);
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
        return formatter.withLocale(locale).format(ZonedDateTime.ofInstant(instant, ZoneId.of(zoneId)));
    }
}
