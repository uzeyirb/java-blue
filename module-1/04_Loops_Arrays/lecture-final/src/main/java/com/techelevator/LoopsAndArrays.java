package com.techelevator;

public class LoopsAndArrays {

    public static void main(String[] args) {

        /*
        ARRAYS
         */
        String[] instructors = new String[5];

        double[] arrayOfDoubles = new double[10];

        instructors[0] = "John";
        instructors[1] = "Rachelle";

        instructors[3] = "Matt";

        instructors[4] = "Kevin";

        instructors[2] = "Steve";

        System.out.println( instructors[1] );

        String greeting = "Hello " + instructors[2];
        System.out.println(greeting);

        System.out.println( instructors.length );

        instructors[0] = "The John Fulton";

        // This will cause an ArrayOutOfBoundsException
        //instructors[5] = "test";

        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };


//        int[] numbers = new int[10];
//        numbers[0] = 1;
//        numbers[1] = 2;
//        numbers[2] = 3;
//        numbers[3] = 4;
//        numbers[4] = 5;
//        numbers[5] = 6;
//        numbers[6] = 7;
//        numbers[3] = 8;
//        numbers[7] = 9;
//        numbers[9] = 10;

        int definedInMain;

        if (numbers[3] > 5) {
            // definedInMain is available here
            int definedInIf;

            if (numbers[4] > 5) {
                // definedInIf is available here
                // definedInMain is available here
                int definedInNestedIf;
            }
            // definedInNestedIf is NOT available here
        }
        // definedInIf is NOT available here
        // definedInMain is available here
        // definedInNestedIf is NOT available here

        /*
        LOOPS
         */
        /*   variable to change ; boolean condition ; change the variable*/
        for ( int i = 0 ; i < 10 ; i++) {
            System.out.println( i );
        }

        /*
        A loop that finds the sum of all the even numbers between 100 and 200
         */
        int sum = 0;
        for ( int n = 100 ; n <= 200; n++) {

            if ( n % 2 == 0) {

                sum += n;
            }

        }

        System.out.println("Sum of 100 to 200 = " + sum);

        /*
        Print numbers 50 through 75 in reverse
         */
        for (int x = 75 ;  x > 49; x--) {
            System.out.print( x + " ");
        }

        /*
        Print every other numbers from 0 to 100
         */
        int n = 0;
        for ( ; n < 100 ; ) {
            System.out.println(n);
            n += 2;
        }

        /*
        Break keyword
         */
        for (int i = 0; i < 10; i++) {
            // The break keyword ends a loop early
            if (i == 5) {
                break;
            }
            System.out.print( i );
        }

        /*
        Continue Keyword
         */
        for (int i = 0; i < 10; i++) {
            // The continue keyword, ends this iteration and goes to the next
            if (i == 3) {
                continue;
            }
            System.out.print( i );
        }

        /*
        Looping through an Array
         */
        for (int i = 0; i < instructors.length; i++) {
            System.out.println( instructors[i] );
        }

        /* Loop, but skip over Steve */
        for (int i = 0; i < instructors.length; i++) {
            if (instructors[i].equals("Steve")) {
                continue;
            }
            System.out.println( instructors[i] );
        }

        for (int i = 0 ; i < numbers.length; i++) {
            if (i % 2 == 0) {  // use i to access the index
                System.out.println( numbers[i] ); // use array[i] to access the value
             }
        }

        /*
        Loop and double every number in an array of integers
         */
        for (int i = 0 ; i < numbers.length; i++) {
            numbers[i] = numbers[i] * 2;
        }

        /*
        Print the first half of the numbers arry
         */
        for (int i = 0 ; i < numbers.length / 2 ; i++) {
            System.out.println(numbers[i]);
        }

        /*
        Print the second half of the numbers arry
         */
        for (int i = numbers.length / 2 ; i < numbers.length ; i++) {
            System.out.println(numbers[i]);
        }

        /*
        Print everything but the last value
         */
        for (int z = 0 ; z < numbers.length - 1 ; z++) {
            System.out.println(numbers[z]);
        }


        System.out.println("----- Print without 10");
        /*
        Print all the numbers, except 5 and the number immediately following it
        [ 1, 2, 3, 10, 4, 7, 6, 10, 7, 8]
         */
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 10) {
                if (i < numbers.length - 1) {
                    i++;
                }
                continue;
            }
            System.out.print(numbers[i] + " ");
        }

        int x = 5;
        //int y = 5 + ++x;
        // x goes up by 1 and then is used
        // y = 5 + ( x + 1)
        //5 + ( 6 ) = 11  (x = 6)
         //int y = 5 + x++;
        // y = ( 5 + x)  and then later x + 1
         // x is used and the goes up by 1  (++x)
         //5 + 5 = 10  ( x = 6)
    }
}
