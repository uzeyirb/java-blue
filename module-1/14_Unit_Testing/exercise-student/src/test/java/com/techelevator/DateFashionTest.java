package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateFashionTest {

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
    private DateFashion dateFashion;

    @Before
     /*
    Methods annotated with the @Before annotation are run before each test.
     This is useful when we want to execute some common code before running a test.
     */
    public void setup() {
        dateFashion = new DateFashion();
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

    a      b         expected
    2      8           0
    8      2           0
    5      5           1
    8      5           2
    4      8           2
     */

    @Test
    public void get_table_result_no_case1() {
        //Arrange
        //Act
        //int actualResult = dateFashion.getATable(2, 8);
        //Assert
        Assert.assertEquals(0, dateFashion.getATable(2, 8)); //(expectedResult, actualResult)

    }

    @Test
    public void get_table_result_no_case2() {
        //Arrange
        //Act
        //int actualResult = dateFashion.getATable(8, 2);
        //Assert

        Assert.assertEquals(0, dateFashion.getATable(8, 2)); //(expectedResult, actualResult)
    }

    @Test
    public void get_table_result_no_case3() {
        //Arrange
        //Act
        //int actualResult = dateFashion.getATable(8, 2);
        //Assert
        Assert.assertEquals(0, dateFashion.getATable(8, 2)); //(expectedResult, actualResult)
    }

    @Test
    public void get_table_result_no_case4() {
        //Arrange
        //Act
        //int actualResult = dateFashion.getATable(2, 8);
        //Assert
        Assert.assertEquals(0, dateFashion.getATable(2, 8)); //(expectedResult, actualResult)

    }

    @Test
    public void get_table_result_maybe_case1() {
        //Arrange
        //Act
        //int actualResult = dateFashion.getATable(5, 5);
        //Assert
        Assert.assertEquals(1, dateFashion.getATable(5, 5)); //(expectedResult, actualResult)

    }

    @Test
    public void get_table_result_yes_case1() {
        //Arrange
        //Act
        //int actualResult = dateFashion.getATable(8, 5);
        //Assert
        Assert.assertEquals(2, dateFashion.getATable(8, 5)); //(expectedResult, actualResult)

    }

    @Test
    public void get_table_result_yes_case2() {
        //Arrange
        //Act
        //int actualResult = dateFashion.getATable(5, 8);
        //Assert
        Assert.assertEquals(2, dateFashion.getATable(5, 8)); //(expectedResult, actualResult)

    }
}
