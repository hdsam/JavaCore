package org.ygy.study.javacore.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Collections时JDK提供的工具类。
 * 
 * @author Yegenyao
 *
 */
public class CollectionsDemo {

	public static void main(String[] args) {

		// 1.添加多个元素到Collection
		List<Integer> list = new ArrayList<>();
		Collections.addAll(list, new Integer[] { 2, 3, 4 });
		System.out.println(list.toString());

		// 2.创建空集合list, map ,set，并且返回的集合是不可变集合，无法向其中添加和删除元素
		List<String> emptyList = Collections.emptyList(); // 类似的，List<Object> asList = Arrays.asList();也可以创建空集合
		Map<String, String> emptyMap = Collections.emptyMap();
		Set<String> emptySet = Collections.emptySet();
//		emptySet.add("1");

		// 3.创建单元素集合,并且返回的集合是不可变集合，无法向其中添加和删除元素
		List<Integer> singletonList = Collections.singletonList(1);
		Map<String, Integer> singletonMap = Collections.singletonMap("age", 12);
		Set<Integer> singletonSet = Collections.singleton(1);
//		singletonSet.add(2);

		// 4.排序。因为Collections对List排序会改变List中元素的位置，所以传入的必须是可变List
		List<String> fruit = new ArrayList<>();
		fruit.add("apple");
		fruit.add("pear");
		fruit.add("orange");
		System.out.println("排序前：" + fruit);
		Collections.sort(fruit);
		System.out.println("排序后：" + fruit);

		// 5.洗牌 Collections提供了洗牌算法，即传入一个有序的List,可以随机打乱List内部
		// 元素的顺序.
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			nums.add(i);
		}
		Random random = new Random();
		System.out.println("洗牌前：" + nums);
		Collections.shuffle(nums);
		System.out.println("洗牌后：" + nums);

		// 6.不可变集合

		List<Integer> unmodifiableList = Collections.unmodifiableList(nums);
//		Collections.unmodifiableMap(null);
//		Collections.unmodifiableSet(null);
//		unmodifiableList.add(1);
		System.out.println(unmodifiableList);
		nums.add(10);
		// 继续对原始的可变List进行增删是可以的，并且，会直接影响到封装后的“不可变”List
		// 所以对于可变的集合封装成不可变集合，应该立即扔掉对可变集合的引用。
		System.out.println(unmodifiableList);

		// 7. 线程安全集合,Collections的下面这些方法可以将线程不安全的集合变为线程安全的集合。
		//但从Java5开始，引入了更高效的并发集合类，所以这几个同步方法已经灭有什么用了。
		List<Integer> synchronizedList = Collections.synchronizedList(nums);
//		Collections.synchronizedMap(null);
//		Collections.synchronizedSet(null);

	}
}
