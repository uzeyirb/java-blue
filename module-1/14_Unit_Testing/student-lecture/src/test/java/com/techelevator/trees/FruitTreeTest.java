package com.techelevator.trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FruitTreeTest {
    /*
    Possible Tests
        -What type of fruit it has
        - How many pieces of fruit on the tree
        - Can pick fruit when not empty
        - Cannot pick fruit when empty
        - Can we pick all the fruit at once
        - Can not pick to much fruit
        - Can pick 0 fruit
        - Can pick -1 fruit
        - what happens when type of fruit is null
        - can pick fruit multiple times
        - can pick some fruit, then remaining fruit, and then no more
     */

    private FruitTree fruitTree;

    @Before

    public void runThisBeforeEveryTestRuns(){
        fruitTree =  new FruitTree("pear", 10);
    }

    @Test
    public void can_pick_fruit(){
        //Arrange
        // Act
        boolean wasSuccessful = fruitTree.pickFruit(3);
        //Assert
        Assert.assertTrue(wasSuccessful);
        int remainingFruit = fruitTree.getPiecesOfFruitLeft();
        Assert.assertEquals(7, remainingFruit);
    }

    @Test
    public void can_pick_fruit_multiple_times(){
        //Arrange
        fruitTree.pickFruit(5);

        //Act

        boolean wasSuccessful = fruitTree.pickFruit(3);

        //Assert

        Assert.assertTrue("PickFruit returned false", wasSuccessful);

        int remainingFruit = fruitTree.getPiecesOfFruitLeft();
        Assert.assertEquals("Not the correct fruit remaining", 2, remainingFruit);
    }

    @Test
    public void cannot_pick_too_much_fruit(){
        //Act
        boolean wasSuccessful = fruitTree.pickFruit(11);

        //Assert

        Assert.assertFalse(wasSuccessful);
        Assert.assertEquals(10, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void cannot_pick_more_fruit_after_picking_all_the_fruit(){
        //Arrange
        fruitTree.pickFruit(5);
        fruitTree.pickFruit(4);

        //Act

        boolean wasSuccessful = fruitTree.pickFruit(2);

        //Assert

        Assert.assertFalse(wasSuccessful);
        Assert.assertEquals(1, fruitTree.getPiecesOfFruitLeft());

    }

    @Test
    public void cannot_pick_negative_fruit(){
        //Arrange

        //Act

        boolean wasSuccessful = fruitTree.pickFruit(-1);
        Assert.assertFalse("Expected false but was true",  wasSuccessful);
        Assert.assertEquals(10, fruitTree.getPiecesOfFruitLeft());

    }
}
