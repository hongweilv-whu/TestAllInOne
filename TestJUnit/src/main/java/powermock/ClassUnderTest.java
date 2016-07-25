package powermock;

import java.io.File;

/**
 *
 * Created by lvhw on 2016/7/10.
 */
public class ClassUnderTest {
    public boolean callInternalInstance(String path) {

        File file = new File(path);
        return file.exists();
    }
}
