package org.ygy.study.javacore.io;

import java.io.*;

/**
 * InputStream的使用
 * 常用实现类 ：
 * 1.FileInputStream : 从文件中读取
 * 2.ByteArrayInputStream : 从内存中的数据模拟
 */
public class InputStreamDemo {

    public static void main(String[] args) {
//      tryCatchFinally();
//      tryWithResource();
//        readByBuffer();
        createFromBytes();
    }


    /**
     * InputStream读取数据
     */
    public static void tryCatchFinally() {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(",/ext/myFile2.txt");
            for (; ; ) {
                int n = inputStream.read();  //read方法是阻塞的，必须读取完之后才能执行后面的代码
                if (n == -1) {
                    break;
                }
                System.out.println(n);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * try-with-resource方式读取流 ，从1.7及以后
     */
    public static void tryWithResource() {
        try (InputStream inputStream = new FileInputStream(",/ext/myFile2.txt")) {
            int n;
            while ((n = inputStream.read()) != -1) {
                System.out.println(n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过缓存区来读取数据
     */
    public static void readByBuffer() {
        try (InputStream inputStream = new FileInputStream(",/ext/myFile2.txt")) {
            byte[] buffer = new byte[100];
            int size;
            while ((size = inputStream.read(buffer)) != -1) {
                System.out.println("size : " + size);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 从内存中模拟一个输入流
     */
    private static void createFromBytes(){
        byte[] data = new byte[]{112, 102, 55, 65, 108 , 44};

        try (InputStream inputStream = new ByteArrayInputStream(data)) {
            int n;
            while (( n = inputStream.read()) != -1){
                System.out.println((char) n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
