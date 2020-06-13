package org.ygy.study.javacore.collections;

/**
 * 在Java中，如果一个Java对象可以在内部持有若干其他对象，并对位提供访问接口，我们把这种Java对象称为集合。
 * 1.java.util 主要提供了以下三种类型的集合 ：
 *  List : 有序列表的集合
 *  Set : 保证没有重复元素的集合
 *  Map : 通过键值对（Key-Value）查找的映射集合表
 * 2.集合设计类的特点 ：
 *  - 实现了接口和实现类分离
 *  - 支持泛型
 * 集合的访问总是通过统一的方式--迭代器（Iterator）来实现，好处在于无需关心内部是以什么方式存储的
 * 此外，由于Java的集合设计十分久远，中间经过大规模改进，一小部分遗留类不宜继续使用：
 * - HashTable : 一种线程安全的Map实现
 * - Vector : 一种线程安全的List实现
 * - Stack : 基于Vector的LIFO的栈
 * 遗留接口：
 * - Enumeration<E> : 已被Iterator<E>取代
 *
 */
public class CollectionDescription {


}
