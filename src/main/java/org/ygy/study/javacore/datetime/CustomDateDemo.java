package org.ygy.study.javacore.datetime;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 旧的时间API：java.util.* : Date 、Calendar 、TimeZone
 * 新的时间API：java.time.* : LocalDateTime 、 ZoneDateTime、 ZoneId
 */
public class CustomDateDemo {
    public static void main(String[] args) {
//        display();
//        testDate();
//        testDateFormat();
//        testCalendarToDate();
//        testCalendar();
//        testTimeZone();
//        testDateConversionByTimeZone();
        testDateTimeCalcaluation();
    }

    private static void display() {
        //数据的表现形式
        int n = 1234567;

        System.out.println(n);

        System.out.println(Integer.toHexString(n));

        System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(n));
    }


    private static void testDate(){
        /**
         * 在实际上计算机中，时间存储的是一个相对1970-01-01 00:00:00（格林威治时区/GMT+00:00）到现在所经历的时间数，
         * 我们称之为Epoch Time,在Java中是一个以毫秒为单位的long类型的整数
         * Date不能转换时区
         * */
        Date date = new Date();
        //年份，相对于1900
        System.out.println(date.getYear() + 1900);
        //月份，从0开始
        System.out.println(date.getMonth() + 1);
        //日， 1~31
        System.out.println(date.getDate());

        //转换为String
        System.out.println(date.toString());
        //转换为GMT时区
        System.out.println(date.toGMTString());
        //转换为本地时区
        System.out.println(date.toLocaleString());
    }


    private static void testDateFormat(){
        /**
         * https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
         * yyyy：年
         * YYYY: week year,表示的时间当前日期所在周所属年份，若跨年则属于下一年
         * MM：月
         * dd: 日
         * HH: 小时
         * mm: 分钟
         * ss: 秒
         * E: 一周中的天数名，即星期几
         *
         * */
        Date date = new Date();
        SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = formater1.format(date);
        System.out.println(format1);

        SimpleDateFormat formater2 = new SimpleDateFormat("E MMMM dd, yyyy");
        String format2 = formater2.format(date);
        System.out.println(format2);
    }

    private static void testCalendar(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int mintue = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int millisecond = calendar.get(Calendar.MILLISECOND);

        System.out.println(year + "-" + month + "-" + day + " " + hour + ":" + mintue + ":" + second + "." + millisecond);
    }


    private static void testCalendarToDate(){
        Calendar calendar = Calendar.getInstance();
        //创建一个新时间，先清除当前时间
        calendar.clear();
        //设置日期
        calendar.set(Calendar.YEAR, 2020);
        calendar.set(Calendar.MONTH, 4); //月份从0开始，所以这里是5月份
        calendar.set(Calendar.DATE, 31);

        //设置时间
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE,12);
        calendar.set(Calendar.SECOND, 30);

        Date date = calendar.getTime(); //转换为时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(date);
        System.out.println(dateString);
    }


    private static void testTimeZone(){
        TimeZone defaultTimeZone = TimeZone.getDefault();
        TimeZone GMT9TimeZone = TimeZone.getTimeZone("GMT+09:00");
        TimeZone shanghaiTimeZone = TimeZone.getTimeZone("America/New_York");

        System.out.println(defaultTimeZone.getID());
        System.out.println(GMT9TimeZone.getID());
        System.out.println(shanghaiTimeZone.getID());
    }

    private static void testDateConversionByTimeZone(){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        calendar.set(2020, 4,13,12,1,30);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }

    private static void testDateTimeCalcaluation(){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        calendar.set(2020,4,13,12,35,59);

        calendar.add(Calendar.DATE, 30);
        calendar.add(Calendar.SECOND,-1);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatedDate= dateFormat.format(calendar.getTime());
        System.out.println(formatedDate);
    }

}
