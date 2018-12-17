package contacthandling;

/**
 * @author Bob.
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactCreateTest {

    @Test
    public void createAContactWithCommonValuesForAContact() {
        try {
            new Contact(999, "Bob", "L.","0736262671", "Address1","bobfripostorg");
            fail ("Exception was expected for mejl address...");
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
    }

    @Test
    public void makeSureContactFirstNameIsNotEmpty() {
        try {
            new Contact(999, "", "L.","0736262671", "Address1","bob@fripost.org");
            fail("Exception was expected for empty first name");
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
    }

    @Test
    void makeSureContactLastNameNotNull() {
        try {
            new Contact(999, "Bob", "","0736262671", "Address1","bob@fripost.org");
            fail("Exception was expected for empty last name");
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
    }

    @Test
    void seeThatPhoneNumberIsInCorrectFormat() {
        try {
            new Contact(999, "Bob", "","071", "Address1","bob@fripost.org");
            fail("Exception was expected for short phone numbers");
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
    }


}