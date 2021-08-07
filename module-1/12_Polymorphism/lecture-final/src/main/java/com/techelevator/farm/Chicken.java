package com.techelevator.farm;

public class Chicken extends FarmAnimal implements Sellable {

	public Chicken() {
		super("Chicken", "cluck!");
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

	@Override
	public int getPrice() {
		return 20;
	}

	@Override
	public int calculateShipping(int distanceInMiles) {
		return distanceInMiles;
	}
}