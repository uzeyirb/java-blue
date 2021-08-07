package com.techelevator;

public class LoopsAndArrays {

    public static void main(String[] args) {

        String[] instructors = new String[5];

        instructors[0] = "John";
        instructors[1] =  "Rachelle";

        instructors[3] = "Matt";

        instructors[4] = "Kevin";

        instructors[2] = "Steve";
        
        System.out.println(instructors[1]);

       String greeting = "Hello " + instructors[2];

       System.out.println(greeting);

       System.out.println(instructors.length);

       instructors[0] = "The John Fulton";

    // instructors[5] = "test";

       //int[] numbers = new int[10];
       int[] numbers={1,2,3,4,5,6,7,8,9,10};

       /*
       * Loops
       *
       * variable to change; boolean condition; change the variable
       * */
        for (int i = 0; i < 10; i++){
            System.out.println(i);
        }

        /*
        * A loop that finds the sum of all the even numbers between and 100 and 200
        * */
        for( int n = 100 ; n <= 200; n++) {

            if (n % 2 == 0 ) {
                int sum = 0;
                sum +=n;
            }

        }


        /*
        * Print numbers 50 through 75 in reverse */

        for(int x = 75 ; x > 49; x-- ){

            System.out.println( x + " ");
        }

        /*
        * Print every other numbers from 0 to 100*/
        //int  i = 0;

        /*for ( ; i < 100 ; i +=){
            System.out.println(i);
            i += 2;

        }*/

        /*
         *Break keyword
         */
        for(int i = 0; i <10; i++){
            // The break keywod ends a loop early
            System.out.println(i);
            break;
        }


        /*
         *Continue keyword
         */
        for(int i = 0; i <10; i++){
            // The continue keyword ends this iteration and goes to the next
            System.out.println(i);
            continue;
        }



        /*
        * Looping through an Array
        * */

        for (int  i = 0; i < instructors.length; i++){
            System.out.println(instructors[i]);
        }

        /*
        * Loop and double every number in an array of integers*/

        for(int i = 0 ; i < numbers.length; i++ ){
            numbers[i] = numbers[i] * 2;
        }
        /*
        * Print the fist half of the numbers array*/

        for( int i = 0 ; i < numbers.length / 2 ; i++ ){
            System.out.println(numbers[i]);
        }

        /*
         * Print the second fist half of the numbers array*/

        for( int i = numbers.length / 2 ; i < numbers.length ; i++ ){
            System.out.println(numbers[i]);
        }

        /*
         * Print everything but the last*/

        for( int i = 0 ; i < numbers.length-1 ; i++ ){
            System.out.println(numbers[i]);
        }

        System.out.println("Print all the numbers, except 10 and the number immediately following");
        /*
        * Print all the numbers, except 10 and the number immediately following it
        [1,2,3,28,4,5,20,7,8]*/

        for (int i = 0; i<numbers.length; i++){
            if(numbers[i] == 10){
                if(i < numbers.length -1 ) {
                    i++;

                }
                continue;

            }
            System.out.println(numbers[i] + " ") ;

        }




        }

    }

