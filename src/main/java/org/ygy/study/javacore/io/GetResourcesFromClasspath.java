package org.ygy.study.javacore.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 从类路径读取文件 <br>
 * 避免不同环境下路径不一致的问题，当从classpath下读取资源时，路径总是以"/"开头，
 */
public class GetResourcesFromClasspath {

    public static void main(String[] args) {
        GetResourcesFromClasspath res = new GetResourcesFromClasspath();
//        res.getInputStreamFromClasspath();
        res.loadPropertyFiles();
    }

    /**
     * 从Classpath下读取文件
     */
    private void getInputStreamFromClasspath() {
        try (InputStream is = getClass().getResourceAsStream("/default.properties")) {
            if (is != null) { //资源不存在时，该InputStream为空
                int b;
                while ((b = is.read()) != -1) {
                    System.out.print((char) b);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 加载Classpath下的properties文件
     */
    private void loadPropertyFiles() {
        Properties properties = new Properties();
        try (InputStream is = getClass().getResourceAsStream("/default.properties")) {
            if (is != null) {
                properties.load(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.forEach((k, v) -> System.out.println(k + ":" + v));
    }

}
