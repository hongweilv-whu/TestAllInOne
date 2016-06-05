package lambda;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by lvhw on 2016/6/6.
 */
public class LambdaOutVariableClient {

    public static void main(String[] args) {

        String[] array = {"a", "b", "c"};

        for (Integer i: Arrays.asList(1, 2, 3)){

            Stream.of(array).map(item->item + i + "@").forEach(System.out::println);

        }
    }
}
