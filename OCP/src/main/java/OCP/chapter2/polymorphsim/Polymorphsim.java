package OCP.chapter2.polymorphsim;

public  class Polymorphsim {

}

interface LivesInOcean {
    void makeSound();
}

class Dolphin implements LivesInOcean {
    public void makeSound() {
        System.out.println("whistle");
    }
}

class Whale implements LivesInOcean {
    public void makeSound() {
        System.out.println("Sing");
    }
}

class Oceanographer {

    public void checkSound(LivesInOcean livesInOcean){
        livesInOcean.makeSound();
    }
    public static void main(String[] args) {
        Oceanographer oceanographer = new Oceanographer();
        oceanographer.checkSound(new Dolphin());
        oceanographer.checkSound(new Whale());
    }
}

