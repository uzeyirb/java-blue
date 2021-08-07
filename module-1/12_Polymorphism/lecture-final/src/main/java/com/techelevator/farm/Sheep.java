package com.techelevator.farm;

public class Sheep extends FarmAnimal implements Sellable {

    public Sheep() {
        super("Sheep", "baa!");
    }

    @Override
    public int getPrice() {
        return 200;
    }

    @Override
    public int calculateShipping(int distanceInMiles) {
        return 10 * distanceInMiles;
    }
}
