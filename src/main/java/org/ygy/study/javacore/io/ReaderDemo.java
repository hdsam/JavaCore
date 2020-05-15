package org.ygy.study.javacore.io;


import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Reader字符流的使用
 */
public class ReaderDemo {

    public static void main(String[] args) {

//        testFileReader();
//        testFileReaderWithBuffer();
//        testCharArrayReader();
//        testStringReader();
        testInputStreamReader();
    }

    /**
     * 从文件创建输入字符流
     */
    private static void testFileReader() {
        try (Reader reader = new FileReader("hello.txt")) {
            for (; ; ) {
                int n = reader.read();
                if (n == -1) break;
                System.out.print((char) n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从文件创建输入字符流
     */
    private static void testFileReaderWithBuffer() {
        try (Reader reader = new FileReader("hello.txt")) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] buffer = new char[1024];
            int len;
            while ((len = reader.read(buffer)) != -1) {
                stringBuilder.append(buffer);
            }
            System.out.println(stringBuilder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从内存中模拟输入字符流
     */
    private static void testCharArrayReader() {
        char[] data = new char[]{'J', 'V', 'A', 'V'};
        try (Reader reader = new CharArrayReader(data)) {
            int n;
            while ((n = reader.read()) != -1) {
                System.out.print((char) n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 从String创建输入字符流
     */
    private static void testStringReader() {
        String data = "PHP is the best programming language!";
        try (Reader reader = new StringReader(data)) {
            for (; ; ) {
                int n = reader.read();
                if (n == -1) {
                    break;
                }
                System.out.print((char) n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从输入流创建输入字符流
     */
    private static void testInputStreamReader(){
        try (Reader reader = new InputStreamReader(new FileInputStream("hello.txt"), StandardCharsets.UTF_8)) {
            int n ;
            while ((n = reader.read()) != -1){
                System.out.print((char)n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
