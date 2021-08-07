package com.techelevator;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public class Tutorial {
	
    public static void main(String[] args) {

    	// Step One: Declare a List

    	List <String> namesOfCustomers = new ArrayList<String>();



    	// Step Two: Add values to a List

        namesOfCustomers.add("Don Joe");
        namesOfCustomers.add("Ace Ventura");
        namesOfCustomers.add("Jim Carey");

    	// Step Three: Looping through a List in a for loop
        for (int i = 0; i < namesOfCustomers.size(); i++){
            System.out.println(namesOfCustomers.get(i));
        }
    	
    	// Step Four: Remove an item

    	namesOfCustomers.remove("Don Joe");

    	// Step Five: Looping through List in a for-each loop

        System.out.println(" =================================================");
        System.out.println(" Step Five: Looping through List in a for-each loop");
        for( String customers: namesOfCustomers){
            System.out.println(customers);
        }

    }

}
