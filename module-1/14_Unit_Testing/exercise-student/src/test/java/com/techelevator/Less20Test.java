package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class Less20Test {


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


    private Less20 less20;

    @Before
     /*
    Methods annotated with the @Before annotation are run before each test.
     This is useful when we want to execute some common code before running a test.
     */
    public void setup() {
        less20 = new Less20();
    }



    /*
    Methods annotated with the @After annotation are run after each test.
     This is useful when we want to execute some common code after running a test.
     */

    @After

    public void cleanup() {

        //do code that cleans up or resets here
    }

    /*
    Tests For less20

    int    lessThan20    expectedResult
    18          true        true
    19          true        true
    20          false       false
    121         false       false
     */

    /*
   An assertion Error is thrown when say "You have written a code that should not execute
   at all costs because according to you logic it should not happen. BUT if it happens
   then throw AssertionError. And you don't catch it." In such a case you throw an
   Assertion error.
    */

    @Test
    public void true_when_less_than_20_true() {
        //Arrange
        boolean actualResult = less20.isLessThanMultipleOf20(19);
        //Act
        Assert.assertEquals(true, actualResult);

    }


    @Test
    public void true_when_less_than_20_false() {
        //Arrange
        boolean actualResult = less20.isLessThanMultipleOf20(20);
        //Act
        Assert.assertEquals(true, actualResult);

    }

    @Test
    public void true_when_less_than_201_false() {
        //Arrange
        boolean actualResult = less20.isLessThanMultipleOf20(201);
        //Act
        Assert.assertEquals(false, actualResult);

    }

}
