package databasehandling;

import contacthandling.Contact;
import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pontus Fredriksson
 */
class DbHandlerTest {

    /**Makes a backup of the database and deletes the first instance
     * @throws IOException
     */
    @BeforeEach
     void setUp() throws IOException {


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
        File file = new File("Database1");
        if(file.delete()){
            System.out.println("DataBase1 Deleted");
        }
    }

    /**
     *Changes name of the backup to originial name 'Database1'
     */
    @AfterEach
    void tearDown() {

        File file = new File("Database1");
        File fileBackup = new File("DatabaseBackup");
        System.out.print("Change name 'DatabaseBackup to Database1: ");

           if(fileBackup.renameTo(file)) {
               System.out.println("DatabaseBackup renamed to Database1");
           }

    }

    @Test
    void getPageAmount() {
    }


    /**
     * Asserts that DbHandler.getInstance returns an object of class DbHandler.
     */
    @Test
    void getInstance() {
        assertEquals(DbHandler.class, DbHandler.getInstance().getClass());
    }

    /**
     * Asserts that DbHandler.add throws exception when something went wrong.
     */
    @Test
    void AssertDBHandlerAddThrowsExceptionWhenFailing() {
        String response= "";
        Contact contact=new Contact(-1, "TEST9999",
                "TEST", "123456789", "TESTRoad 7", "TEST@test.com");
        try {
            DbHandler.getInstance().add(contact);
        } catch (Exception e) {
            response = e.getMessage();
        }
        assertEquals("Couldn't add Contact in database", response );
    }

    /**
     * Asserts that DbHandler.delete throws exception when something went wrong.
     */
    @Test
    void AssertDBHandlerDeleteThrowsExceptionWhenFailing() {
        String response= "";
        Contact contact=new Contact(-1, "TEST9999",
                "TEST", "123456789", "TestRoad 9", "TEST@Test.com");
        try {
            DbHandler.getInstance().delete(contact);
        } catch (Exception e) {
            response = e.getMessage();
        }
        assertEquals("Couldn't delete Contact in database", response );
    }

    /**
     * Asserts that DbHandler.update throws exception when something went wrong.
     */
    @Test
    void AssertDBHandlerUpdateThrowsExceptionWhenFailing() {
        String response= "";
        Contact contact=new Contact(-1,"TEST9999",
                "TEST", "123456789", "TEST 6", "TEST@test.com");
        try {
            DbHandler.getInstance().update(contact);
        } catch (Exception e) {
            response = e.getMessage();
        }
        assertEquals("Couldn't update Contact in database.", response );
    }

    /**
     * Asserts that DbHandler.searchPage throws exception when something went wrong.
     */
    @Test
    void AssertDBHandlerSearchPageThrowsExceptionWhenFailing() {

        String response= "";
        try {
            DbHandler.getInstance().searchPage("SearchTerm");
        } catch (Exception e) {
            response = e.getMessage();
        }
        assertEquals("Couldn't search Database", response );

    }


    /**
     * @deprecated
     */
    @Test
    void nextPage() {
    }

    /**
     * @deprecated
     */
    @Test
    void previousPage() {
    }

    /**
     * Asserts that DbHandler.generateID throws exception when something went wrong.
     * also tests KeyGenerator.
     */
    @Test
    void AssertDBHandlerGenerateIDThrowsExceptionWhenFailing() {
        String response= "";
        try {
            DbHandler.getInstance().generateID();
        } catch (Exception e) {
            response = e.getMessage();
        }
        assertEquals("Couldnt Generate ID.", response );
    }

    /**
     * Asserts that DbHandler.getSearchString returns the the last inparam used in DbHandler.searchPage.
     */
    @Test
    void AssertgetSearchStringReturnsLatestSearchString() {
        String searchString = "Expected Result";
        try {
            DbHandler.getInstance().searchPage(searchString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(DbHandler.getInstance().getSearchString(), searchString);
    }
}