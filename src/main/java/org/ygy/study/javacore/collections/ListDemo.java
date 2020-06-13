package org.ygy.study.javacore.collections;

import java.util.*;

/**
 * List : 有序列表。允许添加重复的元素
 */
public class ListDemo {

    /**
     * ArrayList : 内部通过数组实现。
     * LinkedList : 通过链表实现。
     * <p>
     * <p>
     * ArrayList                         LinkedList
     * <p>
     * 获取指定位置的元素              速度很快                            需要从头开始遍历
     * <p>
     * 添加元素的末尾                 速度很快                            速度很快
     * <p>
     * 在指定位置添加/删除             需要移动元素                        不需要移动元素
     * <p>
     * 内存占用                     少                                  较大
     */
    public static void main(String[] args) {

//        addElementsToList();

        traverseList();
    }

    public static void addElementsToList() {
        List<String> list = new ArrayList<>();

        list.add("apple");
        list.add("pear");
        list.add("peach");
        list.add("apple");

        System.out.println(list.size());

        list.add(null);
        System.out.println(list.get(4));

    }

    public static void traverseList() {

        List<String> list = new LinkedList<>();
        list.add("apple");
        list.add("pear");
        list.add("peach");
        list.add("apple");

        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String each = iterator.next();
            System.out.println(each);
        }
    }
}

class Main {
    public static void main(String[] args) {
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); start++) {
            Integer i = iterator.next();
            if (i != start) return start;
        }
        return -1;
    }

}

class Main2 {
    public static void main(String[] args) {
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 21;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 洗牌算法shuffle可以随机交换List中的元素位置:
        Collections.shuffle(list);
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
        int sum1 = 0;
        for (int i = start; i <= end; i++) {
            sum1 += i;
        }
        int sum2 = 0;
        for (Integer each : list) {
            sum2 += each;
        }
        return sum1 - sum2;
    }

}