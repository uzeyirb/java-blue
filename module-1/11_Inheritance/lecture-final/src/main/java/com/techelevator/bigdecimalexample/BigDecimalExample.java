package com.techelevator.bigdecimalexample;

import java.math.BigDecimal;

public class BigDecimalExample {

    public static void main(String[] args) {

        // Creating a big decimal
        BigDecimal amount = new BigDecimal(0);
        BigDecimal anotherAmount = BigDecimal.ZERO;

        // Big Decimal is immutable and uses methods instead of operators
        amount = amount.add( new BigDecimal(10) );

        /*
        compareTo return -1 (if less than),  0 (if equal),  1 (if greater than)
         */
        if (amount.compareTo( anotherAmount) == -1) {

        }

    }
}
