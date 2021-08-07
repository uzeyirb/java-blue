package com.techelevator.animals;

import java.util.ArrayList;
import java.util.List;

public class AnimalSoundsApp {

    public static void main(String[] args) {


        Animal animal = new Animal("name");

        Dog dog = new Dog();

        System.out.println( dog.getName() );
        System.out.println( dog.makeSound() );

        Cat cat = new Cat();

        System.out.println( cat.getName() );
        System.out.println( cat.makeSound() );

        Fido fido = new Fido();
        System.out.println( fido.getName() );
        System.out.println( fido.makeSound() );

        /*
        Upcasting (widening) is when a subclass is cast
        to a superclass.  Once cast, it will only have access
        to the functionality available from the superclass
         */
        Animal dogAsAnimal = dog;
        System.out.println( dogAsAnimal.getName());
        System.out.println( dogAsAnimal.makeSound() );
        /*
        Casting Cat as Object allows only access to the methods
        that are part of Object, however, the object in memory
        is still a Cat
         */
        Object catAsObject = cat;
        Object stringAsObject = new String("test");

        /*
        Downcasting (narrowing) it casting from superclass to subclass.
        Must be explicitly cast using ()
         */
        Animal catThatWasAnObject = (Animal) catAsObject;

        /*
        Since String cannot be the data type Animal this
        will cause a ClassCastException
         */
        //Animal thisIsNotAnAnimal = (Animal) stringAsObject;

        /*
             Below this is  POLYMORPHISM WITH INHERITANCE
         */
        Animal anotherDog = new Dog();

        List<Animal> animals = new ArrayList<Animal>();
        animals.add(dog);
        animals.add(cat);
        animals.add(fido);
        animals.add(anotherDog);

        System.out.println(" Polymorphic animal sounds ");

        for (Animal currentAnimal: animals) {
            System.out.println( currentAnimal.makeSound() );
        }

        // Polymorphism without a loop
        Animal someAnimal = new Cat();
        System.out.println( someAnimal.makeSound() );

        isAnimalACat(someAnimal);
    }

    public static void isAnimalACat(Animal x) {
        // variable instanceof dataType
        // instanceof returns true if the object being
        // referenced by the variable can be cast as the given data type
        if (x instanceof Cat) {
            Cat cat = (Cat) x;
        }
    }

}
