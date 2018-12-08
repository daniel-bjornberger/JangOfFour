package databaseHandling;

import ContactHandling.Contact;

import java.sql.*;


public abstract class UpdateDb {



    public static boolean callDb(Connection connection,Contact contact) {
        int rows = -1;
        if (connection != null) {
            Statement stm = null;

            try {
                String query = "UPDATE contacts SET firstname='"+contact.getFirstname()+
                        "',lastname='"+contact.getLastname()+
                        "',phone='"+contact.getPhone()+
                        "',address='"+contact.getAddress()+
                        "',email='"+contact.getEmail()+
                        "' WHERE id="+contact.getId()+";";
                System.out.println(query); // Säkra att du skrivit rätt, tas bort senare.
                stm = connection.createStatement();
                rows = stm.executeUpdate(query);



            } catch (SQLException sqle) {
                System.err.println(sqle.getMessage());
            } finally {


            }

        }
        // TODO change to 1?
        if (rows < 0) {
            return false;
        } else {
            return true;
        }
    }

}