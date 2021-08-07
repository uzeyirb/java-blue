package com.techelevator;

<<<<<<< HEAD
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelReservationTest {

    private HotelReservation hotelReservation;

    @Before
     /*
    Methods annotated with the @Before annotation are run before each test.
     This is useful when we want to execute some common code before running a test.
     */
    public void setup(){
        hotelReservation = new HotelReservation();
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
    public void true_when_actualTotal_true(){
        //Arrange
        double actualResult = hotelReservation.actualTotal("Jon Doe", 3);
        //Act
        //Assert.assertEquals(expected, );

    }
=======
import org.junit.*;

public class HotelReservationTest {

    private HotelReservation reservation;

    @Before
    public void setupHotelReservation() {
        reservation = new HotelReservation("test", 2);
    }

    /*
    Test estimated total
     */
    @Test
    public void estimated_total() {
        double actualTotal = reservation.getEstimatedTotal();
        Assert.assertEquals(59.99 * 2, actualTotal, .009);
    }

    /*
    Test actual Total
     */
    @Test
    public void actual_total_minibarused_and_cleaning_required() {
        // Calcaulate the expected result
        double expectedTotal = ((59.99 * 2) + 12.99) + (34.99 * 2);

        double actualTotal = reservation.calculateActualTotal(true, true);

        Assert.assertEquals(expectedTotal, actualTotal, .009);

    }

    @Test
    public void actual_total_minibarused_and_no_cleaning_required() {
        // Calcaulate the expected result
        double expectedTotal = ((59.99 * 2) + 12.99);

        double actualTotal = reservation.calculateActualTotal(false, true);

        Assert.assertEquals(expectedTotal, actualTotal, .009);

    }

    @Test
    public void actual_total_no_minibarused_and_cleaning_required() {
        // Calcaulate the expected result
        double expectedTotal = (59.99 * 2) + (34.99);

        double actualTotal = reservation.calculateActualTotal(true, false);

        Assert.assertEquals(expectedTotal, actualTotal, .009);

    }

    @Test
    public void actual_total_no_minibarused_and_no_cleaning_required() {
        // Calcaulate the expected result
        double expectedTotal = (59.99 * 2);

        double actualTotal = reservation.calculateActualTotal(false, false);

        Assert.assertEquals(expectedTotal, actualTotal, .009);

    }

>>>>>>> 0c87c625426f08b48881435ac8b2ec83a6a1ac67
}
