package org.ygy.study.javacore.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Map集合
 */
public class MapDemo {

	public static void main(String[] args) {
		/*
		 * ## 
		 * Map是一个种键、值映射表。Map 是一个接口，常用的实现类是HashMap - 判断某个key存在，可以用containsKey(key) -
		 * 存放键值对时调用put(key,
		 * value),就把key和value做了映射放入了Map,如果key值已存在，put()方法的返回值会被删除的旧的值,否则返回null。 -
		 * 遍历Map的key,可以for each遍历Map的keySet()方法返回的键的集合， - 同时遍历Map的key和value,可以使用for
		 * each遍历Map对象的entrySet()集合，它包含每一个key-value映射。 
		 * ##
		 * Map和List不同的是，Map存储的key-value的映射关系，并且不保证顺序，
		 * 
		 */
		List<Student> list = Arrays.asList(new Student("Bob", 78), new Student("Alice", 85), new Student("Brush", 66),
				new Student("Newton", 99));
		Students holder = new Students(list);
		System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
		System.out.println(holder.getScore("Alice") == 85 ? "测试成功!" : "测试失败!");
		System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");
	}

	static class Students {
		List<Student> list;
		Map<String, Integer> cache;

		Students(List<Student> list) {
			this.list = list;
			cache = new HashMap<>();
		}

		/**
		 * 根据name查找score，找到返回score，未找到返回-1
		 */
		int getScore(String name) {
			// 先在Map中查找:
			Integer score = this.cache.get(name);
			if (score == null) {
				score = findInList(name);
				this.cache.put(name, score);
			}
			return score == null ? -1 : score.intValue();
		}

		Integer findInList(String name) {
			for (Student ss : this.list) {
				if (ss.name.equals(name)) {
					return ss.score;
				}
			}
			return null;
		}
	}

	static class Student {
		String name;
		int score;

		Student(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}

}
