package com.techelevator.fizzbuzz;

public class FizzBuzz {

    /*
    Given a number
    Return Fizz if the number is a multiple of 3
    Return Buzz if the number is a multiple of 5
    Return FizzBuzz if the number is a multiple of both 3 and 5
    Otherwise return the original number
     */

    private final static int FIZZ_NUMBER = 3;
    private final static int BUZZ_NUMBER = 5;

    public String fizzBuzzIt(int number) {

        if (isFizz(number) && isBuzz(number)) {
            return "FizzBuzz";
        }

        if (isFizz(number)) {
            return "Fizz";
        }

        if (isBuzz(number)) {
            return "Buzz";
        }

        return String.valueOf(number);
    }

    private boolean isBuzz(int number) {
        return number % BUZZ_NUMBER == 0;
    }

    private boolean isFizz(int number) {
        return number % FIZZ_NUMBER == 0;
    }

}
