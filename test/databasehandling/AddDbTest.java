package databasehandling;

import contacthandling.Contact;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddDbTest {



    @Test
    void callDbAddContact() {
        DBValidator dbValidator=new DBValidator();
        assertTrue(AddDb.callDb(DBValidator.getCon(),new Contact(1000,"Joel","Gunnarsson","098","Ringvägen","joel@hotmail.com")));
    }
    @Test
    void callDbAddSameContact() {
        DBValidator dbValidator=new DBValidator();
        assertFalse(AddDb.callDb(DBValidator.getCon(),new Contact(1000,"Joel","Gunnarsson","098","Ringvägen","joel@hotmail.com")));
    }
}