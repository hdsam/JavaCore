package org.ygy.study.javacore.exception;

/**
 * 断言, 不常用 <br>
 * 断言失败时，会抛出AssertError,导致程序退出终止。因此，断言不能用于程序的可恢复错误的判断，对于可恢复的异常，不应该使用断言。
 * JVM默认不开启断言，若要执行断言，则需给JVM传递"-enableassertions"参数，可简写为"-ea"
 *
 */
public class Assertion {

    public static void main(String[] args) {
        System.out.println("test assert");
        int x = 5;
        assert x > 0 :  " x must larger than 0";
        System.out.println("assert test");
    }
}
