package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lvhw on 2016/6/5.
 */
public class LambdaForListClient {
    public static void main(String[] args) {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};

        List<String> players = Arrays.asList(atp);
        
/*        //foreach遍历
        for (String player : players){
            System.out.println(player + ",");
        }

        System.out.println("------------------------");
        //lambda表达式及函数操作（Function Operation）
        players.forEach((player)->System.out.println(player + ","));

        System.out.println("----------------------------------------");*/
        //双冒号操作符--效果不一致了！！！
        players.forEach(System.out::println);

//        Arrays.sort(atp, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
//        System.out.println("--------------------排序后--------------------");
//        Arrays.asList(atp).forEach(System.out::println);

//        System.out.println("---------------------使用lambda表达式排序-------------------------");
//        Arrays.sort(atp, (String o1, String o2)->o1.compareTo(o2));
//        Arrays.asList(atp).forEach(System.out::println);






    }
}
