<<<<<<< HEAD
=======
import java.io.IOException;
>>>>>>> 932ad299831663b96cb945cb8c2e7da69cc33fe9
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lvhw on 2016/6/11.
 */
public class TestClient {
    public static void main(String[] args) {
        String name = null;
        //System.out.println(name.equals("hongwei"));
        System.out.println("hongwei".equals(name));

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
        }
    }
}
