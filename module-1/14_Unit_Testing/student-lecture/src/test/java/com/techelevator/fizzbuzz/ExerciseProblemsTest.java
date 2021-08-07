package com.techelevator.fizzbuzz;

import com.techelevator.ExerciseProblems;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExerciseProblemsTest {

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

    private ExerciseProblems exerciseProblems;

    /*
    Methods annotated with the @Before annotation are run before each test.
     This is useful when we want to execute some common code before running a test.
     */
    @Before

    public void setup() {

        exerciseProblems = new ExerciseProblems();
    }


    /*
    Methods annotated with the @After annotation are run after each test.
     This is useful when we want to execute some common code after running a test.
     */
    @After

    public void cleanup(){
        //do code that cleans up or resets here
    }

    /*
    Tests For sleepIn

    weekday    vacation    expectedResult
    true        true        true
    true        false       false
    false       true        true
    false        false       true

     */

    /*
    The Test annotation tells JUnit that the public void method to which it is attached
    can be run as a test case. To run the method, JUnit first constructs a fresh instance
    of the class then invokes the annotated method. Any exceptions thrown by the test will
    be reported by JUnit as a failure.
     */
    /*
    An assertion Error is thrown when say "You have written a code that should not execute
    at all costs because according to you logic it should not happen. BUT if it happens
    then throw AssertionError. And you don't catch it." In such a case you throw an
    Assertion error.
     */

    @Test
    public void true_when_weekday_true_and_vacation_true(){
        //Arrange
        //Act
        boolean result = exerciseProblems.sleepIn(true, true);
        //Assert
        Assert.assertTrue(result);


    }


}
