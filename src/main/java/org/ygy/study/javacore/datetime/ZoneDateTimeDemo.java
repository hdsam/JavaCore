package org.ygy.study.javacore.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 带时区的日期和时间
 * 可理解为ZoneDateTime类型上等于LocalDateTime加ZoneId. <br>
 * ZoneId是java.time引入的新的时区类，而java.util.TimeZone是旧的API
 */
public class ZoneDateTimeDemo {

    public static void main(String[] args) {
//        creteZoneDateTime();
//        testZoneDateTimeConversion();
        testZoneDateTimeToLocaDateTime();
    }

    private static void creteZoneDateTime() {
        //这两个实际表示是同一个时刻
        ZonedDateTime defaultZoneDateTime  = ZonedDateTime.now(); //获取默认时区的当前时间
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/New_York")); //获取指定时区的当前时间

        System.out.println(defaultZoneDateTime);
        System.out.println(zonedDateTime);


        LocalDateTime localDateTime = LocalDateTime.now();
        //给时间附加上了一个时区，因此下面是两个不同的时刻
        ZonedDateTime defaultDateTime1 = localDateTime.atZone(ZoneId.systemDefault());
        ZonedDateTime zonedDateTime1 = localDateTime.atZone(ZoneId.of("America/New_York"));

        System.out.println(defaultDateTime1);
        System.out.println(zonedDateTime1);
    }


    private static void testZoneDateTimeConversion(){
        ZonedDateTime dateTime1 = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime dateTime2 = dateTime1.withZoneSameInstant(ZoneId.of("America/New_York"));

        //这两个时间是等价的
        System.out.println(dateTime1);
        System.out.println(dateTime2);
    }


    private static void testZoneDateTimeToLocaDateTime(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime(); //转换为本地时间时，直接丢弃时区
        System.out.println(zonedDateTime);
        System.out.println(localDateTime);
    }

}


//    某航线从北京飞到纽约需要13小时20分钟，请根据北京起飞日期和时间计算到达纽约的当地日期和时间。
 class Main {

    public static void main(String[] args) {
        LocalDateTime departureAtBeijing = LocalDateTime.of(2019, 9, 15, 13, 0, 0);
        int hours = 13;
        int minutes = 20;
        LocalDateTime arrivalAtNewYork = calculateArrivalAtNY(departureAtBeijing, hours, minutes);
        System.out.println(departureAtBeijing + " -> " + arrivalAtNewYork);
        // test:
        if (!LocalDateTime.of(2019, 10, 15, 14, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 10, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        } else if (!LocalDateTime.of(2019, 11, 15, 13, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 11, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        }
    }

    static LocalDateTime calculateArrivalAtNY(LocalDateTime bj, int h, int m) {
      return  bj.atZone(ZoneId.of("Asia/Shanghai"))
                .plusHours(h).plusMinutes(m)
                .withZoneSameInstant(ZoneId.of("America/New_York"))
                .toLocalDateTime();
    }



}
