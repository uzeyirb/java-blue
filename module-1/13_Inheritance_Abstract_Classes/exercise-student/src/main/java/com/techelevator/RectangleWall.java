package com.techelevator;

public class RectangleWall extends Wall{

    /*
    Member Variables also known as Instance Variables hold the data.
    Member variables create object state.
    Access Modifiers define class variables that represent its properties.
    They control visibility to methods and properties to the rest of your program.

    */

    private int length;
    private int height;

    public RectangleWall() {
        super();
    }

    public RectangleWall(String name, String color) {
        super(name, color);
    }



    /*
   Getters and Setters should be the only way to access member variables from
   outside the class. Getters and Setter are always public
   Getter and Setter methods should always begin with the "get" or "set" prefix,
   except for Getter methods that return a boolean, which should begin with the prefix "is".
   This this keyword refers to the member variable
   specific to the instance of an object where the code is run.
   All fields must be readonly fields. This means each field has a getter, but not a setter.
   */

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    /*
    A constructor is a special method that runs every time a new object is instantiated.
    It allows for the object to be initialized with a starting state.
    The name must exactly match the Class name
    It has no return type
    Can have arguments that set the value of member variables, like a Setter.
    Can be Overridden to provide multiple ways to instantiate the object
    If no constructor is present, then Java provides a default constructor, which has no arguments.
    if any constructor is present then the default constructor is not provided,
    and if a no-argument overload of the constructor is needed, then it must be explicitly created.
    Important: Constructor can call any private method but it should never call public method for 2
    reasons: 1. Security and public method we can change from outside of the class
    2. it is possible that the way java works when it is built it take all private methods and it is
    possible when it will call public method and it will not be there and the build will crash
    We can have multiple constructor overloads with different sets of arguments
    If there is a constructor Overload then the no-argument constructor must be explicitly included
    if we want the class to be able to instantiated without passing arguments
    for example: Bus bus = new Bus();
     */

    public RectangleWall(String name, String color, int length, int height) {
        super(name, color);
        this.length = length;
        this.height = height;
    }

    @Override
    public int getArea() {
        return length * height;
    }

    @Override
    public String toString() {
        return super.getName() + " (" + this.getLength() +
                "x"  + this.getHeight() +") "+ "rectangle" ;
    }
}
