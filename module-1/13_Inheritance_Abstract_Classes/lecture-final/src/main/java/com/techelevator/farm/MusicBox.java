package com.techelevator.farm;

public class MusicBox implements Singable, Sellable {
    @Override
    public int getPrice() {
        return 22;
    }

    @Override
    public int calculateShipping(int distanceInMiles) {
        return 5;
    }

    @Override
    public String getSound() {
        return "lalalalalala";
    }

    @Override
    public String getName() {
        return "Music Box";
    }
}
