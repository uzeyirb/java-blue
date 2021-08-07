package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExerciseProblemsTest {

    /*
    A instance variable to reference the class we are testing
     */
    private ExerciseProblems exerciseProblems;

    /*
    A method marked with the @Before annotation will be run before every test.
     */
    @Before
    public void setup() {
        exerciseProblems = new ExerciseProblems();
    }

    /*
    A method marked with the @After annotation will be run after every test
     */
    @After
    public void cleanup() {
        // do code that cleans up or resets here
        System.out.println();
    }

    /*
    TESTS FOR sleepIn

        weekday  vacation   expectedResult
        TRUE     TRUE       TRUE
        TRUE     FALSE      FALSE
        FALSE    TRUE       TRUE
        FALSE    FALSE      TRUE

     */
    @Test
    public void true_when_weekday_true_and_vacation_true() {

        // Arrange
        // Act
        boolean result = exerciseProblems.sleepIn(true, true);
        // Assert
        Assert.assertTrue( result );
    }

    @Test
    public void false_when_weekday_true_and_vacation_false() {

        // Arrange
        // Act
        boolean result = exerciseProblems.sleepIn(true, false);
        // Assert
        Assert.assertFalse( result );
    }

    @Test
    public void true_when_weekday_false_and_vacation_true() {

        // Arrange
        // Act
        boolean result = exerciseProblems.sleepIn(false, true);
        // Assert
        Assert.assertTrue( result );
    }

    @Test
    public void true_when_weekday_false_and_vacation_false() {
        // Arrange
        // Act and Assert
        Assert.assertTrue( exerciseProblems.sleepIn(false, false ));

    }


    /*
    TESTS FOR sumDouble

            a       b           expected
            2       2           8
            1       2           3
            -1      -1          -4
            -1      2           1
            0       0           0
     */
    @Test
    public void values_are_equal() {
        // Arrange
        // Act
        int actualResult = exerciseProblems.sumDouble(2, 2);
        // Assert
        Assert.assertEquals(8, actualResult);   // ( expectedResult, actualResult)
    }

    @Test
    public void values_are_not_same() {
        // Arrange
        // Act
        int actualResult = exerciseProblems.sumDouble(1, 2);
        // Assert
        Assert.assertEquals(3, actualResult);
    }

    /*
    TESTS for withoutEnd2

        str         expected result
        Hello       ell
        a           ""
        ""          ""
        abc         b
        0123        12
        ab          ""
        null        ?? ""

     */

    @Test
    public void word_with_more_than_3_letters() {
        // Arrange
        // Act
        String actualResult = exerciseProblems.withoutEnd2("Hello");
        // Assert
        Assert.assertEquals("ell", actualResult);
    }

    @Test
    public void empty_string_returns_empty_string() {
        // Arrange
        // Act
        String actualResult = exerciseProblems.withoutEnd2("");
        // Assert
        Assert.assertEquals("", actualResult);
    }

    @Test
    public void string_with_2_characters() {
        // Act and Assert
        Assert.assertEquals("", exerciseProblems.withoutEnd2("ab"));
    }
}
