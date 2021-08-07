package com.techelevator.addressbook;

import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.SQLException;
import java.util.List;

public class JdbcPhoneDAOIntegrationTest {

    private static SingleConnectionDataSource dataSource;
    private PhoneDAO phoneDAO;
    private JdbcTemplate jdbcTemplate;
    private long testContactId;
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
    public void setup(){

        phoneDAO = new JdbcPhoneDAO(dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, hire_date)" +
        "VALUES(default, ?, ?, ?, ?, ?) returning employee_id";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);
        row.next();
        testContactId = row.getLong("contact_id");



    }

    @Test
    public void retrieve_phone_by_contact(){

        //Arrange
        //1) create a phone
        //  -- require a contact_phone row
        //    --- contact_phone requires a contact
        Phone newPhone = new Phone();
        newPhone.setPhoneNumber("1-555-555-5555");
        newPhone.setType("Mobile");
        phoneDAO.add(newPhone, testContactId);

        //Act
        List<Phone> contactPhone = phoneDAO.getByContact(testContactId);

        //Test
        Assert.assertNotNull("Phone list was null", contactPhone);
        Assert.assertEquals("Phone list was not 1", 1, contactPhone);

        Phone returnedPhone = contactPhone.get(0);
        assertPhoneEqual(newPhone, returnedPhone);
    }

    private void assertPhoneEqual(Phone expected, Phone actual){
        Assert.assertEquals("Phone id not equal", expected.getPhoneId(), actual.getPhoneId());
        Assert.assertEquals("Phone number not equal", expected.getPhoneNumber(), actual.getPhoneNumber());
        Assert.assertEquals("Phone type not equal", expected.getType(), actual.getType());
        Assert.assertEquals("Phone type description", expected.getTypeDescription(), actual.getTypeDescription());
    }

}
