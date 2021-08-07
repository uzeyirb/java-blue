package com.techelevator.dao.addressbook;

import java.util.List;

public interface ContactDAO {
    //Get a list of all contacts
    List<Contact> list();
    //Get a single contact by the contact id
    Contact getById(long id);
    //CReate a contact
    void create(Contact contact);

    //Save a contact
    void save(Contact contact);

    //Delete a contact
    void delete(Long id);
}
