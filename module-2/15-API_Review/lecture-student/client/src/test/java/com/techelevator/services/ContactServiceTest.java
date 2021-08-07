package com.techelevator.services;

import com.techelevator.addressbook.services.ConsoleService;
import com.techelevator.addressbook.services.ContactsService;
import com.techelevator.addressbook.services.model.Contact;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ContactServiceTest {

    private ContactsService service;

    @Before

    public void setup(){
        service =  new ContactsService("http://localhost:8080/");

    }
    @Test
    public void get_all_contacts(){
        List<Contact> contacts = service.getAllContacts();
        Assert.assertTrue(contacts.size() > 0);
    }

}
