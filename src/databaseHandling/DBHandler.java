package databaseHandling;

import ContactHandling.Contact;

import java.sql.*;

public class DbHandler {
    private DbHandler DbHandlerInstance =new DbHandler();
    String searchString;
    int pagenumber;
    int pageAmount;
    int hitsPerpage;
    int hitAmount;

    private DbHandler(){}

    public DbHandler getInstance(){
        return DbHandlerInstance;
        }


    public void add(Connection connection, Contact contact){
        if (AddDb.callDb(connection, contact)==true){

        }
    }
    public void delete(Connection connection,Contact contact){
        if (DeleteDb.callDb(connection, contact)==true){

        }
    }
    public void update(Connection connection,Contact contact){
        if (UpdateDb.callDb(connection, contact)==true){

        }
    }

    public void searchPage(Connection connection,Contact contact){
        if (SearchPage.callDb(/* MASSA IN HÄR!! */)==true){
            contacthandler.getInstance.createFromString(SearchPage.getInstance.Result);
        }
    }
}