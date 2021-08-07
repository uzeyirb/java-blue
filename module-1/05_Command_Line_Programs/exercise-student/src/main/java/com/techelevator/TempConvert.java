package com.techelevator;

import java.util.Scanner;

public class TempConvert {
    /*
     * Step 1:  Get the User Input
     * Step 2: Calculate something
     * Step 3: Give feedback to the user
     */
    public static void main(String[] args) {
/*
1. Create a scanner for System in
2. Ask the user the temperature
3. Get the user input of the temperature
4. Convert the temperature to a numeric type
5. Ask the user if the temperature they entered is in C or F
6. If the user answers C then convert the temperature to F
7. If the user answers F then convert the temperature to C
8. Display the original temp and the converted

 */

        Scanner input = new Scanner(System.in); // here change scanner with input

        System.out.println("Welcome to Temperature Converter");

        // Prompt the user to enter Celsius or Fahrenheit
        // The answer needs to be saved as a double
        System.out.print("Is the temperature in (C)elsius, or (F)ahrenheit? F: ");
        String celsiusOrFahrenheit = input.nextLine();
        String temperatureFormatChosen = String.valueOf(celsiusOrFahrenheit);
        // Get the user input of the temperature

        System.out.print("Please enter the temperature: ");
        String temperatureEnteredByUser = input.nextLine(); // here changed scanner with input

        if (temperatureFormatChosen.equalsIgnoreCase("F")) {
            // f = Tc * 1.8 + 32 to a decimal to allow the calculation

            double temperatureInFahrenheit = (Double.parseDouble(temperatureEnteredByUser) - 32) / 1.8;
            // System.out.printf("%-14s %-14s %-14s %-6.0f %n", heightOfContainer , widthOfContainer, lengthOfContainer, packedCats);
            System.out.printf("Temperature Entered in Fahrenheit :" + temperatureEnteredByUser + "F" + " Temperature after conversion in Celsius: " + ((int) temperatureInFahrenheit) + "C");
        } else if (temperatureFormatChosen.equalsIgnoreCase("C")) {
            // Tc = (Tf - 32) / 1.8 T
            double temperatureInCelsius = (Double.parseDouble(temperatureEnteredByUser) * 1.8) + 32;

            System.out.printf("Temperature Entered in Celsius:" + temperatureEnteredByUser + "C" + " Temperature after conversion in Fahrenheit: " + ((int) temperatureInCelsius) + "F");
        }

    }


}







