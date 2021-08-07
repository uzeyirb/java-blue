package com.techelevator;

public class SquareWall extends  RectangleWall{

    private int sideLength;
    private String name;

    public int getSideLength() {
        return sideLength;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getArea() {
        return this.sideLength * this.sideLength;
    }

    public SquareWall(String name, String color, int sideLength) {
        super(name, color);

        this.sideLength = sideLength;
    }


    @Override
    public String toString() {
        return super.getName() + " (" + sideLength +
                "x"  + sideLength +") "+ "square" ;
    }
}
