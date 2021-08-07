package com.techelevator;

public class CreditCardAccount implements Accountable{

    /*
    Member Variables also known as Instance Variables hold the data.
    Member variables create object state.
    Access Modifiers define class variables that represent its properties.
    They control visibility to methods and properties to the rest of your program.

    */

    public String accountHolder;
    public String accountNumber;
    public int debt =0;


    /*
   Getters and Setters should be the only way to access member variables from
   outside the class. Getters and Setter are always public
   Getter and Setter methods should always begin with the "get" or "set" prefix,
   except for Getter methods that return a boolean, which should begin with the prefix "is".
   This this keyword refers to the member variable
   specific to the instance of an object where the code is run.
   */

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getDebt() {
        return debt;
    }
    //CreditCardAccount(String accountHolder, String accountNumber)

    public CreditCardAccount(String accountHolder, String accountNumber){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.debt = 0;
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
    /*
    A derived property is a getter that, instead of returning a member variable,
    returns a calculation taken from member variables. If we have firstName and lastName,
    we don't need to also store fullName, we can derive it from what we already have.

    */

    //pay(int amountToPay)	int	Removes amountToPay from the amount owed and returns the new total amount owed.


    public int pay(int amountToPay){
        debt -= amountToPay;
        return debt;
    }
    //charge(int amountToCharge)	int	Adds amountToCharge to the amount owed, and returns the new total amount owed.
    public int charge(int amountToCharge){
        debt += amountToCharge;
        return debt;
    }

    @Override
    public int getBalance() {
        return -debt;
    }

}
