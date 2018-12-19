package userinterface;

import contacthandling.Contact;
import contacthandling.ContactHandler;
import databasehandling.DbHandler;

/** Singleton class that handles storage of the selected contact and retrieval of the ContactHandler.
 * @author Pontus Fredriksson + Joel Gunnarsson
 */
public class Model {

    /** The singleton instance of Model.
     */
    private static Model model = new Model();

    /** The singleton instance of DbHandler.
     */
    private DbHandler dbHandler = DbHandler.getInstance();

    /** The singleton instance of ContactHandler.
     */
    private ContactHandler contactHandler = ContactHandler.getInstance();

    /** Storage of the selected contact.
     */
    private Contact selectedContact;

    /** Constructor for the Model class.
     */
    private Model(){}


    /** The method getInstance returns the instance of Model.
     * @return The singleton instance of the Model class.
     */
    public static Model getInstance(){
        return model;
    }


    /** The method setSelectedContact is used to store the selected contact in the instance of Model.
     * @param selectedContact The selected contact.
     */
    public void setSelectedContact(Contact selectedContact) {
        this.selectedContact = selectedContact;
    }


    /** The method getSelectedContact is used to retrieve the selected contact stored in the instance of Model.
     * @return The selected contact.
     */
    public Contact getSelectedContact(){
        return selectedContact;
    }


    /** The method getDbHandler is used to retrieve the singleton instance of DbHandler.
     * @return The singleton instance of DbHandler.
     */
    public DbHandler getDbHandler() {
        return dbHandler;
    }


    /** The method getContactHandler is used to retrieve the singleton instance of ContactHandler.
     * @return The singleton instance of ContactHandler.
     */
    public ContactHandler getContactHandler() {
        return contactHandler;
    }


}
