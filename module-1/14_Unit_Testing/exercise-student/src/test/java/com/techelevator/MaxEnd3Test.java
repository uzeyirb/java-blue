package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxEnd3Test {

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

    private MaxEnd3 maxEnd3;

    @Before
     /*
    Methods annotated with the @Before annotation are run before each test.
     This is useful when we want to execute some common code before running a test.
     */

    public void setup() {
        maxEnd3 = new MaxEnd3();
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
    Tests For MaxEnd3

    int[]               expected
    [1, 2, 3]           [3, 3, 3]
    [11, 5, 9]          [11, 11, 11]
    [0, 0, 0]           [0, 0, 0]
     */

     /*
   An assertion Error is thrown when say "You have written a code that should not execute
   at all costs because according to you logic it should not happen. BUT if it happens
   then throw AssertionError. And you don't catch it." In such a case you throw an
   Assertion error.
    */

    @Test
    public void true_when_max_max_max_case1() {
        //Arrange
        int[] actualResult = {1, 2, 3};
        int[] result = {3, 3, 3};
        //Act
        Assert.assertArrayEquals(result, maxEnd3.makeArray(actualResult));

    }

    @Test
    public void true_when_max_max_max_case2() {
        //Arrange
        int[] actualResult = {11, 5, 9};
        int[] result = {11, 11, 11};
        //Act
        Assert.assertArrayEquals(result, maxEnd3.makeArray(actualResult));

    }

    @Test
    public void true_when_max_max_max_case_zero() {
        //Arrange
        int[] actualResult = {0, 0, 0};
        int[] result = {0, 0, 0};
        //Act
        Assert.assertArrayEquals(result, maxEnd3.makeArray(actualResult));

    }
}
