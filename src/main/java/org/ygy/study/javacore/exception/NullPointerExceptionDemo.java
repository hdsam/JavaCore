package org.ygy.study.javacore.exception;

/**
 * NPE，这个异常通常是由JVM抛出的
 */
public class NullPointerExceptionDemo {

    public static void main(String[] args) {
        String s = null;
        System.out.println(s.toUpperCase());
    }
}
