package contacthandling;

/**
 * @author Bob.
 * run tests where you make a contact or you check for contact info entry in right format
 */

import databasehandling.DbHandler;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ContactCreateTest {

    @Test
    public void createAContactWithCommonValuesForAContact() {
        try {
            new Contact(DbHandler.getInstance().generateID(), "Bob", "L.","0736262671", "Address1","bobfripostorg");
            fail ("Exception was expected for mejl address...");
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
    }

    @Test
    public void makeSureContactFirstNameIsNotEmpty() {
        try {
            new Contact(DbHandler.getInstance().generateID(), "", "L.","0736262671", "Address1","bob@fripost.org");
            fail("Exception was expected for empty first name");
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
    }

    @Test
    void makeSureContactLastNameNotNull() {
        try {
            new Contact(DbHandler.getInstance().generateID(), "Bob", "","0736262671", "Address1","bob@fripost.org");
            fail("Exception was expected for empty last name");
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
    }

    @Test
    void seeThatPhoneNumberIsInCorrectFormat() {
        try {
            new Contact(DbHandler.getInstance().generateID(), "Bob", "","071", "Address1","bob@fripost.org");
            fail("Exception was expected for short phone numbers");
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
    }


}