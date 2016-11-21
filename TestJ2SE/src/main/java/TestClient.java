import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.springframework.expression.spel.ast.InlineMap;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by lvhw on 2016/6/11.
 */
public class TestClient {
    public static void main(String[] args) {

        /*List<String> target = Lists.newArrayList();
        List<String> src = null;

        System.out.println("------" + target.addAll(src));

        List<String> listStr = new ArrayList<>();
        listStr.add("lvhongwei");
        listStr.add("xiongzhiyan");
        listStr.add("yanwen");
        listStr.add("msheng");
        System.out.println(listStr);

        for (Iterator<String> listiter = listStr.iterator(); listiter.hasNext(); ) {
            if ("xiongzhiyan".equals(listiter.next()))
                listiter.remove();
        }

        System.out.println(listStr);

        Map<String, String> map = new HashMap<>();
*/
        // modify by lvhw on 2016/7/24 15:53

        // end modify


       /* String name = null;
        //System.out.println(name.equals("hongwei"));
        System.out.println("hongwei".equals(name));

        String value = "  ";
        value = StringUtils.trim(value);
        System.out.println(value);

        List<Integer> list = Arrays.asList(1, 2, 2, 4);

        for (int i = 0, length=list.size(); i < length; i++) {
            System.out.println(i);
        }

        try {
            try{
                throw new NullPointerException();

            }catch (Exception e){
                System.out.println("exception 1");
                e.printStackTrace();
            }

            try{

                throw new IOException();
            }catch (Exception e){

                System.out.println("exception 2");
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/



        int[][] results = new int[][]{{10, 20, 30},{10, 22, 29},{12, 18, 32}};
        List originList = Arrays.asList(results);
        System.out.println("originList" + originList);
        //List<Integer> list = Arrays.stream(results).map(a->a[1]).collect(Collectors.toList());

        /*for (int[] result : results) {
            System.out.println("list---" + Arrays.toString(result));
        }*/
    }
}
