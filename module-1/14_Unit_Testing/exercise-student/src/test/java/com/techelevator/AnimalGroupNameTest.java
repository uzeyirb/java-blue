package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

public class AnimalGroupNameTest {

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
    private AnimalGroupName animalGroupName;

    /*
    Methods annotated with the @Before annotation are run before each test.
     This is useful when we want to execute some common code before running a test.
     */

    @Before
    public void setup() {
        animalGroupName = new AnimalGroupName();
        Map<String, String> animals = new HashMap<>();


    }

    /*
    Methods annotated with the @After annotation are run after each test.
     This is useful when we want to execute some common code after running a test.
     */

    @After
    public void cleanup() {
        // do code that cleans up or reset here


    }

    /*
    GetHerd("giraffe") → "Tower"
    GetHerd("") -> "unknown"
    GetHerd("walrus") -> "unknown"
    GetHerd("Rhino") -> "Crash"
    GetHerd("rhino") -> "Crash"
    GetHerd("elephants") -> "unknown"
     */
    @Test
    public void true_when_herd_name_match() {

        //Arrange
        //Act
        // String actualResult = animalGroupName.getHerd("rhino");
        Assert.assertEquals("Crash", animalGroupName.getHerd("rhino"));

    }

    @Test
    public void false_when_herd_name_do_not_match() {
        //This test has been failed intentionally to check if test code works or not
        //Arrange
        //Act
        //String actualResult = animalGroupName.getHerd("giraffe");
        Assert.assertEquals("Herd", animalGroupName.getHerd("giraffe"));

    }

    @Test
    public void true_when_herd_name_empty_unknown() {
        // Test for GetHerd("") -> "unknown"
        //Arrange
        //Act
        //String actualResult = animalGroupName.getHerd("");
        Assert.assertEquals("unknown", animalGroupName.getHerd(""));

    }


    @Test
    public void true_when_herd_name_typo_exists() {
        // Test for GetHerd("elephants") -> "unknown"
        //Arrange
        //Act
        //String actualResult = animalGroupName.getHerd("elephants");
        Assert.assertEquals("unknown", animalGroupName.getHerd("elephants"));

    }


}
