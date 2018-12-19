package contacthandling;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import java.sql.ResultSet;

/** ContactHandler class to work with and return the given list of contacts
 * @author Bob
 */
public class ContactHandler implements Observable {
    private ArrayList<InvalidationListener> invalidationlisteners = new ArrayList<>();
    private List <Contact> contactList = new ArrayList<>();
    private static ContactHandler ContactHandlerInstance = new ContactHandler();
    private ContactHandler() {}

    /** return the singleton instance of the class*/
    public static ContactHandler getInstance() {
        return ContactHandlerInstance;
    }

    /**
     * @param rs The passed ResultSet object from the processed SQL Query
     * @return contactList -- the prepared contact list from the given ResultSet rs
     */
    public List<Contact> createFromString (ResultSet rs) throws SQLException {
        //System.out.println("now create and return contactList...");
        ResultSet myResultSet= rs;
        //System.out.println("current contactsList is: " + contactList);
        //remove all contacts from Contact List first
        contactList.clear();
        while (rs.next()) {
            contactList.add(new Contact(
                    rs.getInt("id"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getString("email")
            ));
            //System.out.println("update the new contactList with one contact...");
            ;
        }
        //System.out.println("check if contactList is ready...");
        //displayAllContacts();
        notifyListeners();
        return (contactList);
    }


    /** display all contacts currently in contactList */
    public void displayAllContacts () {
        //System.out.println("Display all contacts:");
        int count = 0;
        for (Contact contact: contactList) {
            //System.out.println("Contact " + count + ": " + contact);
            count++;
        }
    }


    /** given a contact detail, add to contactList */
    public void add (Contact givenContact) {
        //add a given contact detail to contactList
        contactList.add(givenContact);
    }

    /** given a contact detail, remove from contactList */
    public void remove (contacthandling.Contact givenContact) {
        //remove a contact given contact
        contactList.remove(givenContact);
    }

    /** given contactList, clear the list */
    public void clear (List<Contact> givenContactList) {
        givenContactList.clear();
        notifyListeners();
        //System.out.println("Cleared contact list");
    }


    public void notifyListeners(){
        invalidationlisteners.forEach( (i) -> i.invalidated(this));

    }

    @Override
    public void addListener(InvalidationListener listener) { this.invalidationlisteners.add(listener); }

    public List<Contact> getContactList() {
        return contactList;
    }

    @Override
    public void removeListener(InvalidationListener listener) { this.invalidationlisteners.remove(listener); }

}
