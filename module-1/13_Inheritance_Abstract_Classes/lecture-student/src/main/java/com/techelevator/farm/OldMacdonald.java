package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {
		/*
		FarmAnimal cannot be instantiated because it is an abstract class
		 */
	//	FarmAnimal genericAnimal = new FarmAnimal("abc", "xyz");

		Singable[] farmAnimals = new Singable[] {
				new Cow(), new Chicken(), new Sheep(),
				new Tractor(), new Duck(), new MusicBox(), new Cat() {
			@Override
			public void eat() {

			}

			@Override
			public boolean walk(int distance) {
				return false;
			}
		}};



		for (Singable animal : farmAnimals) {
			/*
			The java instanceof operator is used to test whether the object is an instance
			of the specified type (class or subclass or interface).
			The instanceof in java is also known as type comparison operator because it compares
			the instance with type. It returns either true or false.
			If we apply the instanceof operator with any variable that has null value,
			it returns false.
			 */
			if( animal instanceof FarmAnimal){
				FarmAnimal animalAsFarmAnimal = (FarmAnimal)animal;
				animalAsFarmAnimal.wake();

			}
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