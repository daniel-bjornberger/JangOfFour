package databasehandling;

import contacthandling.Contact;
import org.junit.jupiter.api.Test;

/** Test of the class KeyGenerator.
 * @author Daniel Björnberger
 */
public class KeyGeneratorTest {


    /** This test first generates a new id. Then a contact is added to the database, and a new id is generated.
     * An assert is then made to check that the new id equals the first id + 1.
     * Afterwards, the contact that was added to the database is deleted.
     * @throws Exception The method generateID may throw an Exception.
     */
    @Test
    void testKeyGenerator() throws Exception {

        int id = DbHandler.getInstance().generateID();

        Contact newContact = new Contact(id, "Daniel","Bjornberger","09888888888","Kungsgatan","daniel@hotmail.com");

        AddDb.callDb(DBValidator.getCon(), newContact);

        int newId = DbHandler.getInstance().generateID();

        assert newId == id + 1;

        DeleteDb.callDb(DBValidator.getCon(),newContact);

    }

}