package databasehandling;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class KeyGenerator {
    public static int callDB(Connection connection){

        if (connection != null) {

            Statement stm = null;
            ResultSet resultSet = null;
            try {
                String query = "SELECT * FROM contacts " +
                        "ORDER BY id desc " +
                        "LIMIT 1;";
                System.out.println(query); // Säkra att du skrivit rätt, tas bort senare.
                stm = connection.createStatement();
                resultSet = stm.executeQuery(query);
                int resultInt = resultSet.getInt("id");

                return (resultInt+1);

            } catch (SQLException sqle) {
                System.err.println(sqle.getMessage());
            }



        }
        return -1;
    }
}
