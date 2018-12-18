package databasehandling;

import contacthandling.Contact;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddDbTest {

    @AfterAll
    static void breakdown(){
        DBValidator.closeConnection();
    }

    @Test
    void callDbAddContact() throws Exception {
        DBValidator dbValidator=new DBValidator();
        assertTrue(AddDb.callDb(DBValidator.getCon(),new Contact(DbHandler.getInstance().generateID(),"Joel","Gunnarsson","098","Ringvägen","joel@hotmail.com")));
    }

}