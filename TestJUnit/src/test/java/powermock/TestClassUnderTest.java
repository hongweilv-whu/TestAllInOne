package powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * Created by lvhw on 2016/7/10.
 */
@RunWith(PowerMockRunner.class)
public class TestClassUnderTest {

    @Test
    @PrepareForTest(BaseFieldTestHong.class)
    public void testGetName(){
        /*MyInterface my = PowerMockito.mock(MyInterface.class);
        PowerMockito.when(my.getUserName()).thenReturn("lhw");

        System.out.println(my.getUserName());*/

        BaseFieldTestHong my = PowerMockito.mock(BaseFieldTestHong.class);
        PowerMockito.when(my.getDbObjName()).thenReturn("lhw");

        System.out.println(my.getDbObjName());
    }
}