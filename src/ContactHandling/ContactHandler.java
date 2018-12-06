package ContactHandling;

import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;

public class ContactHandler {
    List<Contact> contactList = new ArrayList<>();
    private ContactHandler ContactHandlerInstance = new ContactHandler();
    private ContactHandler() {}

    public ContactHandler getInstance() {
        return ContactHandlerInstance;
    }

    public String createFromString (java.sql.ResultSet sqlResultSet) {
        //given: SearchPageDb.getInstance.Result
        //create one or more contact from that
        System.out.println("Working with: " +
                sqlResultSet);
        return ("the created contact");
    }

    public void add (ContactHandling.Contact givenContact) {
        //add a given contact detail to contactList
        //has an error , fix:
        contactList.add(new Contact(givenContact));
    }

    public void clear (Contact givenContact) {
        //remove a contact given contact
        //something like:
        // contactList.remove(givenContact);
    }

}
