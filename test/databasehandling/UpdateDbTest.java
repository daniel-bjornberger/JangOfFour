package databasehandling;

import contacthandling.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** Test, First create and add a new contact to database, then try to update contact with a new name.
 * @author Joel Gunnarsson
 */
class UpdateDbTest {

    @Test
    void callDb() {
        DBValidator dbValidator = new DBValidator();
        Contact contact= null;
        try {
            contact = new Contact(DbHandler.getInstance().generateID(),"Joel","Gunnarsson","070","Ring","joel@se");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
        AddDb.callDb(DBValidator.getCon(),contact);
        contact.setFirstname("JoelG");
        assertTrue(UpdateDb.callDb(DBValidator.getCon(),contact));



    }
}