package userinterface;

import contacthandling.Contact;
import contacthandling.ContactHandler;
import databasehandling.DbHandler;

public class Model {

 private DbHandler dbHandler=DbHandler.getInstance();
 private ContactHandler contactHandler=ContactHandler.getInstance();
 private Contact selectedContact;

    public void setSelectedContact(Contact selectedContact) {
        this.selectedContact = selectedContact;
    }

    public Contact getSelectedContact(){
        return selectedContact;
    }

    public DbHandler getDbHandler() {
        return dbHandler;
    }

    public ContactHandler getContactHandler() {
        return contactHandler;
    }
}
