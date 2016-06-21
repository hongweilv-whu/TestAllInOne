import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lvhw on 2016/6/12.
 */
public class TestClient {
    public static void main(String[] args) {

        List<Integer> lists = new ArrayList<>();
        List<Integer> other = Arrays.asList(1,2,3);
        List<Integer> third = null;

        lists.addAll(third);
    }
}
