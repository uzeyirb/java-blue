package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CigarPartyTest {

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

    private CigarParty cigarParty;

    @Before
     /*
    Methods annotated with the @Before annotation are run before each test.
     This is useful when we want to execute some common code before running a test.
     */
    public void setup(){
        cigarParty = new CigarParty();
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
    Tests for haveParty

    cigars     isWeekend       expectedResult
    30,          false)             → false
    50,          false)             → true
    70,          true)              → true
     */

    @Test
    public void true_when_cigars_more_than_40_and_60_weekEnd_true(){
        //Arrange
        //boolean actualResult = cigarParty.haveParty(70, true);
        //Act
        Assert.assertEquals(true, cigarParty.haveParty(70, true));

    }

    @Test
    public void false_when_cigars_less_than_30_weekEnd_false(){
        //Arrange
        //boolean actualResult = cigarParty.haveParty(30, false);
        //Act
        Assert.assertEquals(false, cigarParty.haveParty(30, false));

    }

    @Test
    public void true_when_cigars_more_than_40_and_60_weekEnd_false(){
        //Arrange
        //boolean actualResult = cigarParty.haveParty(50, false);
        //Act
        Assert.assertEquals(true, cigarParty.haveParty(50, false));

    }
    @Test
    public void false_when_cigars_more_than_40_and_60_weekEnd_false(){
        //This test has been failed in order to check if code for test works
        //Arrange
        //boolean actualResult = cigarParty.haveParty(70, true);
        //Act
        Assert.assertEquals(false, cigarParty.haveParty(70, true));

    }
}
