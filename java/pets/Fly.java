package pets;

public class Fly extends Animal implements Flying {
    public Fly(int age, String name, int weight, String color) {
        super(age, name, weight, color);
    }

    public void say(){

        System.out.println("Кря");
    }
    public void Fly(){

        System.out.println("Я утка, я лечу");
    }

    @Override
    public void fly() {

    }
}
