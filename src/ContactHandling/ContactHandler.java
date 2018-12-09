package ContactHandling;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import java.sql.ResultSet;

public class ContactHandler {
    List<Contact> contactList = new ArrayList<>();
    private static ContactHandler ContactHandlerInstance = new ContactHandler();
    private ContactHandler() {}

    public static ContactHandler getInstance() {
        return ContactHandlerInstance;
    }

    public List<Contact> createFromString (ResultSet rs) throws SQLException {
        System.out.println("createFromString...");
        //given: SearchPageDb.getInstance.Result
        //create one or more contact from that
        System.out.println("see current contactsList. It is: " +
                contactList);

        System.out.println("Work with: " + rs);

        //remove all contacts from Contact List first
        contactList.clear();

        while (rs.next()) {
            //System.out.println("each row");
            //System.out.println(rs.getInt(1));
            //System.out.println(rs.getString(2));
            contactList.add(new Contact(
                    rs.getInt("id"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getString("email")
            ));
            //System.out.println("- added 1 contact to contactList");
            ;
        }

        System.out.println("finish adding all contacts to contactList");
        //System.out.println("now it is: " + contactList);
        displayAllContacts(contactList);
        notifyListeners();
        return (contactList);
    }
    /**
     * display all contacts currently in contactList
     */
    public void displayAllContacts (List<Contact> givenContactList) {
        int count = 0;
        for (Contact contact: givenContactList) {
            System.out.println("Contact " + count + ": " + contact);
            count++;
        }
    }


    /** given a contact detail, add to contactList */
    public void add (Contact givenContact) {
        //add a given contact detail to contactList
        contactList.add(givenContact);
    }

    /** given a contact detail, remove from contactList */
    public void remove (ContactHandling.Contact givenContact) {
        //remove a contact given contact
        contactList.remove(givenContact);
    }

    /** given contactList, clear the list */
    public void clear (List<Contact> givenContactList) {
        givenContactList.clear();
        System.out.println("Cleared contact list");
    }

    // TODO
    public void notifyListeners(){

    }

}
