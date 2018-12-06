package databaseHandling;

import ContactHandling.Contact;
import java.sql.*;

public abstract class AddDb {


    public boolean callDb(Connection connection,Contact contact) {

        Statement stm = null;

        int rowCount;

        String SQL = "INSERT INTO contacts(Id, firstName, lastName, phone, address, email) VALUES('" +
                contact.getId() + "', '" + contact.getFirstName() + "', '" + contact.getLastName() + "', '" + contact.getPhone()  + "', '" +
                contact.getAddress() + "', '" + contact.getEmail() + "')";

        System.out.println(SQL);        // TODO Check of SQL statement, shall eventually be deleted.


        if (connection != null) {

            try {
                stm = connection.createStatement();

                rowCount = stm.executeUpdate(SQL);

                stm.close();                // TODO Is this correct? What about 'finally' below?
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }



            /*finally {

            }*/


        }

        return true;                // TODO Check how the return statement shall be written. rowCount

    }

}
