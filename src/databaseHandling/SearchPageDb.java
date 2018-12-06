package databaseHandling;

import ContactHandling.Contact;
import com.sun.corba.se.impl.encoding.CodeSetComponentInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchPageDb {
    private static SearchPageDb searchPageDbInstance = new SearchPageDb();
    private Connection connection;
    private String searchString;
    private int pageNumber;
    private int hitsPerpage;
    private int hitAmount;

    private SearchPageDb(){}
    public int getHitAmount(){
        return hitAmount;
    }

    public static SearchPageDb getInstance(){
        return searchPageDbInstance;
    }

    public boolean callDb(Connection connection,
                          String searchString,
                          int pageNumber,
                          int hitsPerpage){


        this.connection=connection;
        this.searchString=searchString;
        this.pageNumber=pageNumber;
        this.hitsPerpage=hitsPerpage;int rows = -1;
        if (connection != null) {
            Statement stm = null;
            ResultSet resultSet = null;
            try {
                String query = "SELECT * FROM contacts WHERE " +
                        "firstname LIKE '"+ searchString +"%'"+
                        ",surname LIKE '"+ searchString +"%'"+
                        ",phone LIKE '"+ searchString +"%'"+
                        ",adress LIKE '"+ searchString +"%'"+
                        ",email LIKE '"+ searchString +"%'"+
                        " WHERE LIKE '"+ searchString +"%'"+
                        ";";
                System.out.println(query); // Säkra att du skrivit rätt, tas bort senare.
                stm = connection.createStatement();
                resultSet = stm.executeQuery(query);
                //TODO: KOLLA OM DENNA FUNGERAR
                hitAmount = resultSet.getFetchSize();

            } catch (SQLException sqle) {
                System.err.println(sqle.getMessage());
            }
        }
        return callDb();
    }


    public boolean callDb() {
        int rows = -1;
        if (connection != null) {
            Statement stm = null;
            ResultSet resultSet = null;
            try {
                String query = "SELECT * FROM contacts WHERE " +
                        "firstname LIKE '"+ searchString +"%'"+
                        ",surname LIKE '"+ searchString +"%'"+
                        ",phone LIKE '"+ searchString +"%'"+
                        ",adress LIKE '"+ searchString +"%'"+
                        ",email LIKE '"+ searchString +"%'"+
                        " WHERE LIKE '"+ searchString +"%'"+
                        "ORDER BY firstname" +
                        "OFFSET " + ((pageNumber-1)*hitsPerpage) + " ROWS" +
                        "LIMIT " + hitsPerpage +
                        ";";
                System.out.println(query); // Säkra att du skrivit rätt, tas bort senare.
                stm = connection.createStatement();
                resultSet = stm.executeQuery(query);


            } catch (SQLException sqle) {
                System.err.println(sqle.getMessage());
            } finally {


            }

        }

        if (rows < 0) {
            return false;
        } else {
            return true;
        }
    }
}
