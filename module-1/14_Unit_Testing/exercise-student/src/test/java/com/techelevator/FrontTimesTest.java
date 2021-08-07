package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrontTimesTest {

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

    private FrontTimes frontTimes;

    @Before
     /*
    Methods annotated with the @Before annotation are run before each test.
     This is useful when we want to execute some common code before running a test.
     */
    public void setup() {
        frontTimes = new FrontTimes();
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
    Tests for dateFashion
    str             n               expectedResult
    Chocolate       2                   ChoCho
    abc             3                   abcabcabc
    a               3                   aaa
    az              2                   azaz
    az              1                    az
    a               0                     ""
    null            2                     ??""
    292             2                     292292
    24              1                      24
     */

    @Test
    public void get_string_n_3times_result_true() {
        //Arrange

        //Act
        String actualResult = frontTimes.generateString("Chocolate", 2);

        //Assert

        Assert.assertEquals("ChoCho", actualResult); //(expectedResult, actualResult)

    }

    @Test
    public void get_string_n_2times_result_true() {
        //Arrange
        //Act
        String actualResult = frontTimes.generateString("abc", 3);
        //Assert
        Assert.assertEquals("abcabcabc", actualResult); //(expectedResult, actualResult)

    }

    @Test
    public void get_string_n_1times_result_true() {
        //Arrange

        //Act
        String actualResult = frontTimes.generateString("az", 1);

        //Assert

        Assert.assertEquals("az", actualResult); //(expectedResult, actualResult)

    }

    @Test
    public void get_string_n_zero_times_result_true() {
        //Arrange

        //Act
        String actualResult = frontTimes.generateString("az", 0);

        //Assert

        Assert.assertEquals("", actualResult); //(expectedResult, actualResult)

    }

    //292             2                     292292

    @Test
    public void get_string_with_numbers_instead_of_words() {
        //Act and Assert in one line of code
        Assert.assertEquals("292292", frontTimes.generateString("292", 2));
    }
}


