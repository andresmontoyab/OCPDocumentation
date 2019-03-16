package OCP.chapter1.inner.classes;

public class PrivateInnerIneterface {
    private interface Secrete {
        public void shh();
    }

    class DontTell implements Secrete {
        public void shh() {

        }
    }
}
