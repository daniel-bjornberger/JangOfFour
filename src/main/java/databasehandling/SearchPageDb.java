package databasehandling;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**Singleton class to search database.
 * @author Pontus Fredriksson.
 */
public class SearchPageDb {

    /** Singleton instance  */
    private static SearchPageDb searchPageDbInstance = new SearchPageDb();


    /**Stores the connection to the database */
    private Connection connection;

    /**Stores the latest searchString. */
    private String searchString = "";

    /**Stores the latest searchString. */
    private int pageNumber = 1;

    /**Stores latest prefered hits per page.*/
    private int hitsPerpage;

    /**Stored latest amount of rows returned from the database. */
    private int hitAmount;


    /**Store the latest result returned from the database.    */
    private ResultSet resultSet;

    /**Returns latest resultset */
    public ResultSet getResultSet(){
        return resultSet;
    }
    //*Makes sure class is Singleton*/
    private SearchPageDb(){}

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
     * @return True if all went well
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
                stm = connection.createStatement();
                resultSet = stm.executeQuery(query);




                hitAmount = 0;
                while (resultSet.next()) {
                    hitAmount ++;
                }

            } catch (SQLException sqle) {
                System.err.println(sqle.getMessage());
            }
        }

        return callDb();
    }


    /**Calls database with info from the last search.
     * saves result in 'resultSet' field.
     * @return True if all went well.
     */
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
                        "ORDER BY firstname COLLATE NOCASE " +
                        "LIMIT " + hitsPerpage + " " +
                        "OFFSET " + ((pageNumber-1)*hitsPerpage) +
                        ";";

                stm = connection.createStatement();
                resultSet = stm.executeQuery(query);
                return true;
            } catch (SQLException sqle) {
                System.err.println(sqle.getMessage());
                return false;
            }
        }
     return false;
    }
}
