package com.techelevator.addressbook;

import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class JdbcContactDAOIntegrationTest {
    private static SingleConnectionDataSource dataSource;
    private ContactDAO contactDAO;
    private JdbcTemplate jdbcTemplate;
    /*
     Before class runs once before all the test are run
     Setups and configures the datasource
     */
    @BeforeClass

    public static void setDataSource(){
        //Instantiate and configure the datasource

        dataSource =  new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/addressbook");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        //Set autoCommit
        dataSource.setAutoCommit(false);

    }

    /*
    Afterclass runs once after all the tests are run
    Destroys the datasource which disconnects from the database
     */
    @AfterClass

    public static void destroyDataSource(){
        dataSource.destroy();
    }

    /*
    After runs after each individual test method is run
    Rollback the transaction
     */
    @After
    public void rollbackTransaction() throws SQLException {
        dataSource.getConnection().rollback();
    }

    /* Before runs before individual test method is run
    instantiate object being tested (JdbcDAo) and insert any shared test data

     */
    @Before
    public void setupBeforeTest(){

        contactDAO = new JdbcContactDAO(dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);

    }

    /*
    Testing select for single object
     */

    @Test

    public void retrieve_contact_by_contact_id(){
        //Arrange  - create a contact and store it, then insert it into the database
        Contact contact = getContact("testFirstName", "testLastName");
        contactDAO.create(contact);

        //Act
        Contact contactFromDatabase = contactDAO.getById(contact.getContactId());
        //Assert
        Assert.assertNotNull("Contact was null", contactFromDatabase);
        Assert.assertEquals("Contacts not equal", contact, contactFromDatabase);
    }


    /*
    Select with multiple objects being returned
     */

    @Test

    public void retrieve_multiple_contacts(){

        //Arrange
        //Get a count of the number of values in the table
        List<Contact> originalList = contactDAO.list();
        // insert multiple contacts
        Contact contactOne = getContact("firstOne", "lastOne");
        Contact contactTwo = getContact("firstTwo", "lastTwo");
        contactDAO.create(contactOne);
        contactDAO.create(contactTwo);
        //Act
        List<Contact> contactsFromDatabase = contactDAO.list();
        //Assert
        Assert.assertEquals("There is mismatch in number of retrieved entries",originalList.size() + 2, contactsFromDatabase.size());

    }

    /*
    Insert
     */

    @Test
    public void insert_contact(){
        //Arrange
        Contact newContact = getContact("testFirst", "testLast");

        //Act
        contactDAO.create(newContact);

        //Assert

        Assert.assertTrue("New Contact was not added successfully", newContact.getContactId() > 1);

        //retrieve the contact from the database

        Contact contactFromDatabase = contactDAO.getById(newContact.getContactId());
        Assert.assertEquals("Insert_contact was not successful", newContact, contactFromDatabase);

    }

    /*
    Update
    Examples do not use methods from the DAO
     */

    @Test
    public void update_contact(){
        //Arrange create and insert a new contact
        Contact newContact = getContact("firstName", "lastName");
        insertNewTestContact(newContact);

        //Act change the contact and call the update method
        newContact.setFirstName("updatedFirstName");
        newContact.setLastName("updatedLastName");
        contactDAO.save(newContact);
        Contact contactFromDatabase = retrieveContactById(newContact.getContactId());
        Assert.assertNotNull("Contact not found",contactFromDatabase);
        Assert.assertEquals("Contact not equal", newContact, contactFromDatabase);
    }
    /*
    Delete
     */
    @Test
    public void delete_contact(){
        //Arrange create and insert a new contact
        Contact newContact = getContact("firstName", "lastName");
        insertNewTestContact(newContact);

        //Act - call the delete method on the DAO

        contactDAO.delete(newContact.getContactId());

        // Assert verify that the contact is no longer in the database
        Assert.assertNull(retrieveContactById(newContact.getContactId()));

    }

    private Contact retrieveContactById(long contactId){
        Contact contact = null;
        String sql = "SELECT contact_id, first_name, last_name, date_added FROM contact " +
                "WHERE contact_id = ?";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, contactId);
        if(row.next()){
            contact = new Contact();
            contact.setContactId(row.getLong("contact_id"));
            contact.setFirstName(row.getString("first_name"));
            contact.setLastName(row.getString("last_name"));
            contact.setDateAdded(row.getDate("date_added").toLocalDate());
        }
        return contact;
    }


    private void insertNewTestContact(Contact newContact){
        String sql = "INSERT INTO contact (contact_id, first_name, last_name, date_added) " +
                "VALUES (DEFAULT, ?, ?, ?) RETURNING contact_id";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, newContact.getFirstName(), newContact.getLastName(),
                newContact.getDateAdded());
        rows.next();
        newContact.setContactId(rows.getLong("contact_id"));
    }


    private Contact getContact(String firstName, String lastName){
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setDateAdded(LocalDate.now());

        return contact;

    }



}
