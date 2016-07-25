import org.apache.commons.lang.StringUtils;
import org.springframework.expression.spel.ast.InlineMap;

import java.io.IOException;
import java.util.*;

/**
 * Created by lvhw on 2016/6/11.
 */
public class TestClient {
    public static void main(String[] args) {

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
    }
}
