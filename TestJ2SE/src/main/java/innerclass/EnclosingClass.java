package innerclass;

/**
 *
 * Created by lvhw on 2016/6/11.
 */
public class EnclosingClass {

    private String name;
    private int age;

    private static int count = 0;

    private InnerClass ic = null;

    private enum FileType{
        TXT, XLS
    }

    private static class StaticInClass {

        private void f(EnclosingClass ec){
            System.out.println(ec.name);
            System.out.println(count);
        }
    }

    public class InnerClass {

        @Override
        public String toString() {
            //return name+"InnerClass";
            //return name + age;
            return EnclosingClass.this.name + EnclosingClass.this.age;
        }
    }

    public void fun(int aPra, String b, Integer it){
        System.out.println(".........");
        ic = new InnerClass();

        String temp = "temp";

       abstract class LocalClass {

            private void foo(){

                System.out.println(aPra + b + count + it);
            }
        }

        class MyImpl extends LocalClass{

        }

    }
}
