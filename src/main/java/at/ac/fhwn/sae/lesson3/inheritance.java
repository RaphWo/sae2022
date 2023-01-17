package at.ac.fhwn.sae.lesson3;

import java.util.ArrayList;
import java.util.List;

public class inheritance {

    public static void main(String[] args){
        Dog dog = new Dog("Rex");
        Dog noNameDog = new Dog();
        dog.setName("Hugo");
//        System.out.println(dog.getName());
//        System.out.println(noNameDog.getName());
//        dog.bark();

        Cat cat = new Cat();
//        System.out.println(cat.getName());
//        System.out.println(Dog.getCount());
//        System.out.println(dog.getId());
//        System.out.println(noNameDog.getId());

        List<Animal> list = new ArrayList<>();
        list.add(dog);
        list.add(noNameDog);
        list.add(cat);

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).name);
        }
        for (Animal animal:list) {
            System.out.println(animal.name);
            if (animal instanceof Dog){
                ((Dog) animal).bark();
            }
        }
        Person p = buildPerson(42, "Anton");
    }
    static Person buildPerson(int number, String name){
        Person person = new Person(number, name);
        return person;
    }
}
