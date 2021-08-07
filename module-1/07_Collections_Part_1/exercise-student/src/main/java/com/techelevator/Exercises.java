package com.techelevator;

import java.util.*;

public class Exercises {

	/*
	 Note, for-each is preferred, and should be used when possible.
	 */

    /*
     1. Given an array of Strings, return an ArrayList containing the same Strings in the same order
     array2List( {"Apple", "Orange", "Banana"} )  ->  ["Apple", "Orange", "Banana"]
     array2List( {"Red", "Orange", "Yellow"} )  ->  ["Red", "Orange", "Yellow"]
     array2List( {"Left", "Right", "Forward", "Back"} )  ->  ["Left", "Right", "Forward", "Back"]
     */
    public List<String> array2List(String[] stringArray) {

        return Arrays.asList(stringArray);
    }

    /*
     2. Given a list of Strings, return an array containing the same Strings in the same order
     list2Array( ["Apple", "Orange", "Banana"] )  ->  {"Apple", "Orange", "Banana"}
     list2Array( ["Red", "Orange", "Yellow"] )  ->  {"Red", "Orange", "Yellow"}
     list2Array( ["Left", "Right", "Forward", "Back"] )  ->  {"Left", "Right", "Forward", "Back"}
     */
    public String[] list2Array(List<String> stringList) {
		/*
		Like the toArray() method, this method acts as bridge between array-based and collection-based APIs.
		 Further, this method allows precise control over the runtime type of the output array, and may,
		 under certain circumstances, be used to save allocation costs. Suppose x is a list known to contain only strings.
		 The following code can be used to dump the list into a newly allocated array of String
		*/
        return stringList.toArray(new String[stringList.size()]);
    }

    /*
     3. Given an array of Strings, return an ArrayList containing the same Strings in the same order
     except for any words that contain exactly 4 characters.
     no4LetterWords( {"Train", "Boat", "Car"} )  ->  ["Train", "Car"]
     no4LetterWords( {"Red", "White", "Blue"} )  ->  ["Red", "White"]
     no4LetterWords( {"Jack", "Jill", "Jane", "John", "Jim"} )  ->  ["Jim"]
     */
    public List<String> no4LetterWords(String[] stringArray) {
        //Create new excludeFourLetterWords Arraylist
        // use for each loop to iterate through each element inside ArrayList  and inside for each use if just to exclude 4 letter words

        List<String> excludeFourLetterWords = new ArrayList<String>();
        for (String listOfWordsInArray : stringArray) {
            if (listOfWordsInArray.length() != 4) {
                excludeFourLetterWords.add(listOfWordsInArray);

            }
        }
        return excludeFourLetterWords;
    }

    /*
     4. Given an array of ints, divide each int by 2, and return an ArrayList of Doubles.
     arrayInt2ListDouble( {5, 8, 11, 200, 97} ) -> [2.5, 4.0, 5.5, 100, 48.5]
     arrayInt2ListDouble( {745, 23, 44, 9017, 6} ) -> [372.5, 11.5, 22, 4508.5, 3]
     arrayInt2ListDouble( {84, 99, 3285, 13, 877} ) -> [42, 49.5, 1642.5, 6.5, 438.5]
     */
    public List<Double> arrayInt2ListDouble(int[] intArray) {

        //First create ArrayList doubleAfterDivisionByTwo that will contain new list of doubles
        // loop each with the listCfDouble inside scope of the loop do calculations listOfIntegers divided by 2
        //Finally I will return newly created doubleAfterDivisionByTwo

        List<Double> doubleAfterDivisionByTwo = new ArrayList<>();

        for (Integer listOfIntegers : intArray) {
            doubleAfterDivisionByTwo.add(listOfIntegers / 2.0);
        }
        return doubleAfterDivisionByTwo;
    }

    /*
     5. Given a List of Integers, return the largest value.
     findLargest( [11, 200, 43, 84, 9917, 4321, 1, 33333, 8997] ) -> 33333
     findLargest( [987, 1234, 9381, 731, 43718, 8932] ) -> 43718
     findLargest( [34070, 1380, 81238, 7782, 234, 64362, 627] ) -> 64362
     */
    public Integer findLargest(List<Integer> integerList) {
        //
        //use built in methods (Collections.max ( integerList));


        return Collections.max(integerList);
    }

