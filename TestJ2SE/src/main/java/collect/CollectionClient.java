package collect;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * Created by lvhw on 2016/8/11 23:22.
 */
public class CollectionClient {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("lv");
        list.add("hong");
        list.add("wei");

        //list.forEach(s->System.out.print("_" + s));
        //System.out.println(list);

        int[] arr = new int[10];
        Arrays.fill(arr, 100);

        for (int i : arr) {

        }


        System.out.println(Arrays.toString(arr));
    }
}
