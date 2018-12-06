package ContactHandling;

import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;

public class ContactHandler {

    private ContactHandler ContactHandlerInstance = new ContactHandler();
    List<Contact> contactList;


    private ContactHandler() {}

    public ContactHandler getInstance() {
        return ContactHandlerInstance;
    }


    public String createFromString (java.sql.ResultSet sqlResultSet) {

    }

    //public ContactHandler () {
    //}


    //public void add (Contact givenContact) {
    //}

    //public void clear (Contact givenContact) {}
}
