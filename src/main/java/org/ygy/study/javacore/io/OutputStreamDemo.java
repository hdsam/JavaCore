package org.ygy.study.javacore.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * OutputStream的使用
 */
public class OutputStreamDemo {

    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("./ext/myFile.txt")) {
            outputStream.write(0x00000141); //写入int的低八位，即 0xff & b
            outputStream.write(0x0000041);

            outputStream.write("Hello".getBytes("UTF-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
