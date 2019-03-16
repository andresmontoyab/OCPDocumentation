package OCP.chapter1.inner.Static.nestedclass;

public class StaticInnerClass {
    static class Nested {
        private int a = 6;
    }

    public static void main(String[] args) {
        Nested nested = new Nested();
        System.out.println(nested.a);
    }
}
