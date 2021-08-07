package vehicle;

import java.util.Locale;

public class Bus {

    /*
    Sometimes we have constant values, or values that can not be changed,
    that we want to use in our code without duplicating the value all over the place.
    Many languages have the concept of constant and global constant variables, however,
    Java does not, but we can mimic one using the final keyword.
    Static members belong to the class. Instance members belong to an instance of the class.
    Static methods can be invoked without creating an instance of the class.
    Static variables and methods cannot be accessed with the this keyword,
    since they are not part of the object.
    Since static variables are shared by all instances of a class and not the individual object.
    Changes to the value from one object can be seen from all objects of that type.
    final creates a variable that can be assigned once and only once
    static creates a variable that is shared among all objects created from this class
    final static together form what most other programming languages call a constant

     */
    private final int TOTAL_SEATS = 40;

    /*
    Member Variables also known as Instance Variables hold the data.
    Member variables create object state.
    Access Modifiers define class variables that represent its properties.
    They control visibility to methods and properties to the rest of your program.

    */
    private String routeName;
    private int passengers;
    private int gallonsOfGas = 50; // sets starting value to 50
    private boolean isDoorOpen = false; // sets starting value to false

    /*
    A derived property is a getter that, instead of returning a member variable,
    returns a calculation taken from member variables. If we have firstName and lastName,
    we don't need to also store fullName, we can derive it from what we already have.

    */

    public int getRemainingSeats(){
        return TOTAL_SEATS - this.passengers;
    }

    /*
    Getters and Setters should be the only way to access member variables from
    outside the class. Getters and Setter are always public
    Getter and Setter methods should always begin with the "get" or "set" prefix,
    except for Getter methods that return a boolean, which should begin with the prefix "is".
    This this keyword refers to the member variable
    specific to the instance of an object where the code is run.
    */

    public String getRouteName(){
        return this.routeName;
    }
    public void setRouteName(String routeName){
        this.routeName = cleanUpRouteName(routeName);
    }
    public int getGallonsOfGas(){
        return this.gallonsOfGas;
    }
    public boolean isDoorOpen(){
        return this.isDoorOpen;
    }


    /*
    A function or method, is like a mathematical function (e.g. f(n) = n^2 ).
    Methods can have multiple parameters but can only return one value (for now).
    Public methods define object behaviors.
    Public and Private Methods help by
    making the code base manageable with smaller chunks
    reducing code into small units of work, making debugging simpler
    and introducing reuse.
    Overloaded methods are methods with the same name and return type,
    and a different set of parameters.  Java uses the correct overload based on the
    parameters sent to it.  In the code below we will overload it to make more functional

    */
    /*public boolean board(){
        if(this.isDoorOpen == true && getRemainingSeats() >= 1){
            this.passengers += 1;
            return true;
        }
        return false;
    }*/

    public boolean board(int peopleBoarding){
        if(this.isDoorOpen && getRemainingSeats() >= peopleBoarding){
            this.passengers += peopleBoarding;
            return true;
        }
        return false;
    }
    /*
    Private method provides reusable code that is only available in this class
    */
    private String cleanUpRouteName(String routeName){
      String name = routeName.replaceAll(" ", "");
      return name.toUpperCase();
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

    public Bus(){

    }

    public Bus(String routeName){
        this.routeName = cleanUpRouteName(routeName);
    }

    public void openDoor(){
        this.isDoorOpen = true;
    }
    public void closeDoor(){
        this.isDoorOpen = false;
    }

    /*
    Some methods will be “inherit” from other classes.   For example, all class “inherit”
    the methods toString() and equals()
    If we want to provide our own functionality for these methods we can create an “Override”
    which will hide the original methods functionality and provide our own.
    To override a method, we must provide an identical method signature as the one being overridden.  Though not required, It also a good practice to include the @Override annotation for readability.

     */
    @Override
    public String toString(){
        //Can return any string that represents our object as a String
        // Either with the raw values or formatted they may be want it present
        return "Bus routName = " + this.routeName+
                "passengers = " + this.passengers+
                " gallonsOfGas = " + this.gallonsOfGas +
                "isDoorOpen =" + this.isDoorOpen + ".";

    }
    @Override
    public boolean equals(Object other){
        if( this == other){
            return true;
        }
        Bus otherBus = (Bus) other;
        if(this.routeName.equals(otherBus.getRouteName()) &&
                this.gallonsOfGas == otherBus.getGallonsOfGas() &&
                this.getRemainingSeats() == otherBus.getRemainingSeats())
        {
            return true;
        }
        return false;
    }
}
