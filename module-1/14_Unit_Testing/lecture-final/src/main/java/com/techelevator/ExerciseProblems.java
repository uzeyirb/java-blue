package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExerciseProblems {

    /*
      1. The parameter weekday is true if it is a weekday, and the parameter vacation is true if we are on
      vacation. We sleep in if it is not a weekday or we're on vacation. Return true if we sleep in.
      sleepIn(false, false) → true
      sleepIn(true, false) → false
      sleepIn(false, true) → true
      */
    public boolean sleepIn(boolean weekday, boolean vacation) {
        boolean sleepIn = !weekday || vacation;
        return sleepIn;
    }

    /*
     3. Given two int values, return their sum.
     Unless the two values are the same,
     then return double their sum.
     sumDouble(1, 2) → 3
     sumDouble(3, 2) → 5
     sumDouble(2, 2) → 8
     */
    public int sumDouble(int a, int b) {
        if (a == b) {
            return 2 * (a + b);
        } else {
            return a + b;
        }
    }

    /*
     7. Given 2 int values, return true if one is negative and one is positive. Except if the parameter
     "negative" is true, then return true only if both are negative.
     posNeg(1, -1, false) → true
     posNeg(-1, 1, false) → true
     posNeg(-4, -5, true) → true
     */
    public boolean posNeg(int a, int b, boolean negative) {
        if (negative) {
            return a < 0 && b < 0; // both negative
        } else {
            return (a < 0) ^ (b < 0); //one positive one negative
        }
    }


    /*
     Given a string, return a version without both the first
     and last char of the string. The string
     may be any length, including 0.
     withoutEnd2("Hello") → "ell"
     withoutEnd2("abc") → "b"
     withoutEnd2("ab") → ""
     */
    public String withoutEnd2(String str) {
        if (str.length() <= 2) {
            return "";
        }
        return str.substring(1, str.length() - 1);
    }

}
