package org.ygy.study.javacore.io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Zip文件读写
 */
public class ZipInputStreamDemo {

    public static void main(String[] args) {

//        readZip();
        writeZip();

    }

    /**
     * 创建Zip文件
     */
    private static void writeZip() {
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("./ext/2.zip"))) {
            File[] files = new File[]{new File("./ext/myFile.txt"), new File("./ext/myFile2.txt")};
            for (File each : files) {
                if (each.exists() && each.isFile()) {
                    ZipEntry zipEntry = new ZipEntry(each.getName()); //这个name决定了zip文件的相对路径
                    zip.putNextEntry(zipEntry);
                    addEntryContent(zip, each);
                    zip.closeEntry();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 写入文件数据到zip输出流中
     *
     * @param os   zip输出流
     * @param file 待写入的文件
     */
    private static void addEntryContent(OutputStream os, File file) {
        try (InputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 从zip文件读取数据
     */
    private static void readZip() {
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream("./ext/1.zip"))) {
            ZipEntry entry;
            while ((entry = zip.getNextEntry()) != null) {
                String entryName = entry.getName();
                System.out.println(entryName + ":");
                if (!entry.isDirectory()) {
                    int n;
                    while ((n = zip.read()) != -1) {
                        System.out.print((char) n);
                    }
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
