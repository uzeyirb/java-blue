package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
	
		System.out.println("************************************");
		System.out.println("****** CREATING OBJECT ******");
		System.out.println("************************************");
		
		String strObject = new String();
		LegoPerson personOne = new LegoPerson("carpenter", "blue", true);
		LegoPerson personTwo = new LegoPerson("programmer", "blue", true);
		LegoPerson personThree = new LegoPerson("driver", "orange", true);
		LegoPerson personFour = new LegoPerson("painter", "green",true);


		String name = "Uzeyir Baghirov";
		String name2 = name.toUpperCase();



		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */

		
		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

		String hello1 = new String("hello");
		String hello2 = new String("hello");

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}
		
		
		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** STRING MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();



		String bootcamp = "Tech Elevator";
		System.out.println(bootcamp.length());
		System.out.println(bootcamp.charAt(5));
		System.out.println(bootcamp.substring(2,6));
		System.out.println(bootcamp.substring(bootcamp.indexOf("E")));


		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		

	}
}
