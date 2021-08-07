package com.techelevator.addressbook.model.dao;

import com.techelevator.addressbook.model.ContactNew;
import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class JdbcContactNewDAOIntegrationTest {
private static SingleConnectionDataSource dataSource;
private ContactNewDAO contactNewDAO;
private JdbcTemplate jdbcTemplate;
    @BeforeClass

    public static void setupDataSource(){
        dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/addressbook");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        dataSource.setAutoCommit(false);
    }

    @AfterClass
    public static void destroyConnection(){
        dataSource.destroy();
    }

    @After
    public void rollback() throws SQLException{
        dataSource.getConnection().rollback();
    }

    /**
     * Thre are multiple ways of doing Dependency Injection
     * @Autorwired is another way of Dependency Injection
     * But in order to do integration testing of this code we need
     * to use SpringTesting Framework
     * When we pass JdbcTemp to our construction we become container
     * to our test. Container means we will instantiate JdbcTemp and
     * pass to constructor.
     */
    @Before
    public void setup(){
        jdbcTemplate = new JdbcTemplate(dataSource);
        contactNewDAO = new JdbcContactNewDAO(jdbcTemplate);
    }

    @Test
    public void get_List_of_all_contacts(){
        List<ContactNew> originalContacts = contactNewDAO.list();
        addContact(new ContactNew(0, "testFirst", "testLast", LocalDate.now()));
        List<ContactNew> contactAfterAdd = contactNewDAO.list();
        Assert.assertEquals(originalContacts.size() + 1, contactAfterAdd.size());
    }

    private void addContact(ContactNew contactNew){
        String sql = "INSERT INTO contact (contact_id, first_name, last_name, date_added) VALUES (DEFAULT, ?, ?, current_timestamp)";
        jdbcTemplate.update(sql, contactNew.getFirstName(), contactNew.getLastName());
    }
}
