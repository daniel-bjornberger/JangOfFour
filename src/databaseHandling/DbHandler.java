package databaseHandling;
import ContactHandling.*;

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


    public void add(Contact contact)throws Exception{
        if (AddDb.callDb(DBValidator.getCon(), contact)==true){
            SearchPageDb.getInstance().callDb();
        } else {
            throw new Exception("Couldn't add Contact in database");
        }
    }
    public void delete(Contact contact)throws Exception{
        if (DeleteDb.callDb(DBValidator.getCon(), contact)==true){
            SearchPageDb.getInstance().callDb();
        }else {
            throw new Exception("Couldn't delete Contact in database");
        }
    }
    public void update(Contact contact)throws Exception{

        if (UpdateDb.callDb(DBValidator.getCon(), contact)==true){
            SearchPageDb.getInstance().callDb();
        }else {
            throw new Exception("Couldn't update Contact in database.");
        }
    }

    public void searchPage(Contact contact)throws Exception{
        pagenumber=1;
        if (SearchPageDb.getInstance().callDb(DBValidator.getCon(), searchString, pagenumber, hitsPerpage)==true){
            ContactHandler.getInstance().createFromString(SearchPageDb.getInstance().getResultSet());
            hitAmount = SearchPageDb.getInstance().getHitAmount();
        }else {
            throw new Exception("Couldn't search Contacts.");
        }
    }

    public void nextPage(Contact contact) throws Exception{
        pagenumber++;
        if (SearchPageDb.getInstance().callDb(DBValidator.getCon(), searchString, pagenumber, hitsPerpage)==true){
            ContactHandler.getInstance().createFromString(SearchPageDb.getInstance().getResultSet());
        }else {
            throw new Exception("Couldn't search Contacts.");
        }
    }
    public void previousPage(Contact contact) throws Exception{
        pagenumber--;
        if (SearchPageDb.getInstance().callDb(DBValidator.getCon(), searchString, pagenumber, hitsPerpage)==true){
            ContactHandler.getInstance().createFromString(SearchPageDb.getInstance().getResultSet());
        }else {
            throw new Exception("Couldn't search Contacts.");
        }
    }

}