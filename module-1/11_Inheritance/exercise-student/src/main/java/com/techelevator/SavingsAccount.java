package com.techelevator;

public class SavingsAccount extends BankAccount {

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

    private final int OVERDRAFT_LIMIT = 150;
    private final int OVERDRAFT_FEE = 2;


    public SavingsAccount(String accountHolderName, String accountNumber, int balance){
        super (accountHolderName, accountNumber, balance);

    }
    public SavingsAccount(String accountHolderName, String accountNumber){
        super (accountHolderName, accountNumber);

    }


    @Override
    public int withdraw(int amountToWithdraw){

        int balanceAfterAmountWithdraw = super.getBalance() - amountToWithdraw;
        if(super.getBalance() < amountToWithdraw){
            return super.getBalance();
        }  else if( balanceAfterAmountWithdraw < OVERDRAFT_LIMIT){
            return super.withdraw(amountToWithdraw + OVERDRAFT_FEE);
        }else{
            //If a withdrawal is requested for more than the current balance, the withdrawal fails and the balance remains the same. No fees are incurred.
            return super.withdraw(amountToWithdraw);
        }

    }
}
//if (super.getBalance() - amountToWithdraw < super.getBalance()){
//            return super.getBalance();