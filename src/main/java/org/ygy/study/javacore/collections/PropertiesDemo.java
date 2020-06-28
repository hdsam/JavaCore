package org.ygy.study.javacore.collections;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 配置文件一般是String-String类型的，Java集合库中提供了一个Properties类来表示一组配置，这个类本质上一个Hashtable.
 * load(InputStream)方法接受一个InputStream实例，表示一个字节流，
 * 
 */
public class PropertiesDemo {

	public static void main(String[] args) {
//		loadFromFileSystem();

//		loadFromClasspath();

//		loadFromMemory();

		
//		loadMulitConfigs();
	
		writeToFile();
		
	}




	private static void writeToFile() {
		Properties properties = new Properties();
		properties.setProperty("user.name", "我叫渣渣辉");
		properties.setProperty("user.age", "20");
		try {
			properties.store(new FileOutputStream("user-info.properties"), "自我介绍");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("执行完毕。。。");
	}




	/**
	 * 
	 */
	private static void loadMulitConfigs() {
		Properties properties = new Properties();
		try {
			properties.load(new InputStreamReader(new FileInputStream("data.properties"), StandardCharsets.UTF_8)); 
			properties.load(new InputStreamReader(Properties.class.getResourceAsStream("/settings.properties"), StandardCharsets.UTF_8));
		} catch (IOException e) {
			System.out.println("error reading config file:" + e.getMessage());
		}
		properties.forEach((k, v) -> {
			System.out.println(k +":" + v);
		});
	}
	
	
	

	/**
	 * 从内存加载配置
	 */
	private static void loadFromMemory() {
		Properties properties = new Properties();
		String settings = "#注释1 \n" 
					+ "last_access_time = 2020-06-29 00:11:00\n"
					+ "#注释２\n"
					+ "auto_save = false";
		InputStream input = new ByteArrayInputStream(settings.getBytes(StandardCharsets.UTF_8));
		try {
			properties.load(input);
		} catch (IOException e) {
			System.out.println("error loading config!!!" + e.getMessage());
		}
		System.out.println(properties.getProperty("last_access_time"));
		System.out.println(properties.getProperty("auto_save"));
	}

	/**
	 * 从classpath下读取配置
	 */
	private static void loadFromClasspath() {
		Properties properties = new Properties();
		try {
			properties.load(new InputStreamReader(Properties.class.getResourceAsStream("/settings.properties"), StandardCharsets.UTF_8));
		} catch (IOException e) {
			System.out.println("error reading config file:" + e.getMessage());
		}
		System.out.println(properties.get("last_open_file"));
		System.out.println(properties.get("auto_save_interval"));
	}

	/**
	 * //从文件系统中读取配置
	 */
	private static void loadFromFileSystem() {
		String fileName = "data.properties";
		Properties props = new Properties();
		try {
			props.load(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8)); // 从文件系统中读取配置
		} catch (IOException e) {
			System.out.println("error reading config file:" + e.getMessage());
		}
		System.out.println(props.getProperty("last_open_file"));
		System.out.println(props.getProperty("auto_save_interval", "120"));
	}
}