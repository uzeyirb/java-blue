package com.techelevator.addressbook.services.model;

import java.time.LocalDate;

public class Contact {
    private long contactId;
    private String firstName;
    private String lastName;
    private LocalDate dateAdded;
        // on client side we create object based on json not database
    //it is required for the framework to instantiate empty constructor.
    public Contact(){

    }

    public Contact(long contactId, String firstName, String lastName, LocalDate dateAdded) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateAdded = dateAdded;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateAdded(LocalDate date_added) {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public boolean getDateAdded() {
        return false;
    }
}
