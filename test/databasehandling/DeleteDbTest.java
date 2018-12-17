package databasehandling;

import contacthandling.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**Test for Delete a contact in database. First a Contact is created and add it to the Database, then we delete the contact.To be sure the contact is deleted we try to add the same contact again to the database, if contact is not deleted it's not possible to add a contact with the same Primary key.
 * @author Joel Gunnarsson
 */
class DeleteDbTest {

    @Test
    void callDb() {
        DBValidator dbValidator=new DBValidator();
        Contact contact=new Contact(1000,"Joel","Gunnarsson","098098098","Ringvägen","joel@hotmail.com");
        AddDb.callDb(DBValidator.getCon(),contact);
        assertTrue(DeleteDb.callDb(DBValidator.getCon(),contact));
        assertTrue(AddDb.callDb(DBValidator.getCon(),contact));

    }
}