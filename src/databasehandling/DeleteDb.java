package databasehandling;

import contacthandling.Contact;
import java.sql.*;

public abstract class DeleteDb {
    /**
    Given the database connection and a given contact detail object,
    delete this contact from table.
    Base the deletion on the contact's Id.
    @author Joel
    */
    public static boolean callDb(Connection connection,Contact contact) {

        int rowCount = -1;

        String SQL = "DELETE FROM contacts WHERE id = " + contact.getId() + ";";

        System.out.println(SQL);        // TODO Check of SQL statement, shall eventually be deleted.

        if (connection != null) {

            try {
                Statement stm = connection.createStatement();

                rowCount = stm.executeUpdate(SQL);

                stm.close();                // TODO Is this correct? What about 'finally' below?
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }



            /*finally {

            }*/


        }

        return rowCount == 1;                // TODO Check how the return statement shall be written. Is rowCount used correctly?

    }

}
