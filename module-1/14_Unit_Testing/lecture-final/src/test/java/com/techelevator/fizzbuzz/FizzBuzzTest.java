package com.techelevator.fizzbuzz;

import org.junit.*;

/*
    Given a number
            Return Fizz if the number is a multiple of 3
            Return Buzz if the number is a multiple of 5
            Return FizzBuzz if the number is a multiple of both 3 and 5
            Otherwise return the original number

 */
public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void createFizzBuzz() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void fizz_if_number_multiple_of_3() {
        Assert.assertEquals("Fizz", fizzBuzz.fizzBuzzIt(3));
        Assert.assertEquals("Fizz", fizzBuzz.fizzBuzzIt(9));
        Assert.assertEquals("Fizz", fizzBuzz.fizzBuzzIt(-6));
    }

    @Test
    public void buzz_if_number_multiple_of_5() {
        Assert.assertEquals("Buzz", fizzBuzz.fizzBuzzIt(5));
        Assert.assertEquals("Buzz", fizzBuzz.fizzBuzzIt(10));
        Assert.assertEquals("Buzz", fizzBuzz.fizzBuzzIt(-20));
    }

    @Test
    public void fizzbuzz_if_number_multiple_of_3_and_5() {
        Assert.assertEquals("FizzBuzz", fizzBuzz.fizzBuzzIt(15));
    }

    @Test
    public void original_number_if_not_multiple_of_3_or_5() {
        Assert.assertEquals("4", fizzBuzz.fizzBuzzIt(4));
    }
}
