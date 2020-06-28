package org.ygy.study.javacore.collections;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;


/**
 * HashMap的key不保证顺序，而SortedMap会对key进行排序。
 * 
 * SortedMap是一个接口，实现类有TreeMap。
 * 
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        // testKey();
        
        // testComparator();;

        testComparator2();
    }

    private static void testKey() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3); //这里默认按字母排序
        for (String  key : map.keySet()){ 
            System.out.println(key);
        }
    }


    static class Person{
        public String name;
        Person(String name) {
            this.name = name;
        }
        public String toString() {
            return "{Person: " + name + "}";
        }
    }

    private static void testComparator(){
        Map<Person,Integer> map = new TreeMap<>(new Comparator<Person>(){

            @Override
            public int compare(Person o1, Person o2) { 
                /**
                 * 如果o1 < o2, 则返回负数，通常是-1；
                 * 如果o1 = o2 ,则返回0 ;
                 * 如果o1 > o2 ,则返回正数， 通常是1；
                 * 
                 */

                return o1.name.compareTo(o2.name);
            }
            
        });

        map.put(new Person("Tom"), 1);
        map.put(new Person("Bob"), 2);
        map.put(new Person("Lily"), 3);

        for (Person  key : map.keySet()) {
            System.out.println(key);
        }

        System.out.println(map.get(new Person("Bob")));
    }


    static class Student {
        public String name;
        public int score;
        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
        public String toString() {
            return String.format("{%s: score=%d}", name, score);
        }
    }

    private static void testComparator2(){
        Map<Student, Integer> map = new TreeMap<>(new Comparator<Student>() {
            public int compare(Student p1, Student p2) {
                return p1.score > p2.score ? -1 : 1;
            }
        });
        map.put(new Student("Tom", 77), 1);
        map.put(new Student("Bob", 66), 2);
        map.put(new Student("Lily", 99), 3);
        for (Student key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println(map.get(new Student("Bob", 66))); // null?
    }


}