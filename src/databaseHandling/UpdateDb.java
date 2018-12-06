import java.sql.*;


public class UpdateDb {

    private Connection connection;
    private Contact contact;



    public UpdateDb (Connection connection,Contact contact) {
        this.connection=connection;
        this.contact=contact;
    }

    public boolean updateContactDb() {
        dbConnection dbConnection=new dbConnection();
        int rows = -1;
        if (connection!=null) {
            Statement stm = null;

            try {
                String query = "SQLQuery";
                System.out.println(query); // Säkra att du skrivit rätt, tas bort senare.
                stm = connection.createStatement();
                rows = stm.executeUpdate(query);


            } catch (SQLException sqle) {
                System.err.println(sqle.getMessage());
            } finally {


            }

        }

        if (rows<0){
            return false;
        }
        else{
            return true;
        }
    }

