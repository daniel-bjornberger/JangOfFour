package databasehandling;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchPageDb {
    private static SearchPageDb searchPageDbInstance = new SearchPageDb();
    private Connection connection;
    private String searchString;
    private int pageNumber = 1;
    private int hitsPerpage;
    private int hitAmount;
    private ResultSet resultSet;

    public ResultSet getResultSet(){
        return resultSet;
    }

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
            resultSet = null;
            try {
                String query = "SELECT * FROM contacts WHERE " +
                        "firstname LIKE '%"+ searchString +"%'"+
                        " OR lastname LIKE '%"+ searchString +"%'"+
                        " OR phone LIKE '%"+ searchString +"%'"+
                        " OR address LIKE '%"+ searchString +"%'"+
                        " OR email LIKE '%"+ searchString +"%'"+
                        ";";
                System.out.println(query); // Säkra att du skrivit rätt, tas bort senare.
                stm = connection.createStatement();
                resultSet = stm.executeQuery(query);

                System.out.println("- now in callDb(Connection connection,\n" +
                        "                          String searchString,\n" +
                        "                          int pageNumber,\n" +
                        "                          int hitsPerpage).\n\n" +
                        " resultSet: " + resultSet);


                //TODO: KOLLA OM DENNA FUNGERAR
                hitAmount = 0;
                while (resultSet.next()) {
                    System.out.println("- row id: " + resultSet.getInt("id"));
                    hitAmount ++;
                }
                System.out.println("# of hits: " + hitAmount);

            } catch (SQLException sqle) {
                System.err.println(sqle.getMessage());
            }
        }

        return callDb();
    }


    public boolean callDb()  {
        int rows = -1;
        if (connection != null) {
            Statement stm = null;
            resultSet = null;
            try {
                String query = "SELECT * FROM contacts WHERE " +
                        "firstname LIKE '%"+ searchString +"%' OR "+
                        "lastname LIKE '%"+ searchString +"%' OR "+
                        "phone LIKE '%"+ searchString +"%' OR "+
                        "address LIKE '%"+ searchString +"%' OR "+
                        "email LIKE '%"+ searchString +"%' "+
                        "ORDER BY firstname " +
                        "LIMIT " + hitsPerpage + " " +
                        "OFFSET " + ((pageNumber-1)*hitsPerpage) + //check if this formular is right
                        ";";
                System.out.println(query); // Säkra att du skrivit rätt, tas bort senare.
                stm = connection.createStatement();
                resultSet = stm.executeQuery(query);
                System.out.println("- now in callDb(). resultSet: " + resultSet);
            } catch (SQLException sqle) {
                System.err.println(sqle.getMessage());
            } finally {

            }
        }

        if (hitAmount < 0) {
            return false;
        } else {
            return true;
        }
    }
}
