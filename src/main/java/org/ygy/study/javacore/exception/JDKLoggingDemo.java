package org.ygy.study.javacore.exception;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

/**
 * JDK内置日志
 *
 * 定义了如下七个级别
 * SEVERE
 * WARNING
 * INFO
 * CONFIG
 * FINE
 * FINER
 * FINEST
 *
 */
public class JDKLoggingDemo {

    public static void main(String[] args) {
        Logger logger = Logger.getGlobal();

        logger.info("start process...");
        logger.warning("memory is running out...");
        logger.fine("ignored.");
        logger.severe("process will be terminated...");



        Logger logger2 = Logger.getLogger(JDKLoggingDemo.class.getName());
        logger.info("Start process...");
        try {
            "".getBytes("invalidCharsetName");
        } catch (UnsupportedEncodingException e) {
            // TODO: 使用logger.severe()打印异常
            logger2.severe("Exception occurs.");
        }
        logger.info("Process end.");
    }
}
