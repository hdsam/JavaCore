package org.ygy.study.javacore.exception;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 捕获异常
 */
public class CatchExceptionDemo {

    public static void main(String[] args) {
        try {
                doSomething();
        }catch (UnsupportedEncodingException e){
            System.out.println("Bad encoding");
        }catch (IOException e){
            System.out.println("IO error");
        }finally { //用来保证某些代码必须被执行
            System.out.println("Processing end");
        }

        // ==================================================================================================
        try {
            doSomething();
            Integer.valueOf("1");
        }catch (IOException | NumberFormatException e){ //因为某些异常的处理逻辑是一样的，所用可以通过"|"来合并到一起处理
            System.out.println(e);
        }finally { //用来保证某些代码必须被执行
            System.out.println("Processing end");
        }
    }

    private static void doSomething() throws UnsupportedEncodingException {
        "hello".getBytes("UTF-8");
    }
}
