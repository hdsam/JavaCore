package org.ygy.study.javacore.junit.lesson4;

/**
 * 条件测试
 */
public class Config {

    public String getConfigFile(String filename){
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")){
            return "C:\\" + filename;
        }
        if (os.contains("mac") || os.contains("linux") ||os.contains("unix")){
            return  "/usr/local/" + filename;
        }
        throw new UnsupportedOperationException();
    }

}
