package com.techelevator.addressbook.controller;

import com.techelevator.addressbook.model.ContactNew;
import com.techelevator.addressbook.model.dao.ContactNewDAO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public class ContactNewController {

    private ContactNewDAO contactNewDAO;

    /**
     * Error creating bean means it could not build class/ could not instantiate
     * On line 21 we did dependency injection
     * @param contactNewDAO
     */
    public ContactNewController(ContactNewDAO contactNewDAO){
        this.contactNewDAO = contactNewDAO;
    }

    /**
     * RequestMapping is what exposes us to API
     * @return
     */
    @RequestMapping(path = "/contacts", method = RequestMethod.GET)
    public List<ContactNew> list(){
        return contactNewDAO.list();
    }

}
