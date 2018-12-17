package databasehandling;

import contacthandling.Contact;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pontus Fredriksson
 */
class DbHandlerTest {

    /**Makes a backup of the database
     * @throws IOException
     */
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


    /**
     * Deletes the database and changes name of the backup to originial name 'Database1'
     */
    @AfterEach
    void tearDown() {
        File file = new File("Database1");
        File fileBackup = new File("DatabaseBackup");
        if(file.delete()) {
            File file1 = new File("database1");
            System.out.println("HEJ");
            fileBackup.renameTo(file);
        }


    }

    @Test
    void getPageAmount() {
    }

    @Test
    void getInstance() {
        assertEquals(DbHandler.class, DbHandler.getInstance().getClass());
    }

    @Test
    void AssertDBHandlerAddThrowsExceptionWhenFailing() {
        String response= "";
        Contact contact=new Contact(-1, "TEST9999",
                "TEST", "TEST", "TEST", "TEST");
        try {
            DbHandler.getInstance().add(contact);
        } catch (Exception e) {
            response = e.getMessage();
        }
        assertEquals("Couldn't add Contact in database", response );
    }
    @Test
    void AssertDBHandlerDeleteThrowsExceptionWhenFailing() {
        String response= "";
        Contact contact=new Contact(-1, "TEST9999",
                "TEST", "TEST", "TEST", "TEST");
        try {
            DbHandler.getInstance().delete(contact);
        } catch (Exception e) {
            response = e.getMessage();
        }
        assertEquals("Couldn't delete Contact in database", response );
    }

    @Test
    void AssertDBHandlerUpdateThrowsExceptionWhenFailing() {
        String response= "";
        Contact contact=new Contact(-1,"TEST9999",
                "TEST", "TEST", "TEST", "TEST");
        try {
            DbHandler.getInstance().delete(contact);
        } catch (Exception e) {
            response = e.getMessage();
        }
        assertEquals("Couldn't delete Contact in database", response );
    }

    @Test
    void searchPage() {
    }

    @Test
    void nextPage() {
    }

    @Test
    void previousPage() {
    }

    @Test
    void generateID() {
    }

    @Test
    void getSearchString() {
    }
}