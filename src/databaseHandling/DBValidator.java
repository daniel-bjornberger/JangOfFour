package databaseHandling;
import java.sql.*;

public class DBValidator {

    private final static String dbConnection = "jdbc:sqlite:https://github.com/daniel-bjornberger/JangOfFour/blob/master/Database";
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

    public boolean hasConnection(){
        if (con != null){
            return true;
        }
        else {
            return false;
        }
    }

}
