package databaseHandling;
import ContactHandling.*;

import java.nio.channels.IllegalChannelGroupException;
import java.sql.*;

public class DbHandler {
    private static DbHandler DbHandlerInstance =new DbHandler();
    private String searchString;
    private int pagenumber = 1;
    private int pageAmount;
    private int hitsPerpage = 15; //declare as private in SearchPageDb, set it according to this.
    private int hitAmount;

    private DbHandler(){}

    public int getPageAmount(){
        if (hitsPerpage%hitsPerpage <0){
        return (hitAmount/hitsPerpage +1);
        }else{
            return hitAmount/hitsPerpage;
        }
    }

    public static DbHandler getInstance(){
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

    public void searchPage(String searchString)throws Exception{
        this.searchString = searchString;
        pagenumber=1;
        System.out.println("here");
        if (SearchPageDb.getInstance().callDb(DBValidator.getCon(), searchString, pagenumber, hitsPerpage)==true){
            //is sending empty resultset:
            ContactHandler.getInstance().createFromString(SearchPageDb.getInstance().getResultSet());
            //hitAmount = SearchPageDb.getInstance().getHitAmount();

            System.out.println("DbHandler.searchpage ran.");
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