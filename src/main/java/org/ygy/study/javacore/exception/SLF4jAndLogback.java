package org.ygy.study.javacore.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SLF4j类似于Commons Logging ,是一个日志接口
 * Logback类似于Log4j,是一个日志的实现
 */
public class SLF4jAndLogback {


    /**
     * 需要引入三个jar包
     * slf4j-api-1.7.x.jar
     * logback-classic-1.2.x.jar
     * logback-core-1.2.x.jar
     *
     *
     * */

    final static Logger LOGGER = LoggerFactory.getLogger(SLF4jAndLogback.class);

    public static void main(String[] args) {

        LOGGER.info("hello : {} ", "slfj4j"); //可以设置占位符{}

        LOGGER.error("error occurs...");
    }
}
