package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Tutorial {
	

    public static void main(String[] args) {

        // Step One: Declare a Map

            Map< String, Integer> productReadyForSale = new HashMap<>();
    	
    	// Step Two: Add items to a Map

        productReadyForSale.put("laptop", 12949);
        productReadyForSale.put("mobile phone", 161112);

    	
    	// Step Three: Loop through a Map


        for(String itemNumber: productReadyForSale.keySet()){
            Integer value = productReadyForSale.get(itemNumber);
            System.out.println(value);
        }

    }

}
