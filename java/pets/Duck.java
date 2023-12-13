package pets;

public class Duck extends Animal implements Flying {

    public Duck(int age, String name, int weight, String color) {
        super(age, name, weight, color);
    }

    public void say() {

        System.out.println("Кря");
    }
    public void fly(){

        System.out.println("Я утка, я лечу");
    }
}
