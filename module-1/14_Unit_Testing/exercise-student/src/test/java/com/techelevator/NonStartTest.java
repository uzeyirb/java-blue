package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NonStartTest {

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

    private NonStart nonStart;

    @Before
     /*
    Methods annotated with the @Before annotation are run before each test.
     This is useful when we want to execute some common code before running a test.
     */
    public void setup() {
        nonStart = new NonStart();
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
   An assertion Error is thrown when say "You have written a code that should not execute
   at all costs because according to you logic it should not happen. BUT if it happens
   then throw AssertionError. And you don't catch it." In such a case you throw an
   Assertion error.
    */

    /*
    Tests for NonStartTest

    Given                       Expected
    "Hello", "There"            "ellohere"
    "java", "code"              "avaode"
     "sh", "ja"                     "ha"
     */


    @Test
    public void get_partial_string_result_hello_there_true() {
        //Arrange

        //Act
        String actualResult = nonStart.getPartialString("Hello", "There");

        //Assert

        Assert.assertEquals("ellohere", actualResult); //(expectedResult, actualResult)

    }

    @Test
    public void get_partial_string_result_java_code_true() {
        //Arrange

        //Act
        String actualResult = nonStart.getPartialString("java", "code");

        //Assert

        Assert.assertEquals("avaode", actualResult); //(expectedResult, actualResult)

    }

    @Test
    public void get_partial_string_result_sh_ja_true() {
        //  "sh", "ja"                     "ha"
        //Arrange

        //Act
        String actualResult = nonStart.getPartialString("sh", "ja");

        //Assert

        Assert.assertEquals("ha", actualResult); //(expectedResult, actualResult)

    }
}
