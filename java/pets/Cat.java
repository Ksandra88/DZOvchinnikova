package pets;

public class Cat extends Animal {
    public Cat(int age, String name, int weight, String color) {
        super(age, name, weight, color);
    }

     public void say() {

        System.out.println("Мяу");
    }
}
