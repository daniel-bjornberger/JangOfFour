package databasehandling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBValidatorTest {

    @Test
    void getCon() {
        DBValidator dbValidator=new DBValidator();
        assertTrue(DBValidator.getCon()!=null);
    }

    @Test
    void hasConnection() {
        DBValidator dbValidator=new DBValidator();
        assertTrue(dbValidator.hasConnection());
    }
}