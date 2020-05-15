package org.ygy.study.javacore.datetime;

import java.time.Instant;

/**
 * Instant时间戳，类似于System.currentMills();
 */
public class InstantDemo {
    public static void main(String[] args) {
        Instant now = Instant.now(); 
        System.out.println(now.toString());
    }

}
