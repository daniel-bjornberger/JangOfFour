package userinterface;

import contacthandling.Contact;
import databasehandling.DbHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


/** Class that handles the JavaFX view that is defined by the fxml file ListOfContactsView,
 *  and the actions triggered by the controls in the view.
 * @author Daniel Björnberger
 */
public class ListOfContactsController {


    /** An instance of the singleton class Model. */
    public Model model = Model.getInstance();

    /** Text field used for input of the text string to search for. */
    @FXML
    private TextField searchField;
    /** Button used to initiate a search in the database. */
    @FXML
    private Button searchButton;
    /** Button used to list all contacts in the database, by searching for an empty text string in the database. */
    @FXML
    private Button listAllContactsButton;
    /** Button used to switch to the 'add new contact'-view. */
    @FXML
    private Button addNewContactButton;
    /** A TableView control used to display contacts in a table, where a new contact can be created. */
    @FXML
    private TableView<Contact> tableView;
    /** A TableColumn control used to display the first names of the contacts in the table defined by TableView control. */
    @FXML
    private TableColumn<Contact, String> firstNameColumn;
    /** A TableColumn control used to display the last names of the contacts in the table defined by TableView control. */
    @FXML
    private TableColumn<Contact, String> lastNameColumn;
    /** A TableColumn control used to display the phone numbers of the contacts in the table defined by TableView control. */
    @FXML
    private TableColumn<Contact, String> phoneColumn;
    /** A TableColumn control used to display the addresses of the contacts in the table defined by TableView control. */
    @FXML
    private TableColumn<Contact, String> addressColumn;
    /** A TableColumn control used to display the emails of the contacts in the table defined by TableView control. */
    @FXML
    private TableColumn<Contact, String> emailColumn;
    /** Button used to switch to the 'update contact' view, where an existing contact can be modified. */
    @FXML
    private Button updateContactButton;
    /** Button used to delete a contact in the database. */
    @FXML
    private Button deleteContactButton;


    /** The method initialize is automatically called when the ListOfContactsController view is shown,
     * in this method the cell value factories of the five TableColumns are set, in order to specify how
     * the cells in a column shall be filled in. Also, the update and delete buttons are disabled, the
     * search field is filled in with the latest text string searched for, a listener is added to the
     * contact handler instance and finally a search is performed.
     */
    public void initialize() {

        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        updateContactButton.setDisable(true);
        deleteContactButton.setDisable(true);

        searchField.setText(DbHandler.getInstance().getSearchString());

        model.getContactHandler().addListener((c) -> updateView());
        actionSearch(null);

    }


    /** The method updateView updates the TableView with the current contacts in the contact list in the model.
     */
    public void updateView() {

        ObservableList<Contact> ObservableList = FXCollections.observableList(model.getContactHandler().getContactList());
        tableView.setItems(ObservableList);

    }


    /** The method actionSearch performs a search in the database, for the text string that has been
     * written in the search field. Also, the update and delete buttons are disabled.
     * @param event The ActionEvent that triggered the search, either the search button was clicked or
     *              the enter key was pressed on the keyboard.
     */
    public void actionSearch(ActionEvent event) {

        DbHandler.getInstance().searchPage(searchField.getText());

        updateContactButton.setDisable(true);
        deleteContactButton.setDisable(true);

    }


    /** The method actionListAllContacts lists all contacts in the database, by searching for an empty text string.
     * @param event The ActionEvent that triggered the search, in this case a click on the 'List all contacts' button.
     */
    public void actionListAllContacts(ActionEvent event) {

        DbHandler.getInstance().searchPage("");

    }


    /** The method actionAddNewContact sets the selected contact to null, and switches to the contact view.
     * @param event The ActionEvent that triggered the change of view, in this case a click on the 'Add new contact' button.
     */
    public void actionAddNewContact(ActionEvent event) {

        model.setSelectedContact(null);

        ChangeView changeView = new ChangeView();
        changeView.newView("ContactView.fxml", event);

    }


    /** The method actionUpdateContact sets the selected contact to the one chosen in the table, and switches to the contact view.
     * @param event The ActionEvent that triggered the change of view, in this case a click on the 'Update contact' button.
     */
    public void actionUpdateContact(ActionEvent event) {

        model.setSelectedContact(tableView.getSelectionModel().getSelectedItem());

        ChangeView changeView = new ChangeView();
        changeView.newView("ContactView.fxml", event);

    }


    /**
     * @param event
     */
    public void actionDeleteContact(ActionEvent event) {

        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);

        model.setSelectedContact(tableView.getSelectionModel().getSelectedItem());

        Alert alert = new Alert(Alert.AlertType.NONE, "Delete the contact " + model.getSelectedContact().getFirstname() + " " + model.getSelectedContact().getLastname() + "?", yes, no);

        alert.showAndWait();

        if (alert.getResult() == yes) {

            try {
                DbHandler.getInstance().delete(model.getSelectedContact());
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }

            updateContactButton.setDisable(true);
            deleteContactButton.setDisable(true);

        }

    }


    /**
     *
     */
    public void rowSelectedInTable() {

        updateContactButton.setDisable(false);
        deleteContactButton.setDisable(false);

    }


    /**
     * @param event
     */
    public void onEnter(ActionEvent event) {

        actionSearch(event);

    }


}