package com.techelevator.addressbook.model.dao;

import com.techelevator.addressbook.model.Contact;
import com.techelevator.addressbook.model.ContactNew;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * The DAO will be injected into the controller by dependency injection,
 *  so the JdbcDAO class will need the @Component annotation and to accept
 *  and  to accept a JdbcTemplate as a constructor argument
 *  then instantiate JdbcTemplate Object private JdbcTemplate jdbcTemplate;
 */

@Component
public class JdbcContactNewDAO implements ContactNewDAO{

    private JdbcTemplate jdbcTemplate;

    /**
     * Normally we were passing datasource as parameters to JdbcContactNewDAO
     * As we are using Spring Boot we will pass that responsibility to SpringBoot by
     * having resources folder and application.properties file.
     * Spring Boot will get datasource from configuration build it create JdbcTemplate and
     * will inject JdbcTemplate for us prebuilt. Which means there is only one Jdbc for all of our
     * DAO's which is efficient
     * @param jdbcTemplate
     */
    public JdbcContactNewDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<ContactNew> list() {

        String sql = "SELECT contact_id, first_name, last_name, date_added FROM contact";
        List<ContactNew> contacts = new ArrayList<ContactNew>();
        /**
         * it also stores tabular data, in addition to the features
         * The RowSet interface provides methods to set Java bean properties
         * to connect it to the required database −
         */
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while (rows.next()){
            contacts.add(mapRowsToContact(rows));
        }
        return contacts;
    }

    private ContactNew mapRowsToContact( SqlRowSet rows){

        ContactNew contact = new ContactNew();
        contact.setContactId(rows.getLong("contact_id"));
        contact.setFirstName(rows.getString("first_name"));
        contact.setLastName(rows.getString("last_name"));
        if(rows.getDate("date_added") != null){
            contact.setDateAdded(rows.getDate("date_added").toLocalDate());
        }

        return contact;

    }
}
