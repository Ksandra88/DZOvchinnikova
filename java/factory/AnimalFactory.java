package factory;

import colorData.Animaldata;
import pets.Animal;
import pets.Cat;
import pets.Dog;
import pets.Duck;

public class AnimalFactory {
    private String name = "";
    private int age = -1;
    private int weight = -1;
    private String color = null;

    public AnimalFactory animalFactory(int age, String name, int weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;

        return null;
    }


    public Animal create (Animaldata animaldata) {
        switch (animaldata) {
            case CAT:
                return new Cat(this.age, this.name, this.weight, this.color);
            case DOG:
                return new Dog(this.age, this.name, this.weight, this.color);
            default:
                return new Duck(this.age, this.name, this.weight, this.color);
        }
    }
}
