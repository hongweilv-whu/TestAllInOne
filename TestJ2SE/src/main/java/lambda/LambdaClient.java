package lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lvhw on 2016/6/5.
 */
public class LambdaClient {
    public static void main(String[] args) {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};

        List<String> players = Arrays.asList(atp);
        
        //foreach遍历
        for (String player : players){
            System.out.println(player + ",");
        }
    }
}
