package OCP.chapter1.inner.Static.nestedclass;

public class StaticInnerClass {

    public int suma(Integer a) {
        System.out.println("Integer");
        return a + 3;
    }

    public long suma(long a) {
        System.out.println("long");
        return a + new Long(3);
    }

    public static void main(String[] args) {
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        System.out.println(staticInnerClass.suma(2));
    }
}
