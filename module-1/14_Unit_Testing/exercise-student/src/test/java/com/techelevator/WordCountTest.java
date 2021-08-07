package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {

    /*
    An instance variable to reference the class we are testing.
    We cannot test interfaces and abstract classes.
    always test only concrete classes; don’t test abstract classes
    directly. The reason is that abstract classes are implementation
    details. From the client perspective, it does not matter how Student
    or Professor implement their GetSignature() methods. They could derive it
    from a base class like in our case, but they could also just implement their
    own copy of it. Targeting tests at the abstract base class binds them to the
    code’s implementation details. This, in turn, makes those tests fragile.
     */


    public WordCount wordCount;

     /*
    Methods annotated with the @Before annotation are run before each test.
     This is useful when we want to execute some common code before running a test.
     */

    @Before
    public void setup() {
        wordCount = new WordCount();

        Map<String, Integer> output = new HashMap<>();

    }
    /*
    Methods annotated with the @After annotation are run after each test.
     This is useful when we want to execute some common code after running a test.
     */

    @After
    public void cleanup() {
        // do code that cleans up or reset here


    }

    /*

    Test for
    ["ba", "ba", "black", "sheep"])     → {"ba" : 2, "black": 1, "sheep": 1 }
    ["a", "b", "a", "c", "b"])          → {"a": 2, "b": 2, "c": 1}
    [])                                 → {}
    ["c", "b", "a"])                    → {"c": 1, "b": 1, "a": 1}

     */

    @Test

    public void assert_word_count_equals() {
        //Arrange (Setup)
        String[] testStringArray = {"ba", "ba", "black", "sheep"};
        Map<String, Integer> expectedResult = new HashMap<String, Integer>();
        expectedResult.put("ba", 2);
        expectedResult.put("black", 1);
        expectedResult.put("sheep", 1);

        Map<String, Integer> actualResult = wordCount.getCount(testStringArray);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test

    public void assert_word_count_equals_false() {
        //This test fails intentionally to check the test code
        //Arrange (Setup)
        String[] testStringArray = {"ba", "ba", "black", "sheep"};
        Map<String, Integer> expectedResult = new HashMap<String, Integer>();
        expectedResult.put("ba", 2);
        expectedResult.put("black", 1);
        expectedResult.put("sheep", 2);

        Map<String, Integer> actualResult = wordCount.getCount(testStringArray);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test

    public void assert_single_char_word_count_equals_true() {
        //Test for    ["a", "b", "a", "c", "b"])          → {"a": 2, "b": 2, "c": 1}
        //Arrange (Setup)
        String[] testStringArray = {"a", "b", "a", "c", "b"};
        Map<String, Integer> expectedResult = new HashMap<String, Integer>();
        expectedResult.put("a", 2);
        expectedResult.put("b", 2);
        expectedResult.put("c", 1);

        Map<String, Integer> actualResult = wordCount.getCount(testStringArray);
        Assert.assertEquals(expectedResult, actualResult);
    }


    @Test

    public void assert_empty_array_count_equals_true() {
        //Test for      [])                                 → {}
        //Arrange (Setup)
        String[] testStringArray = {};
        Map<String, Integer> expectedResult = new HashMap<String, Integer>();


        Map<String, Integer> actualResult = wordCount.getCount(testStringArray);
        Assert.assertEquals(expectedResult, actualResult);
    }
}
