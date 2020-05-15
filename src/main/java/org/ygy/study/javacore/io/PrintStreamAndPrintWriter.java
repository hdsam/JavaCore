package org.ygy.study.javacore.io;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 打印流
 */
public class PrintStreamAndPrintWriter {

    public static void main(String[] args) {
        testPrintStream();
//        testPrintWriter();
    }


    private static void testPrintStream() {
//        PrintStream out = System.out;
//        out.println(111);
//        out.println(new Object());
//        out.println("HELLO");

        try (PrintStream printStream = new PrintStream("hello4.txt")) {
            printStream.print("hello4");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static void testPrintWriter() {
        StringWriter buffer = new StringWriter();
        try (PrintWriter writer = new PrintWriter(buffer)) { //这里没有异常
            writer.println(123);
            writer.println("345");
            writer.println("HELLO");
        }
        System.out.println(buffer.toString());
    }
}
