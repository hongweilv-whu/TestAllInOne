package exceptions;

/**
 * Description:
 * Created by lvhw on 2016/8/12 22:36.
 */
public class Client {
    public static void main(String[] args) {


        BizClass biz = new BizClass();
        try {
            biz.devide(1, 0);
        } catch (BiArgException e) {
            e.printStackTrace();
            /*System.out.println(e.getCause());
            System.out.println(e.getMessage());
            System.out.println(e.toString());*/
        }
    }
}
