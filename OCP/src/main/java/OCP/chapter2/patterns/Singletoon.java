package OCP.chapter2.patterns;

public class Singletoon {
}

class HayStorage {
    private int quantiyt;
    private HayStorage() {

    }

    private static final HayStorage instance = new HayStorage();

    public static HayStorage getInstance() {
        return instance;
    }

    public synchronized void addHay(int amount) {
        quantiyt += amount;
    }
}
