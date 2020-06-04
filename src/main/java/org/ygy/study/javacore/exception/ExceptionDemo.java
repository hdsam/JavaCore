package org.ygy.study.javacore.exception;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 异常
 *  Throwable
 *      -- Error : 表示严重的错误，程序无力恢复
 *      -- Exception : 运行时的错误，可以被捕获和处理。某些异常是应用程序处理逻辑的一部分。
 *             -- RuntimeException 及子类:
 *             -- 非RuntimeException :如 IOException 、ReflectiveOperationException
 *
 * java规定：
 *  - 必须捕获的异常Exception及其子类，但不包括RuntimeException及其子类 ， 这种类型的异常称为Checked Exception。
 *  - 不需捕获的异常，包括Error及其子类，RuntimeException及其子类
 */
public class ExceptionDemo {

    public static void main(String[] args) {
        byte[] b = toGBK("异常");
        System.out.println(Arrays.toString(b));

        try {
            b = toUTF8("你好");
            System.out.println(Arrays.toString(b));
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }
    }

    private static byte[] toGBK(String str) {
        try {
            return str.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
            return str.getBytes();
        }
    }

    private static byte[] toUTF8(String str) throws UnsupportedEncodingException {
        return str.getBytes("UTF-8");
    }

}
