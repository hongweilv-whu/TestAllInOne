package exceptions;

import java.util.Arrays;

/**
 * Description:
 * Created by lvhw on 2016/8/12 22:53.
 */
public class ArrayClient {

    public static void main(String[] args) {
        int[] arry = new int[]{1,2,3};
        System.out.println(arry);
        System.out.println(arry.getClass().getName());

        Integer[] boxArray = {1,2,3};
        System.out.println(boxArray);
        System.out.println(boxArray.getClass().getName());

        int[] ar3 = new int[3];
        Arrays.fill(ar3, 1);
        System.out.println(ar3);
    }

}

