package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.println("Welcome To Fibonacci Detector: ");
        System.out.println("==============================");
        System.out.println("Please enter a number: ");
        int numberEnteredByUser = input.nextInt();
        if(numberEnteredByUser >= 1) {
            System.out.println("The Fibonacci numbers less than " + numberEnteredByUser + " are:");
            System.out.print("0, 1, 1");
            int fibonacciNumberAtIndexOne = 1;
            int fibonacciNumberAtIndexTwo = 1;
            for (int i = 1; i + fibonacciNumberAtIndexOne <= numberEnteredByUser; ) {
                fibonacciNumberAtIndexTwo = i + fibonacciNumberAtIndexOne;
                i = fibonacciNumberAtIndexOne;
                fibonacciNumberAtIndexOne = fibonacciNumberAtIndexTwo;
                System.out.print(", " + fibonacciNumberAtIndexTwo );
            }

        }
        else {
            System.out.print("0, 1 ");
        }
        }

        }










