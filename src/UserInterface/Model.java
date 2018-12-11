package UserInterface;

import ContactHandling.ContactHandler;
import databaseHandling.DbHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

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
