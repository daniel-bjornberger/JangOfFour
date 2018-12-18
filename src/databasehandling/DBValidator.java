package databasehandling;
import java.nio.file.FileSystemNotFoundException;
import java.sql.*;

/** Establish a Connection to a Sqlite3 Database through Interface java.sql.Connection. When create instance method getConnection is called, 
 * @author Joel Gunnarsson
 */
public class DBValidator {

    private final static String dbConnection = "jdbc:sqlite:"+System.getProperty("user.dir")+"\\Database1";
    private static Connection con;
    static {

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Connection getCon() {
        return con;
    }

    public DBValidator() {
        getConnection();
    }

    private void getConnection() {
        try {
            con = DriverManager.getConnection(dbConnection);
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }

    public static void closeConnection(){

        if ( con!= null) {
            try {
                con.close();
                System.out.println("Connection closed");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public boolean hasConnection(){
        if (con != null){
            return true;
        }
        else {
            return false;
        }
    }

}
