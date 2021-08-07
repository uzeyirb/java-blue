package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a decimal integer
        System.out.println("Please enter in a series of decimal values (separated by spaces): ");
        String decimalValuesSpacesInBetweenEnteredByUser = input.nextLine();
        //Bellow line uses array method called split in order to omit spaces and then store them in an array
        String[] decimalsEnteredStoredInArrayWithoutSpaces = decimalValuesSpacesInBetweenEnteredByUser.split(" ");

        for (int i = 0; i < decimalsEnteredStoredInArrayWithoutSpaces.length; i++) {
            /* Apart from int which is primitive data type Integer is wrapper class which wraps a primitive type int
            into an object. here we have used Integer wrapper class to convert int inside our array into object
            * */
            int decimalEnteredByUserUsedInMethod = Integer.parseInt(decimalsEnteredStoredInArrayWithoutSpaces[i]);
            System.out.print(decimalEnteredByUserUsedInMethod + " in binary is ");
            decimalToBinary(decimalEnteredByUserUsedInMethod);
            System.out.println(" ");

        }

    }

    public static void decimalToBinary(int decimalEnteredByUserUsedInMethod) {
        String binary = "";    // Holds the binary value
        //Logic behind the for loop is binary code starts right to left that is why we start looping from right to left
        for (int i = decimalEnteredByUserUsedInMethod; i > 0; i /= 2) {  // means divide i by 2 and put the result in i
            binary = (i % 2) + binary;
        }

        // Display the corresponding binary value of the decimal integer
        System.out.println( binary);

    }

}


