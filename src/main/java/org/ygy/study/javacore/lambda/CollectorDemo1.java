package org.ygy.study.javacore.lambda;

import java.util.Arrays;
import java.util.Collection;
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

    private static class PersonForm{
        List<Person> personList ;

        public PersonForm(List<Person> personList) {
            this.personList = personList;
        }

        @Override
        public String toString() {
            return "PersonForm{" +
                    "personList=" + personList +
                    '}';
        }
    }

    private static class PersonGroup{
        String ageRange;

        PersonForm personForm ;

        public PersonGroup(String ageRange, PersonForm personForm) {
            this.ageRange = ageRange;
            this.personForm = personForm;
        }
    }

    public static void main(String[] args) {
        Double avgAge = persons.stream().collect(Collectors.averagingInt(Person::getAge));
        System.out.println(avgAge);

        Map<String, Double> ageBySex = persons.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.averagingInt(Person::getAge)));
        System.out.println(ageBySex);

        Map<Boolean, Long> count = persons.stream().collect(Collectors.partitioningBy(person -> person.getAge() >= 18, Collectors.counting()));
        System.out.println(count);

        Map<Boolean, Collection<PersonForm>> names = persons.stream().collect(Collectors.partitioningBy(person -> person.getAge() >= 18,
                Collectors.collectingAndThen(
                        Collectors.groupingBy(Person::getSex, Collectors.collectingAndThen(Collectors.toList(), PersonForm::new))
                , Map::values)));
        System.out.println("POS:"+names.get(Boolean.TRUE));
        System.out.println("NEG:"+names.get(Boolean.FALSE));

    }
}
