package org.ygy.study.javacore.io;

import java.io.*;
import java.util.Arrays;

public class SerializableDemo {

    public static void main(String[] args) {
//        serialization();
        deserialization();
    }

    /**
     * 序列化
     * Java Object 转换成 byte[]
     */
    private static void serialization() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
//            oos.writeInt(123456);
//            oos.writeChars("Hello World!");
//            oos.writeUTF("IO测试");
//            oos.writeObject(Integer.valueOf("100"));
            oos.writeObject(new Person("yegenyao", 20));
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = bos.toByteArray();
        System.out.println(Arrays.toString(bytes));
    }


    /**
     * 反序列化
     * byte[] 转换为Java Object
     */
    private static void deserialization() {
        byte[] data = {
                -84, -19, 0, 5, 115, 114, 0, 32, 111, 114, 103, 46, 121, 103, 121, 46, 115, 116, 117, 100, 121, 46, 106,
                97, 118, 97, 99, 111, 114, 101, 46, 105, 111, 46, 80, 101, 114, 115, 111, 110, 89, 56, 85, 0, 107, -99,
                126, 40, 2, 0, 2, 73, 0, 3, 97, 103, 101, 76, 0, 4, 110, 97, 109, 101, 116, 0, 18, 76, 106, 97, 118, 97,
                47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 120, 112, 0, 0, 0, 20, 116, 0, 8, 121, 101,
                103, 101, 110, 121, 97, 111};
        ByteArrayInputStream buffer = new ByteArrayInputStream(data);
        try (ObjectInputStream ois = new ObjectInputStream(buffer)) {
            Object obj = ois.readObject();
            System.out.println(((Person) obj));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
