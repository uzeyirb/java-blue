package com.techelevator.farm;
/*
Final keyword with a class creates a class that cannot be extended as super class
 */
public abstract class Cat extends FarmAnimal {
//When Class extends another one we need to provide constructor
    public Cat() {
        super("Cat", "meow");
    }

    public Cat(String name, String sound) {
        super(name, sound);
    }

    /*
    getSound() cannot be Overridden because it is final FarmAnimal

     */
    /*@Override
    public String getSound(){

    return "MEOW!!!!";


    }*/

}
