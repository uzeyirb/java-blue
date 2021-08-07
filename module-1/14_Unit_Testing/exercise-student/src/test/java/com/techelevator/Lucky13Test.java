package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

public class Lucky13Test {

     /*
        An instance variable to reference the class we are testing.
        We cannot test interfaces and abstract classes.
        always test only concrete classes; don’t test abstract classes
        directly. The reason is that abstract classes are implementation
        details. From the client perspective, it does not matter how Student
        or Professor implement their GetSignature() methods. They could derive it
        from a base class like in our case, but they could also just implement their
        own copy of it. Targeting tests at the abstract base class binds them to the
        code’s implementation details. This, in turn, makes those tests fragile.
        */

    private Lucky13 lucky13;


    @Before
     /*
    Methods annotated with the @Before annotation are run before each test.
     This is useful when we want to execute some common code before running a test.
     */

    public void set() {
        lucky13 = new Lucky13();
    }

    @After

    public void cleanup() {

        //do code that cleans up or resets here
    }

    /*
    Tests For less20

    nums                 expectedResult
    0, 2, 4             true
   1, 2, 3              false
   1, 2, 4              false
    null               ??false
     */

    /*
   An assertion Error is thrown when say "You have written a code that should not execute
   at all costs because according to you logic it should not happen. BUT if it happens
   then throw AssertionError. And you don't catch it." In such a case you throw an
   Assertion error.
    */

    @Test
    public void true_when_no_one_or_three_true() {
        //Arrange
        int[] actualResult = {0, 2, 4};

        boolean result = lucky13.getLucky(actualResult);
        //Act
        Assert.assertEquals(true, result);


    }


    @Test
    public void false_when_there_is_one_no_three_false() {
        //Arrange
        int[] actualResult = {1, 2, 4};

        boolean result = lucky13.getLucky(actualResult);
        //Act
        Assert.assertEquals(false, result);


    }

    @Test
    public void false_when_there_is_three_no_one_false() {
        //Arrange
        int[] actualResult = {3, 2, 3};

        boolean result = lucky13.getLucky(actualResult);
        //Act
        Assert.assertEquals(false, result);


    }

    @Test
    public void true_when_there_is_only_zeros() {
        //Arrange
        int[] actualResult = {0, 0, 0};

        boolean result = lucky13.getLucky(actualResult);
        //Act
        Assert.assertEquals(true, result);


    }
}
