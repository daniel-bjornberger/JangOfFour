package databasehandling;

import contacthandling.Contact;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Pontus Fredriksson
 */
class SearchPageDbTest {


    /**
     * Removes the contact we tested with from database.
     */
    @AfterAll
    static void breakdown(){
        Contact contact = new Contact(-54321, "TESTCALLDB","TEST" , "1234567897", "testroad 4","a@b.com" );

        DeleteDb.callDb(DBValidator.getCon(),contact );
    }

    /**
     *  Adds a contact in database and asserts that a contact in the
     *  database matches the inputed one.
     */
    @Test
    void callDbReturnsContactInDatabase(){
        Contact contact = new Contact(-54321, "TESTCALLDB","TEST" , "1234567897", "testroad 4","a@b.com" );
        AddDb.callDb(DBValidator.getCon(), contact);
        SearchPageDb.getInstance().callDb(DBValidator.getCon(), "TESTCALLDB", 1, 12334);
        ResultSet resultSet =SearchPageDb.getInstance().getResultSet();
        try {
            assertEquals(resultSet.getInt("id"), -54321);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
