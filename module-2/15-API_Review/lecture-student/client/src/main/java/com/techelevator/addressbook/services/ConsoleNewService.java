package com.techelevator.addressbook.services;

import com.techelevator.addressbook.services.model.ContactNew;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;
public class ConsoleNewService {
    private static final Scanner in = new Scanner(System.in);

    public void errorCannotConnect(){
        System.out.println("Can not connect to server! ");

    }
    public void errorClientException(int statusCode, String message){
        System.out.println(statusCode + " " + message);
    }

    public String mainMenu(){
        System.out.println("1) Show All Contacts");
        System.out.println("Q) Quit");
        return in.nextLine();
    }

    public void showContacts(List<ContactNew> contactNewList){
        for(int i = 0; i < contactNewList.size(); i++){
            System.out.print((i + 1) + ") ");
            System.out.print(contactNewList.get(i).getContactId() + " ");
            System.out.print(contactNewList.get(i).getFirstName() + " ");
            System.out.print(contactNewList.get(i).getLastName() + " ");
            System.out.println(contactNewList.get(i).getDateAdded());
        }
    }
}
