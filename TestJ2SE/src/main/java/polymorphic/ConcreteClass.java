package polymorphic;

/**
 * Description:
 * Created by lvhw on 2016/7/30 23:09.
 */
public class ConcreteClass extends ConcreteClassAB {
    @Override
    public void funB() {
        System.out.println("funB in ConcreteClass");
    }

    public static void main(String[] args) {
        InterfaceB ib = new ConcreteClass();
        ib.funB();
    }
}
