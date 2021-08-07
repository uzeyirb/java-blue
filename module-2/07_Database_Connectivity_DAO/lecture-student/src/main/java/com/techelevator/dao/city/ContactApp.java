package com.techelevator.dao.city;

import com.techelevator.dao.addressbook.Contact;
import com.techelevator.dao.addressbook.ContactDAO;
import com.techelevator.dao.addressbook.JdbcContactDAO;
import org.apache.commons.dbcp2.BasicDataSource;

import java.time.LocalDate;
import java.util.List;

public class ContactApp {

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/addressbook");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");


        ContactDAO contactDAO = new JdbcContactDAO(dataSource);

        Contact newContact = new Contact();
        newContact.setFirstName("John");
        newContact.setLastName("Fulton");
        newContact.setDateAdded(LocalDate.now());

        contactDAO.create(newContact);


        List<Contact> contacts = contactDAO.list();

        for(Contact contact:contacts){
            System.out.println(contact.getFirstName() + " "
            + contact.getLastName());
        }
    }
}
