package com.techelevator.services;

import com.techelevator.addressbook.services.ContactsNewService;
import com.techelevator.addressbook.services.model.ContactNew;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class ContactNewServiceTest {


    private ContactsNewService contactsNewService;


    @Before

    public void setup(){
        contactsNewService = new ContactsNewService("http://localhost:8080/");
    }

    @Test
    //This is not valid unit test but it takes advantages of unit test to help us work
    public void get_all_contact(){
        List<ContactNew> contactNew = contactsNewService.getAllContacts();
        Assert.assertTrue(contactNew.size() > 0);
    }

}
