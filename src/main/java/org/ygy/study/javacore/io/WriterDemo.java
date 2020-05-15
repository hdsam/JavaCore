package org.ygy.study.javacore.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 字符输出流的使用
 */
public class WriterDemo {

    public static void main(String[] args) {
//        testFileWriter();
//        testCharArrayWriter();
//        testStringWriter();
        testOutputStreamWriter();
    }

    /**
     * FileWriter
     */
    private static void testFileWriter() {
        try (Writer writer = new FileWriter("hello2.txt", true)) {
            writer.write('H');
            writer.write("HELLO WORLD");
            writer.write("字符输出流测试");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * CharArrayWriter
     */
    private static void testCharArrayWriter() {
        try (CharArrayWriter writer = new CharArrayWriter()) {
            writer.write(65);
            writer.write(66);
            writer.write(67);

            char[] chars = writer.toCharArray();
            System.out.println(chars);
        }
    }


    /**
     * StringWriter
     */
    private static void testStringWriter(){
        try (StringWriter writer = new StringWriter()) {
            writer.write(0x41);
            writer.write(0x61);
            StringBuffer buffer = writer.getBuffer();
            System.out.println(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * OutputStreamWriter
     */
    private static void testOutputStreamWriter(){
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("hello3.txt"), StandardCharsets.UTF_8)) {
            writer.write("Gython\n");
            writer.write("JVAV\n");
            writer.write("C--\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
