package com.techelevator.example;
import java.util.Scanner;
import java.util.SortedMap;

public class CatPackingCalculator {
   /*
    * 1. Take Input
    * 2. Calculate Data
    * 3. Give Output
    * */


    public static void main(String[] args) {
        double avgVolumeOfHouseCat = 0.083;
        double estimatedPackingDensityOfCat = 0.5;
        Scanner input = new Scanner(System.in);

        // 1. Ask the user the dimensions of the container
        System.out.println("What is the length of the container in feet: ");
        String userLengthOfContainer = input.nextLine();
        double lengthOfContainer = Double.parseDouble(userLengthOfContainer);


        /* System.out.print("What is the width of the container in feet: ");
        //Can have scanner do the parsing for us, but then must call nextLine() to cleanup the trailing carriage return
        double withOfContainer =input.nextDouble();
        input.nextLine();*/

        System.out.println("What is the width of the container in feet:  ");
        String userWidthOfContainer = input.nextLine();
        double widthOfContainer = Double.parseDouble(userWidthOfContainer);

        System.out.println("What is the height of the container in feet: ");
        String  userHeightOfContainer =input.nextLine();
        double heightOfContainer = Double.parseDouble(userHeightOfContainer);


        // 2. Calculate how many cats will fit in a container with those dimensions
        double containerVolume = lengthOfContainer * widthOfContainer * heightOfContainer;
        double  catByVolume = containerVolume / avgVolumeOfHouseCat;
        double packedCats = catByVolume * estimatedPackingDensityOfCat;

        // 3. Output the result to the user
        System.out.printf("%-15s %-15s %-15s %-25s %n", "Height", "Width", "Length", "Cats in Box");
        System.out.println("======================================================");
        System.out.printf("%-14s %-14s %-14s %-6.0f %n", heightOfContainer , widthOfContainer, lengthOfContainer, packedCats);

        /*

            Height       Width      Length        Cats in Box
            --------------------------------------------------
              10            12          15          1000
         */

    }
}
