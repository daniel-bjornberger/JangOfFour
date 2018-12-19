package databasehandling;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

/**create an integer to be used as an Id
 based on the contact table's largest Id found in table
 using an SQL query. Return either this integer or
 if table is empty, then reutrn integer "1" to be used.
 @author Joel
 */
public abstract class KeyGenerator {

    public static int callDB(Connection connection){

        if (connection != null) {

            Statement stm = null;
            ResultSet resultSet = null;
            try {
                String query = "SELECT * FROM contacts " +
                        "ORDER BY id desc " +
                        "LIMIT 1;";
                stm = connection.createStatement();
                resultSet = stm.executeQuery(query);
                if (resultSet.next()){
                    int resultInt = resultSet.getInt("id");
                    return (resultInt+1);
                }
                return (1);

            } catch (SQLException sqle) {
                System.err.println(sqle.getMessage());
            }



        }
        return -1;
    }
}
