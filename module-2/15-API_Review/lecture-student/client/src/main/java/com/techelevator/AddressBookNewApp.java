package com.techelevator;

import com.techelevator.addressbook.services.ConsoleNewService;
import com.techelevator.addressbook.services.ContactsNewService;
import com.techelevator.addressbook.services.model.ContactNew;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;

import java.util.List;

public class AddressBookNewApp {
    private static final String API_URL = "http://localhost:8080/";
    private ContactsNewService contactsNewService = new ContactsNewService(API_URL);
    private ConsoleNewService consoleNewService = new ConsoleNewService();


    public void run(){
        while(true){
            String userChoice = consoleNewService.mainMenu();
            if(userChoice.equalsIgnoreCase("1")){
                showAllContacts();
            } else if(userChoice.equalsIgnoreCase("Q")){
                break;
            }

        }

    }

    private void showAllContacts(){
        try{
            List<ContactNew> contactNews = contactsNewService.getAllContacts();
            consoleNewService.showContacts(contactNews);
        }catch (ResourceAccessException e){

            consoleNewService.errorCannotConnect();
        } catch (RestClientResponseException e){
            consoleNewService.errorClientException(e.getRawStatusCode(), e.getMessage());
        }

    }

    public static void main(String[] args) {
        new AddressBookNewApp().run();
    }
}
