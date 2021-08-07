package com.techelevator;

<<<<<<< HEAD
public class HotelReservation implements Reservation {

    /*
    Add a name, number of nights, and estimated total attribute/property to the Hotel Reservation class:
name: indicates the name on the reservation.
number of nights: indicates how many nights the reservation is for.
estimated total: indicates the estimated total using number of nights times a daily rate of \$59.99.
     */

    private final double DAILY_RATE = 59.99;
    private final double MINI_BAR_FEE = 12.99;
    private final double CLEANING_REQUIRED = 34.99;
    private String name;
    private int numberOfNights;
    private double estimatedTotal;
    private boolean requiresCleaning = false;
    private  boolean usedMinibar = false;
    public boolean getRequiredCleaning() {
        return requiresCleaning;
    }
    public boolean getUsedMinibar() {
        return usedMinibar;
    }

    public HotelReservation(String name, int numberOfNights, boolean requiresCleaning, boolean usedMinibar) {
        this.name = name;
        this.numberOfNights = numberOfNights;
        this.usedMinibar = usedMinibar;
        this.requiresCleaning = requiresCleaning;
    }


    public HotelReservation(String name, int numberOfNights) {
        this.name = name;
        this.numberOfNights = numberOfNights;

    }
    public HotelReservation(){

=======
public class HotelReservation {

    private String name;
    private int numberOfNights;


    public HotelReservation(String name, int numberOfNights) {
        this.name = name;
        this.numberOfNights = numberOfNights;
    }

    public double calculateActualTotal(boolean requiresCleaning, boolean usedMinibar) {

        double actualTotal = getEstimatedTotal();

        if (usedMinibar) {
            actualTotal += 12.99;
        }
        if (requiresCleaning) {
            actualTotal += 34.99;
            if (usedMinibar) {
                actualTotal += 34.99;
            }
        }
        return actualTotal;
    }

    public double getEstimatedTotal() {
        return numberOfNights * 59.99;
>>>>>>> 0c87c625426f08b48881435ac8b2ec83a6a1ac67
    }

    public String getName() {
        return name;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

<<<<<<< HEAD
    public double getEstimatedTotal() {
        return this.estimatedTotal;
    }

    public void setName(String name) {
        this.name = name;
    }

=======
>>>>>>> 0c87c625426f08b48881435ac8b2ec83a6a1ac67
    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

<<<<<<< HEAD
    public void setEstimatedTotal(double estimatedTotal) {
        this.estimatedTotal = this.numberOfNights * DAILY_RATE;
    }

    /*
    Create a method that calculates the actual total using two bool/boolean input parameters: requiresCleaning and usedMinibar:
If the minibar was used, a fee of \$12.99 is added to the estimated total.
If the room requires cleaning, a fee of \$34.99 is added to the estimated total.
The cleaning fee is doubled if the minibar was used.?

     */
    @Override
    public double actualTotal(String name, int numberOfNights) {

        if(requiresCleaning ==true){
            return getEstimatedTotal() + CLEANING_REQUIRED;

        } else if (usedMinibar == true){
            return getEstimatedTotal() + MINI_BAR_FEE + (CLEANING_REQUIRED * 2);
        }
        return estimatedTotal;
    }

    /*Override the toString()/toString() method and have it return "RESERVATION - {name} - {estimated total}"
    where {name} and {estimated total} are placeholders for the actual values. The values from the object should be shown
    in the string where {variable-name} is indicated.

     */
    @Override
    public String toString() {

        return "RESERVATION - " + this.name + " - " + this.estimatedTotal;
=======
    @Override
    public String toString() {
        return "RESERVATION - " + this.name + " - " + getEstimatedTotal();
>>>>>>> 0c87c625426f08b48881435ac8b2ec83a6a1ac67
    }
}
