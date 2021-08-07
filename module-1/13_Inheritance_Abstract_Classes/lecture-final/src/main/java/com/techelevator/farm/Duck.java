package com.techelevator.farm;

public class Duck extends FarmAnimal {

    public Duck() {
        super("Duck", "Quack!");
    };

    @Override
    public void eat() {

    }

    @Override
    public boolean walk(int distance) {
        return false;
    }
}
