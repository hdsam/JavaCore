package org.ygy.study.javacore.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * Java8行的时间API
 * 本地日期和时间：LocalDateTime, LocalDate, LocalTime
 * 带时区的日期和时间：ZoneDateTime
 * 时刻：Instant
 * 时区：ZoneId, ZoneOffset
 * 时间间隔：Duration
 * 时间格式化：DateTimeFormatter,代替SimpleDateFormat
 */
public class LocalDateTimeDemo {

    public static void main(String[] args) {
//        getLocalDateTime();
//        createDateTime();
//        testDateTimeCalculation();
//        testDateTimeAdjust();
//        testDateCompare();
        getDuaration();
    }

    /**
     * 从当前时刻获取本地时间
     */
    private static void getLocalDateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
//        LocalDate currentDate = LocalDate.now();
        LocalDate currentDate = currentDateTime.toLocalDate();
//        LocalTime currentTime = LocalTime.now();
        LocalTime currentTime = currentDateTime.toLocalTime();
        System.out.println(currentDate.toString());
        System.out.println(currentTime.toString());
        System.out.println(currentDateTime.toString());
    }

        /**
         * ISO 8601规定的格式为
         * 日期：yyyy-MM-dd
         * 时间：HH:mm:ss
         * 带毫秒的时间：HH:mm:ss.SSS
         * 日期和时间：yyyy-MM-dd'T'HH:mm:ss
         * 带毫秒的日期和时间：yyyy-MM-dd'T'HH:mm:ss.SSS，其中T为一个分隔符
         *
         * */
    private static void createDateTime() {
        LocalDateTime dateTime = LocalDateTime.of(2020, 5, 13, 13, 8, 33);
        System.out.println(dateTime);

        LocalDateTime dateTime2 = LocalDateTime.of(LocalDate.of(2020, 5, 13),
                LocalTime.of(13, 8, 33));
        System.out.println(dateTime2);

        LocalDateTime dateTime3 = LocalDateTime.parse("2020-05-13T13:13:13");
        System.out.println(dateTime3);

        LocalDateTime dateTime4 = LocalDateTime.parse("2020-01-01T23:13:31.990");
        System.out.println(dateTime4);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HHmmss");
        LocalDateTime dateTime5 = LocalDateTime.parse("2020/12/31 010101", dateTimeFormatter);
        System.out.println(dateTime5);

    }

    private static void testDateTimeCalculation() {
        LocalDateTime dateTime = LocalDateTime.of(2020, 5, 13, 14, 11, 30);
        System.out.println(dateTime);

        LocalDateTime dateTime1 = dateTime.plusDays(1).minusHours(23);
        System.out.println(dateTime1);

        LocalDateTime dateTime2 = dateTime1.plus(1, ChronoUnit.DAYS);
        System.out.println(dateTime2);
    }

    private static void testDateTimeAdjust() {
        LocalDate now = LocalDate.now();
        LocalDate date1 = now.withMonth(1) //每一步生成一个新的对象
                .withDayOfMonth(1);
        System.out.println(date1);

        //更加复杂的操作
        //本月的第一天
        LocalDate date2 = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(date2);

        //本月的下个月第一天
        LocalDate date3 = now.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(date3);

        //本月的最后一天
        LocalDate date4 = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(date4);

        //本月的第一个周-
        LocalDate date5 = now.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(date5);

        //本月的最后一个周五
        LocalDate date6 = now.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));
        System.out.println(date6);
    }

    private static void testDateCompare() {
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime other = LocalDateTime.of(2020, 5, 13, 16, 0, 0);
        boolean isAfter = other.isAfter(now);
        System.out.println(other + " > " + now + " : " + isAfter);

        LocalTime currentTime = LocalTime.now();
        LocalTime parsedTime = LocalTime.parse("16:20:30.111");

        System.out.println(parsedTime + " < " +  currentTime + " : " + parsedTime.isBefore(currentTime));
    }

    private static void getDuaration(){
        //LocalDateTime和LocalTime之间的间隔用Duration表示， 精度为纳秒，精度更高
        LocalDateTime start = LocalDateTime.of(2020,1,22,12,0,0);
        LocalDateTime end = LocalDateTime.of(2020,4,12,2,30,0);
        Duration duration = Duration.between(start, end);
        System.out.println(duration); //ISO 8601标准输出：P...T之间表示日期间隔，T后面表示时间间隔 ，如：PT1934H30M表示1934小时加30分

        LocalTime startTime = LocalTime.now();
        LocalTime endTime = LocalTime.of(12,12,12);
        Duration duration1 = Duration.between(startTime, endTime);
        System.out.println(duration1);
        System.out.println(duration1.toMinutes());

        //LocalDate的差值用Period表示,精度为天，精度较低
        LocalDate startDate = LocalDate.of(2020,1,1);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(startDate, currentDate);
        System.out.println(period); //P4M12D 表示4个月加12天

    }
}
