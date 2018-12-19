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




    /**Use to access DBhandler
     * @return the singleton instance of DbHandler
     */
    public static DbHandler getInstance(){
        return DbHandlerInstance;
        }


    /**Adds Contact to database
     * @param contact contains info about the contact to add to the database.
     * Make sure the contact used Keygenerator.CallDb() to generate ID.
     * @throws Exception if anything went wrong.
     */
    public void add(Contact contact)throws Exception{
        if (AddDb.callDb(DBValidator.getCon(), contact)==true){
            searchPage(searchString);
        } else {
            throw new Exception("Couldn't add Contact in database");
        }
    }

    /**Deletes contact from database, and does a new search afterwards.
     * @param contact contains the ID Primary Key for the contact to delete from database.
     * @throws Exception if anything went wrong.
     */
    public void delete(Contact contact)throws Exception{
        if (DeleteDb.callDb(DBValidator.getCon(), contact)==true){
            searchPage(searchString);
        }else {
            throw new Exception("Couldn't delete Contact in database");
        }
    }


    /**Calls UpdateDb.CallDb()
     * Calls searchPage()
     * @param contact contains ID Primary Key and new info for the database.
     * @throws Exception if anything went wrong.
     */
        public void update(Contact contact)throws Exception{

        if (UpdateDb.callDb(DBValidator.getCon(), contact)==true){
            searchPage(searchString);
        }else {
            throw new Exception("Couldn't update Contact in database.");
        }
    }

    /**Sets pagenumber to 1.
     * Calls SearchPagedb.CallDb() and adds results in ContactHandler.contactList
     * @param searchString for SearchPageDb to create query from.
     * @throws Exception
     */
    public void searchPage(String searchString) throws Exception {
        this.searchString = searchString;
        pagenumber=1;
        if  (SearchPageDb.getInstance().callDb(DBValidator.getCon(), searchString, pagenumber, hitsPerpage)) {
            //is sending empty resultset:
            ContactHandler.getInstance().createFromString(SearchPageDb.getInstance().getResultSet());
            //SearchPageDb.getInstance().getResultSet()
            //System.out.println("resultset: " +
            //        );
            System.out.println("DbHandler.searchpage ran.");
        }else {
            throw new Exception("Couldn't search Database");
        }

    }



    /**Calls Keygenerator.callDB and returns a ID not used in the database.*/
    public int generateID()throws Exception{
        int result = KeyGenerator.callDB(DBValidator.getCon());
        if (result>=0){
            return  result;
        }else throw new Exception("Couldnt Generate ID.");
    }

    /**
     * @return the latest used search string
     */
    public String getSearchString() {
        return searchString;
    }
}