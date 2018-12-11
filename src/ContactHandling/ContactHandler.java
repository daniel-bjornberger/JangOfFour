package ContactHandling;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import java.sql.ResultSet;

public class ContactHandler implements Observable {
    private ArrayList<InvalidationListener> invalidationlisteners = new ArrayList<>();
    private List<Contact> contactList = new ArrayList<>();
    private static ContactHandler ContactHandlerInstance = new ContactHandler();
    private ContactHandler() {}

    public static ContactHandler getInstance() {
        return ContactHandlerInstance;
    }

    public List<Contact> createFromString (ResultSet rs) throws SQLException {
        System.out.println("createFromString...");
        ResultSet myResultSet= rs;
        //given: SearchPageDb.getInstance.Result
        //create one or more contact from that
        System.out.println("see current contactsList. It is: " +
                contactList);

        //remove all contacts from Contact List first
        contactList.clear();

        System.out.println("Work with ResultSet: " + rs);
        System.out.println("is there an rs.next()? " + rs.next());

        while (rs.next()) {
            System.out.println("going through each row...");
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

        System.out.println("check if contactList is ready...");
        //System.out.println("now it is: " + contactList);
        displayAllContacts();
        notifyListeners();
        return (contactList);
    }
    /**
     * display all contacts currently in contactList
     */
    public void displayAllContacts () {
        int count = 0;
        for (Contact contact: contactList) {
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
        notifyListeners();
        System.out.println("Cleared contact list");
    }

    // TODO
    public void notifyListeners(){
        invalidationlisteners.forEach( (i) -> i.invalidated(this));

    }

    @Override
    public void addListener(InvalidationListener listener) { this.invalidationlisteners.add(listener); }

    @Override
    public void removeListener(InvalidationListener listener) { this.invalidationlisteners.remove(listener); }

}
