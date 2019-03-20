package OCP.chapter2.patterns;

import java.util.Arrays;
import java.util.List;

public class AnimalBuilder {

    private String species;
    private int age;
    private List<String> favoriteFoods;

    public AnimalBuilder setSpecies(String species) {
        this.species = species;
        return this;
    }

    public AnimalBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public AnimalBuilder setFavoriteFoods(List<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
        return this;
    }

    public Animal build() {
        return new Animal(this.species, this.age, this.favoriteFoods);
    }

    public static void main(String[] args) {
        AnimalBuilder animalBuilder = new AnimalBuilder();
        Animal cat = animalBuilder
                .setAge(15)
                .setSpecies("Feline")
                .setFavoriteFoods(Arrays.asList("Bread", "etc"))
                .build();

    }
}

class Animal {
    private String species;
    private int age;
    private List<String> favoriteFoods;

    public Animal(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;
        this.favoriteFoods = favoriteFoods;
    }
}


