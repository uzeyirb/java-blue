package com.techelevator.animals;

import com.techelevator.calculator.Calculator;

import javax.crypto.AEADBadTagException;
import java.util.ArrayList;
import java.util.List;

public class AnimalSoundsApp {

    public static void main(String[] args) {
        Animal animal = new Animal("name");
        Dog dog = new Dog();
        System.out.println(dog.getName());
        System.out.println(dog.makeSound());

        Cat cat = new Cat();
        System.out.println(cat.getName());
        System.out.println(cat.makeSound());

        Fido fido = new Fido();
        System.out.println(fido.getName());
        System.out.println(fido.makeSound());

        /*
        Upcasting widening is when a subclass is cast to a superclass.
        Once cast, it will only have access to the functionality available from the
        Superclass
        * */
        Animal dogAsAnimal = (Animal) dog;
        System.out.println(dogAsAnimal.getName());

        /* Casting cat as object allows only access to the methods that are part of Object,
        however, the object in memory is still a cat
         */
        Object catAsObject  = cat;

        /* Downcasting (narrowing) it casting from superclass to subclass
        Must be explicitly cast using ()
         */
        Animal catThatWasAnObject = (Animal) catAsObject;

        /* Since String cannot be the data type animal this will cause a classCastException

         */
        // Animal thisIsNotAnAnimal = (Animal) stringAsObject;


       /* public void isAnimalACat(Animal animal){

        // variable instanceOf dataType
            // instance of returns true if the object being
            // referenced by the variabel can be cast as given data type.
            if(animal instanceof Cat) {
                cat = (Cat) animal;
            }
        }*/

        /*
        Below this is POLYMORPHISM with Inheritance
        */

        List<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(cat);
        animals.add(fido);

        System.out.println("Polymorphic animal sounds");

        for(Animal currentAnimal: animals){
            System.out.println(currentAnimal.makeSound());

        }
    }
}
