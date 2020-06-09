package org.ygy.study.javacore.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Instant时间戳，类似于System.currentMills();
 */
public class InstantDemo {
    public static void main(String[] args) {
        Instant now = Instant.now(); 
        System.out.println(now.toString());


        long epochSecond = now.getEpochSecond();
        System.out.println(epochSecond);

        Instant instant = Instant.ofEpochSecond(1591151984);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(localDateTime);
    }

}
