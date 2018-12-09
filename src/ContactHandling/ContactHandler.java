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

    public String createFromString (ResultSet rs) throws SQLException {
        System.out.println("createFromString...");
        //given: SearchPageDb.getInstance.Result
        //create one or more contact from that
        while (rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));



            ;
        }

        System.out.println("Working with: " +
                rs);
        notifyListeners();
        return ("the created contact");
    }

    public void add (Contact givenContact) {
        //add a given contact detail to contactList
        //has an error , fix:
        contactList.add(givenContact);
    }

    public void clear (ContactHandling.Contact givenContact) {
        //remove a contact given contact

        //something like:
        // contactList.remove(givenContact);
    }

    // TODO
    public void notifyListeners(){

    }

}
