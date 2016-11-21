package collect;

import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Description:
 * Created by lvhw on 2016/8/16 7:22.
 */
public class IteratorClient {
    public static void main(String[] args) {

        Map<String, Object> map = Maps.newHashMap();


        /*Collection books = new HashSet<>();
        books.add("AAA");
        books.add("BBB");
        books.add("CCC");

        Iterator ite = books.iterator();
        while (ite.hasNext()){
            String book = (String) ite.next();
            System.out.println(book);

            if (StringUtils.equals("BBB", book)){
                //ite.remove();

                books.remove(book);
            }

            book = "DDD";
        }

        System.out.println(books);*/

        Collection persons = new HashSet<>();
        persons.add(new Person("aa", 11));
        persons.add(new Person("bb", 22));
        persons.add(new Person("cc", 33));

        Iterator ite = persons.iterator();
        while (ite.hasNext()){
            Person person = (Person) ite.next();
            System.out.println(person);

            Person t = new Person("bb", 22);
            if (t.equals(person)){
                ite.remove();

                //persons.remove(person);
            }

            //person.setName("DDD");
            person = t;
        }

        System.out.println(persons);

    }
}
