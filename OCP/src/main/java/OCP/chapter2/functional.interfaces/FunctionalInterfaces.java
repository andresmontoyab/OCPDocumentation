package OCP.chapter2.functional.interfaces;

@FunctionalInterface
public interface FunctionalInterfaces {
    public void sprint(Object animal);
}

class Tiger implements FunctionalInterfaces {
    public void sprint(Object animal) {
        System.out.println("Animal is sprinting fast");
    }
}

