
package OCP.chapter2.interfaces;

public class Interfaces {
}

interface Walk {
    boolean isQuadruped();
    abstract double getMaxSpeed();
}

interface Run extends Walk {
    public abstract boolean canHuntWhileRunning();
    abstract double getMaxSpeed();
}

class Lion implements Run {
    public boolean isQuadruped() {
        return false;
    }

    public boolean canHuntWhileRunning() {
        return false;
    }

    public double getMaxSpeed() {
        return 0;
    }
}