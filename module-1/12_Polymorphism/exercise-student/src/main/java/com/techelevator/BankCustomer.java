package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

     /*
    Member Variables also known as Instance Variables hold the data.
    Member variables create object state.
    Access Modifiers define class variables that represent its properties.
    They control visibility to methods and properties to the rest of your program.

    */

    private String name;
    private String address;
    private String phoneNumber;
    private int getBalance;


    private List<Accountable> accounts = new ArrayList<Accountable>();

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
    private final int VIP_CUSTOMER_ELIGIBILITY_AMOUNT = 25000;

    /*
  Getters and Setters should be the only way to access member variables from
  outside the class. Getters and Setter are always public
  Getter and Setter methods should always begin with the "get" or "set" prefix,
  except for Getter methods that return a boolean, which should begin with the prefix "is".
  This this keyword refers to the member variable
  specific to the instance of an object where the code is run.
  */
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    /*public List < Accountable> getAccounts() {
        return accounts;
    }*/

    public Accountable[] getAccounts() {
        return accounts.toArray(new Accountable[accounts.size()]);
    }

    //addAccount(Accountable newAccount)	void	Adds newAccount to the customer's list of accounts

    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
    public boolean isVip() {
        if (this.getBalance() >= VIP_CUSTOMER_ELIGIBILITY_AMOUNT) {
            return true;
        }

        return false;
    }

    public int getBalance() {
        int totalBalance = 0;
        for (Accountable acc : accounts) {

            totalBalance += acc.getBalance();
        }
        return totalBalance;
    }


    /*public BankCustomer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }*/

    public BankCustomer() {
        super();

    }


}
