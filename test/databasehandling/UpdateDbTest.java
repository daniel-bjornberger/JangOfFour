package databasehandling;

import contacthandling.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdateDbTest {

    @Test
    void callDb() {
        DBValidator dbValidator = new DBValidator();
        assertTrue(UpdateDb.callDb(DBValidator.getCon(),new Contact(1,"Joel","Gunnarsson","070","Ring","joel@se")));
    }
}