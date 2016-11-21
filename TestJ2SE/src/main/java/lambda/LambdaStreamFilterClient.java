package lambda;

import lambda.pojos.Person;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * Created by lvhw on 2016/6/5.
 */
public class LambdaStreamFilterClient {
    public static void main(String[] args) {

        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                /*add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));*/
            }
        };

        List<Person> phpProgrammers = new ArrayList<Person>() {
            {
                /*add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
                add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
                add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
                add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
                add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
                add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
                add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
                add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
                add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
                add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));*/
            }
        };

//        System.out.println("输出Java 程序员的姓名(lastname firstname)");
//        //javaProgrammers.forEach(System.out::println);
//        //javaProgrammers.forEach((person)->System.out.println(person.getLastName() + " " + person.getFirstName()));
//        javaProgrammers.forEach((person)->System.out.printf("%s %s\n", person.getLastName(), person.getFirstName()));
//
//        System.out.println("输出所有PHP程序员的姓名");
//        phpProgrammers.forEach((programer)->System.out.printf("%s %s\n", programer.getLastName(), programer.getFirstName()));


        System.out.println("输出Java程序员的姓名和工资");
        System.out.println("调薪前：");
        javaProgrammers.forEach((p)->System.out.printf("%s %s : %d\n", p.getLastName(), p.getFirstName(), p.getSalary()));

//        Consumer<Person> raise = (e)->e.setSalary(e.getSalary()*5/100 + e.getSalary());
//        javaProgrammers.forEach(raise);
//        System.out.println("调薪后：");
//        javaProgrammers.forEach((p)->System.out.printf("%s %s : %d\n", p.getLastName(), p.getFirstName(), p.getSalary()));

        //过滤器 filter，输出月薪大于14000的Java程序员的姓名和薪资
//        System.out.println("筛选后：");
//        javaProgrammers.stream().filter((p)->(p.getSalary() > 1400))
//                .forEach((o)->System.out.printf("%s %s : %d\n", o.getLastName(), o.getFirstName(), o.getSalary()));

        //自定义过滤器，并复用他们
        Predicate<Person> ageFilter = (p)->(p.getAge() > 25);
        Predicate<Person> salaryFilter = (p)->(p.getSalary() > 1400);
        Predicate<Person> genderFilter = (p)->(p.getGender().equals("female"));

//        //输出所有年龄大于25，薪资大于1400的女java程序员
//        System.out.println("多重过滤后：");
//        javaProgrammers.stream().filter(ageFilter).filter(salaryFilter).filter(genderFilter)
//                .forEach((p)->System.out.printf("%s %s : %d %d %s\n", p.getLastName(), p.getFirstName(),
//                p.getSalary(), p.getAge(), p.getGender()));


        //limit用法
        //javaProgrammers.stream().limit(3).forEach(System.out::println);
//        javaProgrammers.stream().filter(ageFilter).filter(salaryFilter).filter(genderFilter).limit(3)
//                .forEach((p)->System.out.printf("%s %s : %d %d %s\n", p.getLastName(), p.getFirstName(),
//                        p.getSalary(), p.getAge(), p.getGender()));

        //排序
//        System.out.println("Java程序员按姓排序");
//        javaProgrammers.stream().sorted((p1, p2)->p1.getFirstName().compareTo(p2.getFirstName()))
//                .limit(5).forEach(System.out::println);
//
//        System.out.println("collect");
//        javaProgrammers.stream().sorted((p1, p2)->p1.getFirstName().compareTo(p2.getFirstName()))
//                .limit(5).collect(toList()).forEach(System.out::println);
//
//        //最值,java程序员工资最高的
//        System.out.println("工资最高者");
//        Person maxPerson = javaProgrammers.stream().max((p1, p2)->p1.getSalary() - p2.getSalary()).get();
//        System.out.println(maxPerson);
//
//        System.out.println("工资最低者");
//        System.out.println(javaProgrammers.stream().min((p1, p2)->p1.getSalary() - p2.getSalary()).get());
//

        //map
        System.out.println("map");
        //System.out.println(javaProgrammers.stream().map(Person::getFirstName).collect(joining(";")));;
        System.out.println(javaProgrammers.stream().map(Person::getFirstName));
    }
}
