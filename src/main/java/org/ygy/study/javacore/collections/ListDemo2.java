package org.ygy.study.javacore.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * override
 */
public class ListDemo2 {

    public static void main(String[] args) {
        testEquals();

        testEquals2();

        System.out.println(String.format("%tm",9));
        System.out.println(String.format("%tm",9));


    }

    private static void testEquals2() {
        System.out.println("ListDemo2.testEquals2");

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("xiao ming"));
        personList.add(new Person("xiao liu"));
        personList.add(new Person("xiao fang"));

        boolean contains = personList.contains(new Person("xiao liu"));
        System.out.println(contains);

    }

    private static void testEquals() {
        System.out.println("ListDemo2.testEquals");
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println(list.contains("A"));
        System.out.println(list.contains("X"));
        System.out.println(list.contains(new String("A")));
        System.out.println(list.indexOf(new String("A")));
    }
}
class  Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    /**
     * equals方法必须满足一下条件：
     *  - 子反性（Reflexive）:对于非null的x来说，x.equals(x)必须返回true;
     *  - 对称性（Symmetric）: 对于非null的x和y来说，如果x.equals(y)为true,那么y.equals(x)也必须为true;
     *  - 传递性（Transitive）: 对于非null的x、y和z来说，如果x.equals(y)为true，y.equals(z)为true，那么x.equals(z)也必须为true;
     *  - 一致性（Consistent）: 对于非null的x,y来说，只要x和y状态不变，则x.equals(y)的值总是一致性的返回true或false;
     *
     * 逻辑相等，这里我们认为name相等，即可认为两个Person对象相等。
     *  - 对于引用字段，使用equals（），
     *  - 对于基本类型，使用 ==
     *
     *
     *
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
