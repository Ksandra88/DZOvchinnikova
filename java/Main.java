import ColorData.Animaldata;
import ColorData.Commands;
import factory.AnimalFactory;
import pets.*;
import validators.CommandValidator;
import validators.NumberValidator;

import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animalList = new ArrayList<>();
        AnimalFactory animalFactory = new AnimalFactory();
        CommandValidator commandValidator = new CommandValidator();
        NumberValidator numberValidator = new NumberValidator();


        while (true) {
            System.out.println("Введите команду add/list/exit");
            String commandStr = scanner.next().toUpperCase().trim();

            if (!commandValidator.isValidate(commandStr, Commands.values())) {
                System.out.println("Вы ввели неверную команду!");
                continue;
            }
            Commands commands = Commands.valueOf(commandStr);

            switch (commands) {
                case ADD:
                    String animalTypeSTR = "";
                    while (true) {
                        System.out.println("Введите тип животного: cat/dog/duck");
                        animalTypeSTR = scanner.next().toUpperCase().trim();
                        if (CommandValidator.isValidate(animalTypeSTR, Animaldata.values())) {
                            break;
                        }
                        System.out.println("Вы ввели неверный тип животного!");
                    }

                    Animal animal = animalFactory.create(Animaldata.valueOf(animalTypeSTR));

                    System.out.println("Введите имя животного");
                    animal.setName(scanner.next());

                    System.out.println("Введите возраст животного");
                    animal.setAge(scanner);

                    System.out.println("Введите вес животного");
                    animal.setWeight(scanner);

                    System.out.println("Введите цвет животного");
                    String colorStr = scanner.next();

                    while (true) {
                        if (numberValidator.isNumber(colorStr, Pattern.compile("^[а-яА-Я]+$"))) {
                            animal.setColor(colorStr);
                            break;
                        }
                    }
                    animalList.add(animal);
                    animal.say();
                    animal.go();
                    animal.eat();
                    animal.drink();
                    if(animal instanceof Flying){
                        ((Flying) animal).fly();
                    }
                    break;

                case LIST:

                    if(animalList.isEmpty()){
                        System.out.println("Список пустой!");
                        continue;
                    }
                    for(Animal animalObject: animalList){
                        System.out.println(animalObject.toString());
                    }
                    break;
                case EXIT:
               System.exit(0);
            }
        }
    }
}
       // Cat cat1 = new Cat(3,"Мурка", 6, "Белый");
       // Dog dog1 = new Dog(7,"Шарик",10,"Рыжий");
      //  Duck duck1 = new Duck(2, "Утка", 3, "Серая");
      //  Fly fly1 = new Fly(2, "Муха", 1,"Зелёная");

     //   duck1.fly();
     //   fly1.Fly();

       // duck1.say();
      //  fly1.say();
       // cat1.say();
       // dog1.say();
    //}
        //}
