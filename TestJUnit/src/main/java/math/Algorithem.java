package math;

/**
 *
 * Created by lvhw on 2016/7/23.
 */
public class Algorithem {

    public int add(int a, int b){
        return a+b;
    }

    int multiply(int a, int b){
        return a*b;
    }

    /**
     * handle the result of a divide b
     *
     * @param a int a
     * @param b int b
     * @return a/b
     * @throws ArithmeticException if b is zero.
     */
    private int devide(int a, int b){
        if (0 == b)
            throw new ArithmeticException("adfadf");
        return a/b;
    }
}
