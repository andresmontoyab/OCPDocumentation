package OCP.chapter1.inner.classes;

public class OuterTwo {
    private int x = 10;
    class B {
        private int x = 20;
        class C {
            private int x = 30;
            public void allTheX() {
                System.out.println(x);
                System.out.println(this.x);
                System.out.println(B.this.x);
                System.out.println(OuterTwo.this.x);
            }
        }
    }

    public static void main(String[] args) {
        OuterTwo outerTwo = new OuterTwo();
        OuterTwo.B b = outerTwo.new B();
        OuterTwo.B.C c = b.new C();
        c.allTheX();
    }
}
