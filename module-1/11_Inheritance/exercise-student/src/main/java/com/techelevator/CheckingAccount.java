package com.techelevator;

public class CheckingAccount extends BankAccount {

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
   private final int OVERDRAFT_LIMIT = -100;
   private final int OVERDRAFT_FEE = 10;

    public CheckingAccount(String accountHolderName, String accountNumber, int balance){
        super (accountHolderName, accountNumber, balance);

    }
    public CheckingAccount(String accountHolderName, String accountNumber){
        super (accountHolderName, accountNumber);

    }

    @Override
    public int withdraw(int amountToWithdraw){

        int withdrawnBalance = super.getBalance() - amountToWithdraw;
        if(withdrawnBalance > OVERDRAFT_LIMIT && withdrawnBalance < 0){
            return super.withdraw(amountToWithdraw + OVERDRAFT_FEE);
        } else if( withdrawnBalance < OVERDRAFT_LIMIT){
            return super.getBalance() ;
        } else{
            return super.withdraw(amountToWithdraw);
        }

    }




}
