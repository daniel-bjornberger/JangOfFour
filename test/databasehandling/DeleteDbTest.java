package databasehandling;

import contacthandling.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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