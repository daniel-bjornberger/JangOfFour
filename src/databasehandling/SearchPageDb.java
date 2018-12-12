package databasehandling;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**Singleton class to search database.
 * @author Pontus Fredriksson.
 */
public class SearchPageDb {
    private static SearchPageDb searchPageDbInstance = new SearchPageDb();
    private Connection connection;
    private String searchString;
    private int pageNumber = 1;
    private int hitsPerpage;
    private int hitAmount;
    private ResultSet resultSet;

    /**Returns latest resultset */
    public ResultSet getResultSet(){
        return resultSet;
    }
    //*Makes sure class is Singleton*/
    private SearchPageDb(){}
    public int getHitAmount(){
        return hitAmount;
    }

    /**
     * @return the singleton instance of the class.
     */
    public static SearchPageDb getInstance(){
        return searchPageDbInstance;
    }

    //ctrl +shift + A fix doc comment
    /** Searches the databases for all rows LIKE searchString. Use when doing a new search.
     * Saves inparameters in searchPageDbInstance.
     * calls callDB().
     * @param connection The connection to the database.
     * @param searchString the string the database will try to match.
     * @param pageNumber refered pagenumber to return, set to '1' if not relevant.
     * @param hitsPerpage How many rows the UI shows.
     * @return A java.sql.ResultSet.
     */
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
