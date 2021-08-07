package com.techelevator.farm;

public class Cow extends FarmAnimal implements Sellable {

	public Cow() {

		super("Cow", "moo!");
	}

	@Override
	public int getPrice() {
		return 1500;
	}

	@Override
	public int calculateShipping(int distanceInMiles) {
		return 0;
	}



}