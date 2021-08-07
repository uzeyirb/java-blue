package com.techelevator.exceptions;

import java.util.Locale;
import java.util.Scanner;

public class ExceptionsExamples {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        int x = 0;
        int y = 0;

        /*
        Try block identifies code that is at risk of throwing an exception
        If the exception occurs the code after the line it was thrown on will be skipped
         */
        try {
            x = nums[3];
            x = x + 10; // This line only runs if there is no exception on the line above it
        } catch (ArrayIndexOutOfBoundsException e) {
            // The catch block only runs if an exception of that type occurs
            System.out.println("The Array is out of bounds");
        } finally {
            // the finally block is always run
            y = 100;
        }

        System.out.println(x);
        System.out.println(y);


        String str = "123";

        try {
            str.toUpperCase();
            Integer.parseInt(str);
            str.charAt(10);
        } catch (NullPointerException e) {
            System.out.println("String was null");
        } catch (NumberFormatException e) {
            System.out.println("String was not a number");
        } catch (Exception e) {  // Can use Polymorphism to catch exceptions by their superclass
            System.out.println("Some other error happened");
        }



        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Enter a number: ");
            String userInput = input.nextLine();

            int number = 0;

            try {
                System.out.println("Line 1");
                number = Integer.parseInt(userInput);
                System.out.println("Line 2");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                System.out.println("Line 3");
            }
            System.out.println("Line 4");
            System.out.println("You entered " + number);
        }
    }

}
