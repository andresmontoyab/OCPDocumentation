package OCP.chapter1.inner.local.classes;

import OCP.chapter1.inner.classes.Outer;

public class InnerLocalClass {

    private int length = 5;
    String example = "almost final";
    public void calculate() {
        final int width = 20;
        class Inner {
            public void multiply() {
                System.out.println(length + width + example);
            }
        }
        Inner inner = new Inner();
        inner.multiply();
    }

    public static void main(String[] args) {
        InnerLocalClass innerLocalClass = new InnerLocalClass();
        innerLocalClass.calculate();
    }
}
