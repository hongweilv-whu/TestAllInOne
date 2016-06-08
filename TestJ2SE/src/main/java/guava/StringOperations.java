package guava;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.Arrays;
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



    }
}
