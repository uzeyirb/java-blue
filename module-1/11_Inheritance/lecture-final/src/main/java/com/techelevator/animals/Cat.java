package com.techelevator.animals;

public class Cat extends Animal {

    public Cat() {
        super("Cat");
    }

    @Override
    public String makeSound() {
        return "MEOW!";
    }

}
