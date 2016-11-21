package polymorphic;

/**
 * Description:
 * Created by lvhw on 2016/7/30 23:09.
 */
public class ConcreteClassAB implements InterfaceAB {

    public static void main(String[] args) {
        InterfaceA ia = new ConcreteClassAB();
        ia.funA();
    }

    @Override
    public void funAB() {
        System.out.println("funAB");
    }

    @Override
    public void funA() {
        System.out.println("funA");

    }

    @Override
    public void funB() {
        System.out.println("funB");

    }
}
