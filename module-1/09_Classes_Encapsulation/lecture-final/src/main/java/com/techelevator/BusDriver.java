package com.techelevator;


import com.techelevator.vehicle.Bus;

import java.util.Collections;
import java.util.Locale;

public class BusDriver {

    public static void main(String[] args) {

        Bus busOne = new Bus();
        busOne.setRouteName("Third to Fifth");

        System.out.println( busOne.getRouteName() );

        System.out.println( busOne.getRemainingSeats());
        busOne.openDoor();
        busOne.board();
        busOne.closeDoor();
        System.out.println( busOne.getRemainingSeats());

        busOne.openDoor();
        busOne.board(10);
        busOne.closeDoor();

        Bus busTwo = new Bus("High to Third");

        System.out.println("----------------");
        System.out.println( busOne );

        boolean areEqual = busOne.equals(busTwo);
        System.out.println(areEqual);

        Bus busThree = new Bus("ABC");
        Bus busFour = new Bus("ABC");

        areEqual = busThree.equals(busFour);
        System.out.println(areEqual);

        // Calling the static method
        System.out.println(
                Bus.getDistanceRemaining(20, 10)
        );

    }
}
