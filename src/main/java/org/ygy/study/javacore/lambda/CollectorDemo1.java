package org.ygy.study.javacore.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 */
public class CollectorDemo1 {

    private static class  Person {

        private String name;

        private int age;

        private String sex;


        public Person(String name, int age, String sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex='" + sex + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }


    private static List<Person>  persons = Arrays.asList(new Person("Jack",12,"F" ),
                                                        new Person("Jim",31,"M" ),
                                                        new Person("Tom",9,"F" ),
                                                        new Person("Lucy",18,"M" )  );

    public static void main(String[] args) {
        Double avgAge = persons.stream().collect(Collectors.averagingInt(Person::getAge));
        System.out.println(avgAge);

        Map<String, Double> ageBySex = persons.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.averagingInt(Person::getAge)));
        System.out.println(ageBySex);

        Map<Boolean, Long> count = persons.stream().collect(Collectors.partitioningBy(person -> person.getAge() >= 18, Collectors.counting()));
        System.out.println(count);
//
//        String names = persons.stream().collect(Collectors.partitioningBy(person -> person.getAge() >= 18,
//                Collectors.groupingBy(Person::getSex ,));
//        System.out.println(names);

    }
}
