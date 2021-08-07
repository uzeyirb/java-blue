package exercises099;

public class FruitTreeOne {

    /*
    Member Variables also known as Instance Variables hold the data.
    Member variables create object state.
    Access Modifiers define class variables that represent its properties.
    They control visibility to methods and properties to the rest of your program.

    */
    private String typeOfFruit;
    private int  piecesOfFruitLeft;

     /*
    Getters and Setters should be the only way to access member variables from
    outside the class. Getters and Setter are always public
    Getter and Setter methods should always begin with the "get" or "set" prefix,
    except for Getter methods that return a boolean, which should begin with the prefix "is".
    This this keyword refers to the member variable
    specific to the instance of an object where the code is run.
    */

    public String getTypeOfFruit(){
        return this.typeOfFruit;
    }

    public int getPiecesOfFruitLeft(){
        return this.piecesOfFruitLeft;
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

    public FruitTreeOne(String typeOfFruit, int startingPiecesOfFruit ){
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = startingPiecesOfFruit;

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

    public boolean pickFruit(int numberOfPiecesToRemove ){
        if(piecesOfFruitLeft >= numberOfPiecesToRemove ){
            piecesOfFruitLeft -= numberOfPiecesToRemove;
            return true;
        }
        return false;
    }

}
