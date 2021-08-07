package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Linear Converter");

        // Prompt the user to enter Meter or Foott
        // The answer needs to be saved as a double
        System.out.print("Is the measurement is in Meter (M), or Foot(F)?: ");
        String metersOrFootChosenByUser = input.nextLine();
        String temperatureFormatChosen = String.valueOf(metersOrFootChosenByUser);
        System.out.print("Please enter the length: ");
        String lengthEnteredByUser = input.nextLine(); // here changed scanner with input

        if (temperatureFormatChosen.equalsIgnoreCase("F")) {
            // m = f * 0.3048
            double lengthInFoot = Double.parseDouble(lengthEnteredByUser) * 0.3047;

            System.out.printf("Length Entered in Foot :" + lengthEnteredByUser + "f" + " Length after conversion in Meters: " + ((int) lengthInFoot) + "m");
        } else if (temperatureFormatChosen.equalsIgnoreCase("M")) {
            // f = m * 3.2808399
            double lengthInMeters = Double.parseDouble(lengthEnteredByUser) * 3.2808399;

            System.out.printf("Length Entered in Meters:" + lengthEnteredByUser + "m" + " Length after conversion in Foot: " + ((int) lengthInMeters) + "f");
        }

    }


}


