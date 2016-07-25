package math;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lvhw on 2016/7/23.
 */
public class AlgorithemTest {

    @Test
    public void testAdd() throws Exception {

        Algorithem a = new Algorithem();
        System.out.println(a.add(1, 2));
    }

    @Test
    public void testMultiply() throws Exception {
        Algorithem a = new Algorithem();
        System.out.println(a.multiply(1, 2));
    }
}