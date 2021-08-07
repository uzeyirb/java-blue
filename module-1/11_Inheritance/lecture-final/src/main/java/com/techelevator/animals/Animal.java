package com.techelevator.animals;

public class Animal {

    private String name;


    public Animal(String name) {
        this.name = name;
    }

    public String makeSound() {
        return "The " + name + " says ";
    }

    public String getName() {
        return this.name;
    }
}
