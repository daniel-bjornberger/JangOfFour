package databasehandling;
import contacthandling.*;
import sun.reflect.annotation.ExceptionProxy;

/** Singleton class to handle access classes to the Database
 * @author Pontus Fredriksson.
 * */
public class DbHandler {

    /**The singleton instance. */
    private static DbHandler DbHandlerInstance =new DbHandler();

    /**Latest search*/
    private String searchString = "";

    /*The current pagenumber the UI will show*/
    private int pagenumber = 1;

    /**Change here based on preferences for UI*/
    private int hitsPerpage = 2147483647; //declare as private in SearchPageDb, set it according to this.


    private int hitAmount;

    /**Makes sure class is singleton*/
    private DbHandler(){}


    /**
     * @return how many pages of searchresults there is of the last searchquery.
     */
    public int getPageAmount(){
        if (hitsPerpage%hitsPerpage <0){
        return (hitAmount/hitsPerpage +1);
        }else{
            return hitAmount/hitsPerpage;
        }
    }
    /**Use to access DBhandler*/
    public static DbHandler getInstance(){
        return DbHandlerInstance;
        }

    //*Adds Contact to database*/
    public void add(Contact contact)throws Exception{
        if (AddDb.callDb(DBValidator.getCon(), contact)==true){
            searchPage(searchString);
        } else {
            throw new Exception("Couldn't add Contact in database");
        }
    }
    /**Deletes contact from database, and does a new search afterwards. */
    public void delete(Contact contact)throws Exception{
        if (DeleteDb.callDb(DBValidator.getCon(), contact)==true){
            searchPage(searchString);
        }else {
            throw new Exception("Couldn't delete Contact in database");
        }
    }

    /**Calls UpdateDb.CallDb()
     * Calls searchPage()*/
    public void update(Contact contact)throws Exception{

        if (UpdateDb.callDb(DBValidator.getCon(), contact)==true){
            searchPage(searchString);
        }else {
            throw new Exception("Couldn't update Contact in database.");
        }
    }
    /**Sets pagenumber to 1.
     * Calls SearchPagedb.CallDb() and adds results in ContactHandler.contactList*/
    public void searchPage(String searchString) throws Exception {
        this.searchString = searchString;
        pagenumber=1;
        if  (SearchPageDb.getInstance().callDb(DBValidator.getCon(), searchString, pagenumber, hitsPerpage)) {
            //is sending empty resultset:
            ContactHandler.getInstance().createFromString(SearchPageDb.getInstance().getResultSet());
            //hitAmount = SearchPageDb.getInstance().getHitAmount();
            //SearchPageDb.getInstance().getResultSet()
            //System.out.println("resultset: " +
            //        );
            System.out.println("DbHandler.searchpage ran.");
        }else {
            throw new Exception("Couldn't search Database");
        }

    }
    /**Updates pagenumber.
     * calls SearchPageDb.Calldb and adds results in ContactHandler.contactList. */
    public void nextPage(Contact contact) throws Exception{
        pagenumber++;
        if (SearchPageDb.getInstance().callDb(DBValidator.getCon(), searchString, pagenumber, hitsPerpage)==true){
            ContactHandler.getInstance().createFromString(SearchPageDb.getInstance().getResultSet());

        }else {
            throw new Exception("Couldn't search Contacts.");
        }
    }

    /**Updates pagenumber.
     * calls SearchPageDb.Calldb and adds results in ContactHandler.contactList.
     * @throws Exception if anything went wrong with the database.
     */
    public void previousPage() throws Exception{
        pagenumber--;
        if (SearchPageDb.getInstance().callDb(DBValidator.getCon(), searchString, pagenumber, hitsPerpage)==true){
            ContactHandler.getInstance().createFromString(SearchPageDb.getInstance().getResultSet());
        }else {
            throw new Exception("Couldn't search Contacts.");
        }
    }
    /**Calls Keygenerator.callDB and returns a ID not used in the database.*/
    public int generateID()throws Exception{
        int result = KeyGenerator.callDB(DBValidator.getCon());
        if (result>=0){
            return  result;
        }else throw new Exception("Couldnt Generate ID.");
    }

    public String getSearchString() {
        return searchString;
    }
}