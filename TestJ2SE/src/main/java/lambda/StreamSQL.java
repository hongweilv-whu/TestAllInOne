package lambda;

import lambda.pojos.Person;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 * Created by lvhw on 2016/8/21 18:51.
 */
public class StreamSQL {
    public static void main(String[] args) {
        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
            }
        };

        System.out.println("before:" + javaProgrammers);


        javaProgrammers.stream().filter(p-> StringUtils.equals(p.getGender(), "female"))
        .mapToInt(Person::getSalary).forEach(System.out::println);

        int salarySum = javaProgrammers.stream().filter(p-> StringUtils.equals(p.getGender(), "female")).
                mapToInt(Person::getSalary).sum();
        System.out.println("salarySum:" + salarySum);


        System.out.println("----------female distinct firstname------------");
        javaProgrammers.stream().filter(p-> StringUtils.equals(p.getGender(), "female")).map(Person::getFirstName)
                .distinct().forEach(System.out::println);


        System.out.println("-----------------40,first last name, orderby age------------------------");
        Comparator<Person> comp = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()>o2.getAge() ? 1 : o1.getAge() == o2.getAge() ? 0 : -1;
            }
        };
        javaProgrammers.stream().filter(person -> person.getAge() < 40)
                .sorted(comp).map(p -> p.getFirstName() + " " + p.getLastName()).forEach(System.out::println);



        javaProgrammers.stream().collect(Collectors.groupingBy(Person::getGender))
                .forEach((g, l)-> System.out.println("gender for:" + g + ", sum-age is:" + l.stream().mapToInt(Person::getAge).sum()));


        int maxAge = javaProgrammers.stream().filter(p-> StringUtils.equals(p.getGender(), "male")).mapToInt(Person::getAge).max().getAsInt();
        javaProgrammers.stream().filter(p-> StringUtils.equals(p.getGender(), "male"))
                .filter(p->p.getAge() == maxAge).forEach(System.out::println);

    }
}
