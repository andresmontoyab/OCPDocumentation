package OCP.chapter2.patterns;

public class FactoryPattern {

}

abstract class Food {
    private int quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract void consumed();
}

class Hay extends Food {
    public Hay(int quantity) {
        super(quantity);
    }

    @Override
    public void consumed() {
        System.out.println("Hay eaten : " + getQuantity());
    }
}

class Pellets extends Food {
    public Pellets(int quantity) {
        super(quantity);
    }

    @Override
    public void consumed() {
        System.out.println("Pellets eaten : " + getQuantity());
    }
}

class Fish extends Food {
    public Fish(int quantity) {
        super(quantity);
    }

    @Override
    public void consumed() {
        System.out.println("Fish eaten : " + getQuantity());
    }
}

class FoodFactory {
    public static Food getFood(String animalName) {
        switch (animalName) {
            case "Zebra": return new Hay(100);
            case "rabbit": return new Hay(100);
            case "goat": return new Hay(100);
            case "polar": return new Hay(100);
        }
    }
}

class ZooKeeper {
    public static void main(String[] args) {
        final Food food = FoodFactory.getFood("rabbit");
        food.consumed();
    }
}