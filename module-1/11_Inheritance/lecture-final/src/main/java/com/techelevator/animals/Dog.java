package com.techelevator.animals;

/*
extends keyword defines this class's superclass
 */
public class Dog extends Animal {

    /*
    IF the superclass has a constructor, then the
    subclass constructor must call it using super()
     */
    public Dog() {
        super("Dog");  // Calls the constructor of the subclass
    }

    /*
    Can Override functionality inherited from the superclass
    in the subclass with the subclasses own version of that
    functionality.

    In the Override the subclass may call the original superclass
    version of the method using super.method()
     */
    @Override
    public String makeSound() {
        // calls the original Animal makeSound() using the super keyword
        return super.makeSound() + "Bark";
    }


}
