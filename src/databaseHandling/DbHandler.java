package databaseHandling;

import ContactHandling.Contact;

import java.nio.channels.IllegalChannelGroupException;
import java.sql.*;

public class DbHandler {
    private DbHandler DbHandlerInstance =new DbHandler();
    String searchString;
    int pagenumber = 1;
    int pageAmount;
    int hitsPerpage;
    int hitAmount;

    private DbHandler(){}

    public DbHandler getInstance(){
        return DbHandlerInstance;
        }


    public void add(Connection connection, Contact contact)throws Exception{
        if (AddDb.callDb(connection, contact)==true){
            SearchPageDb.getInstance().callDb();
        } else {
            throw new Exception("Couldn't add Contact in database");
        }
    }
    public void delete(Connection connection,Contact contact)throws Exception{
        if (DeleteDb.callDb(connection, contact)==true){
            SearchPageDb.getInstance().callDb();
        }else {
            throw new Exception("Couldn't delete Contact in database");
        }
    }
    public void update(Connection connection,Contact contact)throws Exception{

        if (UpdateDb.callDb(connection, contact)==true){
            SearchPageDb.getInstance().callDb();
        }else {
            throw new Exception("Couldn't update Contact in database.");
        }
    }

    public void searchPage(Connection connection,Contact contact)throws Exception{
        pagenumber=1;
        if (SearchPageDb.getInstance().callDb(connection, searchString, pagenumber, hitsPerpage)==true){
            contactHandler.getInstance.createFromString(SearchPageDb.getInstance.Result);
            hitAmount = SearchPageDb.getInstance().getHitAmount();
        }else {
            throw new Exception("Couldn't search Contacts.");
        }
    }

    public void nextPage(Connection connection, Contact contact) throws Exception{
        pagenumber++;
        if (SearchPageDb.getInstance().callDb(connection, searchString, pagenumber, hitsPerpage)==true){
            contactHandler.getInstance.createFromString(SearchPageDb.getInstance.Result);
        }else {
            throw new Exception("Couldn't search Contacts.");
        }
    }
    public void previousPage(Connection connection, Contact contact) throws Exception{
        pagenumber--;
        if (SearchPageDb.getInstance().callDb(connection, searchString, pagenumber, hitsPerpage)==true){
            contactHandler.getInstance.createFromString(SearchPageDb.getInstance.Result);
        }else {
            throw new Exception("Couldn't search Contacts.");
        }
    }

}