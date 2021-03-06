package databasehandling;

import contacthandling.Contact;

import java.sql.*;

/**
 * Given the database connection and a given contact detail object,
 * update the contact with new contact detail information.
 * Return true if succeeded, false otherwise
 * @author Joel Gunnarsson
 */
public abstract class UpdateDb {


    public static boolean callDb(Connection connection,Contact contact) {
        int rows = -1;
        if (connection != null) {
            Statement stm = null;

            try {
                String query = "UPDATE contacts SET firstname='"+contact.getFirstname() +
                        "',lastname='"+contact.getLastname()+
                        "',phone='"+contact.getPhone()+
                        "',address='"+contact.getAddress()+
                        "',email='"+contact.getEmail()+
                        "' WHERE id="+contact.getId()+";";

                stm = connection.createStatement();
                rows = stm.executeUpdate(query);




            } catch (SQLException sqle) {
                System.err.println(sqle.getMessage());
            } finally {


            }

        }

        if (rows <= 0) {
            return false;
        } else {
            return true;
        }
    }

}