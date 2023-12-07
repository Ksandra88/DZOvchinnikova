package pets;

import validators.NumberValidator;

import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Animal {
    protected String name = "";
    protected int age = -1;
    protected String color = null;
    protected int weight = -1;
    protected NumberValidator numberValidator = new NumberValidator();



    public Animal(int age, String name, int weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int getAgeWeightValidData(Scanner scanner){
        int data = -1;
        while (true){
            String ageStr = scanner.next();
            if (numberValidator.isNumber(ageStr, Pattern.compile("^\\d+$"))){
                data = Integer.parseInt(ageStr);
                if(data > 50 || data <= 0) {
                    System.out.println("Ошибка возраста!");
                    continue;
                }
                break;
            }
            System.out.println("Ошибка возраста!");

        }
        return data;
    }
    public void setAge(Scanner scanner) {


        this.age = this.getAgeWeightValidData(scanner);
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {

        return weight;
    }

    public void setWeight(Scanner scanner) {
        this.weight = this.getAgeWeightValidData(scanner);;
    }

    public void eat() {

        System.out.println("Я кушаю!");
    }

    public void say() {

        System.out.println("Я говорю!");
    }

    public void drink() {

        System.out.println("Я пью!");
    }

    public void go() {

        System.out.println("Я иду!");
    }

    @Override
    public String toString() {
        String yearPodeg = (String) getYearPodej();
          if (yearPodeg == null) {
             return "Возраст введен не верно!";
             }
            return String.format("Привет! меня зовут %s, мне %d %s, я вешу - %d кг, мой цвет - %s",
                    this.name,
                    this.age,
                    yearPodeg,
                    this.weight,
                    this.getColor());
        }
    private String getYearPodej() {

        if (this.age > 50) {
            return null;
        }
        if (this.age >= 11 && this.age <= 19) {
            return "лет";
        }
        int ostatok = this.age % 10;
        if (ostatok == 0 || ostatok >= 5) {
            return "лет";
        }

        if (ostatok == 1) {
            return "год";
        }

        return "года";
    }
}
