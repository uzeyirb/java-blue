package com.techelevator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Exercises {

    /*
     * Given the name of an animal, return the name of a group of that animal
     * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
     *
     * The animal name should be case insensitive so "elephant", "Elephant", and
     * "ELEPHANT" should all return "herd".
     *
     * If the name of the animal is not found, null, or empty, return "unknown".
     *
     * Rhino -> Crash
     * Giraffe -> Tower
     * Elephant -> Herd
     * Lion -> Pride
     * Crow -> Murder
     * Pigeon -> Kit
     * Flamingo -> Pat
     * Deer -> Herd
     * Dog -> Pack
     * Crocodile -> Float
     *
     * animalGroupName("giraffe") → "Tower"
     * animalGroupName("") -> "unknown"
     * animalGroupName("walrus") -> "unknown"
     * animalGroupName("Rhino") -> "Crash"
     * animalGroupName("rhino") -> "Crash"
     * animalGroupName("elephants") -> "unknown"
     *
     */
    public String animalGroupName(String animalName) {
//In order to avoid null pointer exception when animal name is null use if condition before to uppercase method
        if (animalName == null) {
            return "unknown";
        }
        Map<String, String> animalHerds = new HashMap<>();
        animalHerds.put("ELEPHANT", "Herd");
        animalHerds.put("RHINO", "Crash");
        animalHerds.put("GIRAFFE", "Tower");
        animalHerds.put("LION", "Pride");
        animalHerds.put("CROW", "Murder");
        animalHerds.put("PIGEON", "Kit");
        animalHerds.put("FLAMINGO", "Pat");
        animalHerds.put("DEER", "Herd");
        animalHerds.put("DOG", "Pack");
        animalHerds.put("CROCODILE", "Float");

        String herdName = animalHerds.get(animalName.toUpperCase());
//If condition is herdname is null
        if (herdName == null) {
            return "unknown";
        }

        return herdName;
    }

    /*
     * Given an String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
     * If the item is not on sale, return 0.00.
     *
     * If the item number is empty or null, return 0.00.
     *
     * "KITCHEN4001" -> 0.20
     * "GARAGE1070" -> 0.15
     * "LIVINGROOM"	-> 0.10
     * "KITCHEN6073" -> 0.40
     * "BEDROOM3434" -> 0.60
     * "BATH0073" -> 0.15
     *
     * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
     * should all return 0.20.
     *
     * isItOnSale("kitchen4001") → 0.20
     * isItOnSale("") → 0.00
     * isItOnSale("GARAGE1070") → 0.15
     * isItOnSale("dungeon9999") → 0.00
     *
     */
    public double isItOnSale(String itemNumber) {
        //This condition is used here in order to avoid nullpointer exception on line 104 with itemNumber to upperCase
        if (itemNumber == null) {
            return 0.00;
        }
        Map<String, Double> itemIsOnSale = new HashMap<>();

        itemIsOnSale.put("KITCHEN4001", 0.20);
        itemIsOnSale.put("GARAGE1070", 0.15);
        itemIsOnSale.put("LIVINGROOM", 0.10);
        itemIsOnSale.put("KITCHEN6073", 0.40);
        itemIsOnSale.put("BEDROOM3434", 0.60);
        itemIsOnSale.put("BATH0073", 0.15);
/*
 to avoid null pointer exception NullPointerException is a RuntimeException.
 In Java, a special null value can be assigned to an object reference.
 NullPointerException is thrown when an application attempts to use an object reference that has the null value.
 These include: Calling an instance method on the object referred by a null reference.
  In the case below when itemnumber is null it will throw nullpointer exception
        As we have one String and one Double we will use containsKey method because key and value are different data types one is string
        another of is double
*/


        if (itemIsOnSale.containsKey(itemNumber.toUpperCase())) {
            return itemIsOnSale.get(itemNumber.toUpperCase());
        }
        return 0.00;
    }

    /*
     * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
     * but only if Paul has less than $10s.
     *
     * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
     *
     * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
     * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
     *
     */
    //First condition is Peter has more than 0 and Peter has less than 1000
    //Create reference for the half of money
    //add peters half on paul
    //increment petersvalue
    // add pauls value and peters value then return map itself
    public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {

        int peterValue = peterPaul.get("Peter");
        int paulValue = peterPaul.get("Paul");


        if(paulValue < 1000 && peterValue >0){

            if (peterValue % 2 != 0) {
                peterValue = peterValue / 2;
                paulValue = peterValue + paulValue;
                peterValue++;
            }else if (peterValue > 0 && paulValue < 1000) {
                peterValue = peterValue / 2;
                paulValue = peterValue + paulValue;
            }else{
                return peterPaul;
            }

        }
        peterPaul.put("Peter", peterValue);
        peterPaul.put("Paul", paulValue);
        return peterPaul;
    }

    /*
     * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
     * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
     * current worth.
     *
     * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
     * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
     *
     */
    public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
        // create value of peter and paul
        // if peter value more than 50000 and paul 100000 then \
        // peternew value * 0.75 and pauls value * 0.75 add to new map
        // add peterpaulpartnership  (peternew value * 0.75) + (value * 0.75)
        // add total partnership value
        int peterValue = peterPaul.get("Peter");
        int paulValue = peterPaul.get("Paul");

        if (peterValue >= 5000 && paulValue >= 10000) {
            int peterPaulPartnershipPeterShare = peterValue / 4;
            peterValue = peterValue - peterPaulPartnershipPeterShare;

            int peterPaulPartnershipPaulShare = paulValue / 4;
            paulValue = paulValue - peterPaulPartnershipPaulShare;

            int totalPartnershipShareForEach = peterPaulPartnershipPaulShare + peterPaulPartnershipPeterShare;

            peterPaul.put("Peter", peterValue);
            peterPaul.put("Paul", paulValue);
            peterPaul.put("PeterPaulPartnership", totalPartnershipShareForEach);
            return peterPaul;

        } else {

            return peterPaul;
        }
    }

    /*
     * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
     * there is a key of its first character with the value of its last character.
     *
     * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
     * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
     * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
     */
    public Map<String, String> beginningAndEnding(String[] words) {
        // create map beginningAndEnding
        // iterate through array to get each element in an array
        //pick first with substring
        //pick last with substring
        // put first and last inside map
        //return map

        Map<String, String> beginningAndEnding = new HashMap<>();

        for(String eachElement : words){
            String first = eachElement.substring(0, 1);
            String last = eachElement.substring(eachElement.length() -1);
            beginningAndEnding.put(first, last);
        }
        return beginningAndEnding;
    }

    /*
     * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
     * number of times that String appears in the array.
     *
     * ** A CLASSIC **
     *
     * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
     * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
     * wordCount([]) → {}
     * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
     *
     */
    public Map<String, Integer> wordCount(String[] words) {

        // create map with name wordCountWithMap
        // for each loop with for to get each element
        // inside for loop do condition if n is equal n+1 count++
        // else only one


        Map<String, Integer> wordCountWithMap = new HashMap<>();
        for(String eachWord :words){
            if(!wordCountWithMap.containsKey(eachWord)){
                wordCountWithMap.put(eachWord, 1);
            } else {
                int countRepetition  = wordCountWithMap.get(eachWord);
                wordCountWithMap.put(eachWord, countRepetition +1);
            }
        }

        return wordCountWithMap;
    }

    /*
     * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
     * number of times that int appears in the array.
     *
     * ** The lesser known cousin of the the classic wordCount **
     *
     * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
     * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
     * intCount([]) → {}
     *
     */
    //Create map with interger integer
    //  for each loop and condition to find when first time integer is seen
    //
    public Map<Integer, Integer> integerCount(int[] ints) {
        Map<Integer,Integer> countingIntegersInArray = new HashMap<>();
        for(Integer eachInteger: ints){
            if(!countingIntegersInArray.containsKey(eachInteger)){
                countingIntegersInArray.put(eachInteger, 1);
            } else{

                int countRepeatingIntegers = countingIntegersInArray.get(eachInteger);
                countingIntegersInArray.put(eachInteger, countRepeatingIntegers + 1);
            }
        }
        return countingIntegersInArray;
    }

    /*
     * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
     * is true only if that String appears 2 or more times in the array.
     *
     * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
     * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
     * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
     *
     */
    //Create Map with string and boolean
    //for each loop with condition if appears less than 2 return false else true
    // add to the map
    public Map<String, Boolean> wordMultiple(String[] words) {
        Map <String, Boolean> ifWordAppearsMoreThanTwice = new HashMap<>();
        for(String eachStringInArray : words){
            if(!ifWordAppearsMoreThanTwice.containsKey(eachStringInArray)){
                ifWordAppearsMoreThanTwice.put(eachStringInArray, false);
            } else{
                ifWordAppearsMoreThanTwice.put(eachStringInArray, true);
            }
        }

        return ifWordAppearsMoreThanTwice;
    }

    /*
     * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
     * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
     *
     * Unmatched keys and their int values in Map2 are simply added to Map1.
     *
     * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
     * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
     *
     */
    public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse, Map<String, Integer> remoteWarehouse) {


        /*for(Map.Entry<String, Integer> mapEntryMainWareHouse: mainWarehouse.entrySet()){
            for (Map.Entry<String, Integer> mapEntryRemoteWareHouse: remoteWarehouse.entrySet()){
                if(mapEntryMainWareHouse.getKey().equals(mapEntryRemoteWareHouse.getKey())){
                    mainWarehouse.put(mapEntryRemoteWareHouse.getKey(), mapEntryRemoteWareHouse.getValue());
                } else{
                    mainWarehouse.put(mapEntryRemoteWareHouse.getKey(), mapEntryRemoteWareHouse.getValue());
                }
            }

        }*/

        // There is no need to create third warehouse transfer remote to main
        // if keys match put to mainwarehouse
        for(String keysFromMainWareHouse: mainWarehouse.keySet()){
            if(remoteWarehouse.containsKey(keysFromMainWareHouse)){
                mainWarehouse.put(keysFromMainWareHouse, (remoteWarehouse.get(keysFromMainWareHouse) + mainWarehouse.get(keysFromMainWareHouse)));
            }
            else{
                mainWarehouse.put(keysFromMainWareHouse, mainWarehouse.get(keysFromMainWareHouse));
            }
        }
        for(String keyFromRemoteWareHouse: remoteWarehouse.keySet()){
            if(!(mainWarehouse.containsKey(keyFromRemoteWareHouse))){
                mainWarehouse.put(keyFromRemoteWareHouse, remoteWarehouse.get(keyFromRemoteWareHouse));
            }
        }
        return mainWarehouse;
    }

    /*
     * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
     *
     * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
     * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
     *
     * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
     * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
     * end subString, which we don't count.
     *
     * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
     *
     * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
     *
     */
    //Create Map inorder to return
    // As I have array of the words (String[] words) i need some kind of loop for each word
    // for each word get the number of times the last 2 appear
    // put in the map where word is the key and the count is value
    public Map<String, Integer> last2Revisited(String[] words) {

        Map<String, Integer> endCounts = new HashMap<String, Integer>();


        for (String word : words) {
            String end = word.substring(word.length() - 2);
            int count = 0;
            for (int i = 0; i < word.length() - 2; i++) {
                if (word.substring(i, i + 2).equals(end)) {
                    count++;
                }
            }
            endCounts.put(word, count);
        }

        return endCounts;
    }

}
