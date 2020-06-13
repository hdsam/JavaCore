package org.ygy.study.javacore.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * File对象
 */
public class FileDemo {

    public static void main(String[] args) {
//        createFile();
//        getFileInfo();
//        createTempFile();
//        listFiles();
//        buildByPath();
        listDirectoryByLevel(new File("."),0,1);
    }

    /**
     * 创建文件
     */
    public static void createFile() {
        System.out.println("当前系统默认的文件分隔符：" + File.separator);
        //1.绝对路径构造File
        File file1 = new File("C:\\Users\\green\\Desktop\\myFile.txt");
        System.out.println(file1);
        //2.相对路径构造File
        File file2 = new File("./myFile2.txt");
        System.out.println(file2.exists());
        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        try {
            System.out.println(file2.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取文件的系统属性
     */
    public static void getFileInfo() {
        File file = new File("myFile2.txt");
        System.out.println(file.canRead());
        System.out.println(file.canExecute());
        System.out.println(file.canWrite());
        System.out.println(file.length());
    }

    /**
     * 创建临时文件
     */
    public static void createTempFile() {
        try {
            File tempFile = File.createTempFile("tmp-", ".test");
            //设置文件在退出JVM时删除
            tempFile.deleteOnExit();
            System.out.println(tempFile.getCanonicalPath());
            System.out.println(tempFile.isFile());
            Thread.sleep(10000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历文件
     */
    public static void listFiles() {
        File file = new File("./");
        try {
            System.out.println("当前文件路径：" + file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        File[] files = file.listFiles();
        if (files != null) {
            for (File each : files) {
                System.out.println(each);
            }
        }
        System.out.println("----------------------");
        files = file.listFiles(File::isDirectory);
        if (files != null) {
            for (File each : files) {
                System.out.println(each);
            }
        }
    }

    /**
     * 使用Path对象创建File
     */
    public static void buildByPath(){
        Path path = Paths.get("./", "dir", "a");

        Path absolutePath = path.toAbsolutePath();
        System.out.println(absolutePath);

        Path normalizedPath = path.normalize();
        System.out.println(normalizedPath);

        File file = path.toFile();
        System.out.println(file);

        path.forEach(System.out::println);

    }

    /**
     * 遍历文件夹
     * @param file 当前文件
     * @param level 当前文件层级，从0开始
     * @param num 当前文件在本文件夹中的排列序号，从1开始
     */
    private static void listDirectoryByLevel(File file ,int level, int num) {
        if (file == null) {
            return;
        }
        for (int i = 0; i < level; i++) {
            System.out.print(" ");
        }
        System.out.println(level + "." + num + ":"+ file.getName());
        if(file.isDirectory()){
            File[] children = file.listFiles();
            if (children != null) {
                for (int i = 0; i < children.length; i++) {
                    listDirectoryByLevel(children[i],level+1 ,i+1);
                }
            }
        }

    }
}
