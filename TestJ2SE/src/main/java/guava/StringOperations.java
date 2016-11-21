package guava;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvhw on 2016/6/8.
 */
public class StringOperations {

    public static void main(String[] args) {


        //Joiner
        //List<Integer> list = Arrays.asList(10, 20, 20, 40, 40, 11, 21);
        List<Integer> list = Lists.newArrayList(10, 20, 20, 40, 40, 11, 21);
        String result1 = Joiner.on(',').join(list);
        System.out.println(result1);

        String result2 = Joiner.on("@#").join(list);
        System.out.println(result2);


        List<String> list1 = new ArrayList<>();

        System.out.println("-----------------");
        System.out.println(Joiner.on(", ").skipNulls().join(list1));
        System.out.println(StringUtils.isEmpty(Joiner.on(", ").skipNulls().join(list1)));

    }
}
