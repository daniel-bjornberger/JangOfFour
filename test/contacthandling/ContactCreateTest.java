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
            new Contact(65657615, "Bob", "Lotfabadi","0736262671", "Address1","bobfripostorg");
        } catch (Exception e) {
            fail ("Exception was expected for mejl address...");
            System.err.println("Exception: " + e);
        }
    }

    @Test
    public void makeSureContactFirstNameIsNotEmpty() {
        try {
            new Contact(76543847, "Joel", "Gunnarson","0736262671", "Address1","bob@fripost.org");
        } catch (Exception e) {
            fail("Exception was expected for empty first name");
            System.err.println("Exception: " + e);
        }
    }

    @Test
    void makeSureContactLastNameNotNull() {
        try {
            new Contact(9189865, "Bob", "Lotfabadi","0736262671", "Address1","bob@fripost.org");
        } catch (Exception e) {
            fail("Exception was expected for empty last name");
            System.err.println("Exception: " + e);
        }
    }

    @Test
    void seeThatPhoneNumberIsInCorrectFormat() {
        try {
            new Contact(6790786, "Bob", "Lotfabadi","07123456712", "Address1","bob@fripost.org");
        } catch (Exception e) {
            fail("Exception was expected for short phone numbers");
            System.err.println("Exception: " + e);
        }
    }


}