package com.techelevator.animals;

import com.techelevator.calculator.ScientificCalculator;

public class Dog extends Animal {

    /* IF the superclass has a constructor, then the subclass constructor must call it
    using super()

     */
    public Dog(){
        super("Dog"); //Call the constructor of the subclass
    }

    /*
    Inherited methods can be Overridden to provide functionality
    that is specific to the subclass.  The super keyword can be used in
    the subclass to invoke the super class’s version of an overridden method.
    To Override a superclass method, a method with an identical method signature is
    added to the subclass.
    Can override functionality inherited from the superclass int the subclass with the
    subclasses own version of that functionality
    In the override the subckas may cakk the original superclass verion of the method using
    super.method()

     */
    @Override
    public String makeSound(){
        return super.makeSound() + "Bark";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
