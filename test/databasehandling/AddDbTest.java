package databasehandling;

import contacthandling.Contact;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AddDbTest {

    @AfterAll
    static void breakdown(){
        DBValidator.closeConnection();
    }


    @Test
    void testCallDbAddContactSuccess() throws Exception {

        DBValidator dbValidator = new DBValidator();

        Contact newContact = new Contact(DbHandler.getInstance().generateID(), "Joel","Gunnarsson","098","Ringvägen","joel@hotmail.com");

        assertTrue(AddDb.callDb(DBValidator.getCon(), newContact));



        if(DeleteDb.callDb(DBValidator.getCon(), newContact)){
            System.out.println("Delete ok!");
        }

    }


    @Test
    void testCallDbAddContactFail() throws Exception {

        Contact newContact = new Contact(DbHandler.getInstance().generateID(), "Joel","Gunnarsson","098","Ringvägen","joel@hotmail.com");

        AddDb.callDb(DBValidator.getCon(), newContact);

        assertFalse(AddDb.callDb(DBValidator.getCon(), newContact));

        DeleteDb.callDb(DBValidator.getCon(), newContact);

    }

}