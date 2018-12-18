package databasehandling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**Test if when create an instance of DbValidator a connection is created. Test if method hasConnection return true when instance of DBvalidator is created.
 * @author Joel Gunnarsson
 */
class DBValidatorTest {

    @Test
    void getCon() {

        assertTrue(DBValidator.getCon()!=null);
    }

    @Test
    void hasConnection() {
        DBValidator dbValidator=new DBValidator();
        assertTrue(dbValidator.hasConnection());
    }
}