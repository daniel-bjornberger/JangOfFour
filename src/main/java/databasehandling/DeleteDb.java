package databasehandling;

import contacthandling.Contact;
import java.sql.*;

public abstract class DeleteDb {
    /**
    Given the database connection and a given contact detail object,
    delete this contact from table.
    Base the deletion on the contact's Id.
    @author Joel Gunnarsson
    */
    public static boolean callDb(Connection connection,Contact contact) {

        int rowCount = -1;

        String SQL = "DELETE FROM contacts WHERE id = " + contact.getId() + ";";

        if (connection != null) {

            try {
                Statement stm = connection.createStatement();

                rowCount = stm.executeUpdate(SQL);

                stm.close();
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }

        }

        return rowCount == 1;

    }

}