    /*
     6. Given an array of Integers, return a List of Integers containing just the odd values.
     oddOnly( {112, 201, 774, 92, 9, 83, 41872} ) -> [201, 9, 83]
     oddOnly( {1143, 555, 7, 1772, 9953, 643} ) -> [1143, 555, 7, 9953, 643]
     oddOnly( {734, 233, 782, 811, 3, 9999} ) -> [233, 811, 3, 9999]
     */
    public List<Integer> oddOnly(Integer[] integerArray) {
        List<Integer> listOddOnly = new ArrayList<>();
        // create new list with listoddonly with integer type
        //inside for each loop use if condition  module not equal 0
        // add every integer to newly create arraylist
        //return newly created list

        for (Integer listOfIntegers : integerArray) {
            if (listOfIntegers % 2 != 0) {
                listOddOnly.add(listOfIntegers);

            }
        }
        return listOddOnly;

    }

	/*
	 7. Given a List of Integers, and an int value, return true if the int value appears two or more times in
	 the list.
	 foundIntTwice( [5, 7, 9, 5, 11], 5 ) -> true
	 foundIntTwice( [6, 8, 10, 11, 13], 8 -> false
	 foundIntTwice( [9, 23, 44, 2, 88, 44], 44) -> true
	 */
    //Create for each loop to iterate
    // inside for loop do if condition in order to find if values inside list is equal to integer given
    // then return true if there are more than one occurrence


    public boolean foundIntTwice(List<Integer> integerList, int intToFind) {

        Integer countsOfRepetitionOfIntGiven = 0;
        for (Integer goingThroughIntegers : integerList) {

            if (goingThroughIntegers.equals(intToFind)) {
                countsOfRepetitionOfIntGiven++;

            }


        }
        if (countsOfRepetitionOfIntGiven > 1) {
            return true;
        }
        return false;
    }

    /*
     8. Given an array of Integers, return a List that contains the same Integers (as Strings). Except any multiple of 3
    must be replaced by the String "Fizz", any multiple of 5 must be replaced by the String "Buzz",
    and any multiple of both 3 and 5 must be replaced by the String "FizzBuzz."
    ** INTERVIEW QUESTION **

    fizzBuzzList( {1, 2, 3} )  ->  ["1", "2", "Fizz"]
    fizzBuzzList( {4, 5, 6} )  ->  ["4", "Buzz", "Fizz"]
    fizzBuzzList( {7, 8, 9, 10, 11, 12, 13, 14, 15} )  ->  ["7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"]

    HINT: To convert an Integer x to a String, you can use x.toString() in your code. For example, if x = 1, then x.toString() returns "1."
     */

    //Create list of fizzBuzzList
    //loop through array and if given element is n%3=0 replace with Fizz and n%5=0 replace with Buzz

    public List<String> fizzBuzzList(Integer[] integerArray) {

        List<String> fizzBuzzList = new ArrayList<>();


        for (Integer loopingFizzBuzzList: integerArray){
            if (loopingFizzBuzzList % 3 == 0 && loopingFizzBuzzList % 5 == 0){
                fizzBuzzList.add("FizzBuzz");

            } else if(loopingFizzBuzzList % 3 == 0){
                fizzBuzzList.add("Fizz");

            }else if(loopingFizzBuzzList % 5 == 0){
                fizzBuzzList.add("Buzz");
            }else {
                fizzBuzzList.add(loopingFizzBuzzList.toString());
            }
        }


        return fizzBuzzList;
    }

    /*
     9. Given two lists of Integers, interleave them beginning with the first element in the first list followed
     by the first element of the second. Continue interleaving the elements until all elements have been interwoven.
     Return the new list. If the lists are of unequal lengths, simply attach the remaining elements of the longer
     list to the new list before returning it.
     interleaveLists( [1, 2, 3], [4, 5, 6] )  ->  [1, 4, 2, 5, 3, 6]
     */
    //We will not necessarily create new third list but simply add one to another
    //we will loop listone skipping 2 index each time and will add to list if list2 is less than index

    public List<Integer> interleaveLists(List<Integer> listOne, List<Integer> listTwo) {



        int kickOff = 0;
        int i;
        int size = listOne.size();
        for (i = 1; i < listOne.size(); i += 2) {
            if (kickOff < listTwo.size()) {
                listOne.add(i, listTwo.get(kickOff++));
            }
        }
        while (listOne.size() < (size + listTwo.size())) {
            listOne.add(i++, listTwo.get(kickOff++));
        }





        return listOne;
    }

}

