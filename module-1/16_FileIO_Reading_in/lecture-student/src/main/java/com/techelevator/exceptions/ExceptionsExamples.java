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
            x = x + 10;
            y = 100;
        } catch (ArrayIndexOutOfBoundsException e) {
            //The catch block only runs if an exception of that type occurs
            System.out.println("The Array is out of bounds");
        } finally {
            // the finally block is always run
            y = 100;
        }

        String str = "124";


        try {
            str.toLowerCase();
            Integer.parseInt(str);
            str.charAt(10);
        } catch (NullPointerException e) {
            System.out.println("String was Null");
        } catch (NumberFormatException e) {
            System.out.println("String was not a number");
        }catch (Exception e){ // Can use Polymorphism to catch exceptions by their superclass
            System.out.println("Some other exceptions");
        }


        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number: ");

        String userInput = input.nextLine();

        int number = 0;

        try {
            System.out.println("Line 1");
            number = Integer.parseInt(userInput);
            System.out.println("Line 2");
        } catch (NullPointerException e) {
            System.out.println("Please enter a valid number!");
            System.out.println("Line 3");
        } catch (NumberFormatException e) {
            System.out.println("String was not a number");
        }
        System.out.println("Line 4");
        System.out.println("You entered " + number);


    }
}
