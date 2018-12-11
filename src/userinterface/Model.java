package userinterface;

import contacthandling.ContactHandler;
import databasehandling.DbHandler;

public class Model {

 private DbHandler dbHandler=DbHandler.getInstance();

    private ContactHandler contactHandler=ContactHandler.getInstance();

 public DbHandler getDbHandler() {
        return dbHandler;
    }

    public ContactHandler getContactHandler() {
        return contactHandler;
    }
}
