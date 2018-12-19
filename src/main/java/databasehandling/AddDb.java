package databasehandling;

import contacthandling.Contact;
import java.sql.*;

/** An abstract class that is used by the DbHandler instance when a new contact shall be added to the database.
 * @author Daniel Björnberger
 */
public abstract class AddDb {


    /** The method callDb is used when a contact shall be added to the database.
     * @param connection The connection to the database.
     * @param contact The contact that shall be added to the database.
     * @return Returns a boolean value, true if the contact was added successfully, false if the addition of the contact failed.
     */
    public static boolean callDb(Connection connection, Contact contact) {

        int rowCount = -1;

        String SQL = "INSERT INTO contacts(id, firstname, lastname, phone, address, email) VALUES(" +
                contact.getId() + ", '" + contact.getFirstname() + "', '" + contact.getLastname() + "', '" + contact.getPhone()  + "', '" +
                contact.getAddress() + "', '" + contact.getEmail() + "');";


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
