package com.techelevator.addressbook.services;

import com.techelevator.addressbook.services.model.ContactNew;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class ContactsNewService {

    private String apiUrl;
    private RestTemplate restTemplate = new RestTemplate();

    public ContactsNewService(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public List<ContactNew> getAllContacts() {
        ContactNew[] contacts = restTemplate.getForObject(apiUrl + "contacts", ContactNew[].class);
        return Arrays.asList(contacts);
    }
}
