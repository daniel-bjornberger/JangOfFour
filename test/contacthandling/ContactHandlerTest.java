package contacthandling;

/**
 * @author Bob.
 */

import databasehandling.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

public class ContactHandlerTest {

    //BeforeEach method written by Pontus
    @BeforeEach
    void setUp() throws IOException {
        //DBValidator dbValidator = new DBValidator();
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream("Database1");
            os = new FileOutputStream("DatabaseBackup");
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    //AfterEach method written by Pontus
    @AfterEach
    void tearDown() {
        File file = new File("Database1");
        File fileBackup = new File("DatabaseBackup");
        DBValidator.closeConnection();
        if (file.delete()) {
            File file1 = new File("Database1");
            System.out.println("HEJ");
            fileBackup.renameTo(file1);
        }else {System.err.println("Couldnt delete file");}
    }

    @Test
    public void addAContactAndDisplayTheContactList() throws Exception {
        Contact contact1 = new Contact(999,"Bob", "Lotfabadi",
                "12345", "Södra Klöverstigen 33", "bob@.se");

        ContactHandler contacList1 = ContactHandler.getInstance();
        contacList1.add(contact1);
        contacList1.displayAllContacts();

       //dbHandler.update(contact1) throws Exception {
       //    System.err.println("Exception occured.");
        //}
        //dbHandler.searchPage("Joel");
    }


    @Test
    public void createAContactListFromAResultSetObjectThatIsCreatedByTheDbHandlerCall () {
        ContactHandler contactHandler = ContactHandler.getInstance();

        System.out.println("make the contact list...");

        DBValidator dbValidator = new DBValidator();
        DbHandler dbHandler=DbHandler.getInstance();
        System.out.println("receive all contacts from the database...");
        try {

            DbHandler.getInstance().searchPage("");
            System.out.println("call createFromString...");

            //this will return empty contact list:
            contactHandler.createFromString(SearchPageDb.getInstance().getResultSet());
            //this will return all contacts in contact list:
            DbHandler.getInstance().searchPage("");
            System.out.println("Display all contacts...");
            contactHandler.displayAllContacts();

            //run a createFromString
            //contactHandler.getInstance().createFromString(SearchPageDb.getInstance().getResultSet());

        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
        contactHandler.displayAllContacts();

    }


    @Test
    public void AddToTheContactListViaAddingToDatabaseAndReturnContactList() throws Exception {
        ContactHandler contactHandler = ContactHandler.getInstance();
        DBValidator dbValidator = new DBValidator();
        //DbHandler dbHandler=DbHandler.getInstance();

        System.out.println("first, make a contact...");
        Contact contact1 = new Contact(DbHandler.getInstance().generateID(),"Bob", "Lotfabadi",
                "12345", "Södra Klöverstigen 33", "bob@.se");

        System.out.println("add a contact to database...");
        try {
            //contactHandler.add(contact1); //do not test this but test adding via DbHandler.
            DbHandler.getInstance().add(contact1);
            contactHandler.createFromString(SearchPageDb.getInstance().getResultSet());
            //error: logical error below because it not show all contacts even though contact added!
            contactHandler.displayAllContacts();

        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
    }



    @Test
    public void ReturnExistingContactsInDatabase() {
        //This test has error. displayAllContacts should show all contacts
        DbHandler dbHandler=DbHandler.getInstance();
        ContactHandler contactHandler = ContactHandler.getInstance();
        try {
            dbHandler.searchPage("t");
            contactHandler.displayAllContacts();
        }    catch (Exception e) {
            System.out.println("Exception at test: " + e);
        }
    }


}
