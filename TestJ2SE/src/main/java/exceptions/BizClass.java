package exceptions;

/**
 * Description:
 * Created by lvhw on 2016/8/12 22:34.
 */
public class BizClass {

    public int devide(int a, int b) throws BiArgException {
        if (0 == b)
            throw new BiArgException("除数为0");

        return a/b;
    }
}
