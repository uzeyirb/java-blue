package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {


		Singable[] farmAnimals = new Singable[] {
				new Cow(), new Chicken(), new Sheep(),
				new Tractor(), new Duck(), new MusicBox() };

		for (Singable animal : farmAnimals) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		List<Sellable> itemsForSale = new ArrayList<Sellable>();
		itemsForSale.add( new Chicken() );
		itemsForSale.add( new Cow() );
		itemsForSale.add( new Sheep() );
		itemsForSale.add( new MusicBox() );

		System.out.println("Items for sale:");
		for (Sellable items : itemsForSale) {
			System.out.println(items.getName() + ": $" + items.getPrice());
			System.out.println("Shipped 10 miles for " + items.calculateShipping(10));
		}

		/*
		Seen as a chicken it has: layEgg(), getPrice(), calculateShipping()
		     getSound(), getName
		 */
		Chicken chicken = new Chicken();

		/*
		Chicken seen as a FarmAnimal has:  getSound(), getName()
		 */
		FarmAnimal chickenAsFarmAnimal = chicken;

		/*
		Chicken seen as a Singable has:  getSound(), getName()
			- only the methods listed on the Singable interface
		 */
		Singable chickenAsSingable = chicken;

		/*
		Chicken seen as a Sellable has:  getPrice(), getName(),
		   calculateShipping()
		    - only the methods listed on the Sellable interface
		 */
		Sellable chickenAsSellable = chicken;


	}
}