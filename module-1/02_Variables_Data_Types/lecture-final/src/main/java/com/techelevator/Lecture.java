package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		/* Declaration contains the DataType and Name
		*  Declaration creates the variable (Box) and defines what it can store */
		int numberOfExercises;

		/* Assignment puts a value into a variable.  Can occur on the same line or a difference one */
		numberOfExercises = 26;

		System.out.println(numberOfExercises);

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		double half = 0.5;
		System.out.println(half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/
		String name = "\tTechElevator\n";

		System.out.println(name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		int seasonsOfFirefly = 1;
		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage = "Java";
		System.out.println(myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
		float pi = 3.1416F;
		System.out.println(pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		String firstName = "Brian";
		String lastName = "Lauvray";
		System.out.println(firstName + lastName);
		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		int numberOfMouseButtons = 3;
		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		byte remainingBatteryInPercentage;

		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int difference = 121 - 27;
		System.out.println(difference);
		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double sum = 12.3 + 32.1;
		System.out.println(sum);
		/*
		12. Create a String that holds your full name.
		*/
		String nameFirst = "first";
		String nameLast = "last";
		String fullName = nameFirst + " " + nameLast;
		System.out.println(fullName);
		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String hello = "Hello, ";
		System.out.println(  hello + fullName );
		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		fullName = fullName + " Esquire";
		System.out.println( fullName );
		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		fullName = fullName + " Esquire";
		fullName += " Esquire";
		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String saw = "Saw";
		saw += 2;
		System.out.println( saw );
		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		int zero = 0;
		saw += zero;
		System.out.println( saw );

		/* Widening */
		int integerNumber = 10;
		long longNumber = integerNumber;

		/* Narrowing */
		long smallLongValue = 10;
		int integer = (int) smallLongValue;


		/*
		18. What is 4.4 divided by 2.2?
		*/
		double result = 4.4 / 2.2;
		System.out.println(result);

		/*
		19. What is 5.4 divided by 2?
		*/
		result = 5.4 / 2;
		System.out.println(result);
		/*
		20. What is 5 divided by 2?
		*/

		double resultOne = 5 / 2;
		System.out.println(resultOne);

		/*
		21. What is 5.0 divided by 2?
		*/
		resultOne = 5.0 / 2;
		System.out.println(resultOne);

//		int a;
//		int b;
//
//		double c = (double) a / b;

		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		double divided = 66.6 / 100;
		System.out.println( divided );
		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		int remainder = 5 % 2;
		System.out.println( remainder );

		remainder = 19 % 10;
		System.out.println( remainder );

		/*
		24. What is 1,000,000,000 * 3?
		*/
		int largeNumber = 1000000000 * 3;
		System.out.println(largeNumber);
		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
		boolean isDoneWithExercises = false;
		/*
		26. Now set doneWithExercise to true.
		*/
		isDoneWithExercises = true;
		System.out.println(isDoneWithExercises);
		
	}

}
