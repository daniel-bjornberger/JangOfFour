package databasehandling;

import contacthandling.Contact;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/** Test class for the AddDb class.
 * @author Daniel Björnberger
 */
class AddDbTest {

    /** After all tests have been performed, the connection to the database is closed.
     */
    @AfterAll
    static void breakdown(){
        DBValidator.closeConnection();
    }


    /** Tests if a new contact can be added to the database. Afterwards, the contact is deleted from the database.
     */
    @Test
    void testCallDbAddContactSuccess() {

        DBValidator dbValidator = new DBValidator();

        Contact newContact = new Contact(-845, "Joel","Gunnarsson","09888888888","Ringvägen","joel@hotmail.com");

        assertTrue(AddDb.callDb(DBValidator.getCon(), newContact));

        DeleteDb.callDb(DBValidator.getCon(), newContact);

    }


    /** Tests that it isn't possible to add the same contact twice. Afterwards, the contact is deleted from the database.
     */
    @Test
    void testCallDbAddContactFail() {

        Contact newContact = new Contact(-845, "Joel","Gunnarsson","09888888888","Ringvägen","joel@hotmail.com");

        AddDb.callDb(DBValidator.getCon(), newContact);

        assertFalse(AddDb.callDb(DBValidator.getCon(), newContact));

        DeleteDb.callDb(DBValidator.getCon(), newContact);

    }


}