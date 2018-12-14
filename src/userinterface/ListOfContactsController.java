package userinterface;

import contacthandling.Contact;
import databasehandling.DbHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class ListOfContactsController {


    public Model model = Model.getInstance();

    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;
    @FXML
    private Button listAllContactsButton;
    @FXML
    private Button addNewContactButton;
    @FXML
    private TableView<Contact> tableView;
    @FXML
    private TableColumn<Contact, String> firstNameColumn;
    @FXML
    private TableColumn<Contact, String> lastNameColumn;
    @FXML
    private TableColumn<Contact, String> phoneColumn;
    @FXML
    private TableColumn<Contact, String> addressColumn;
    @FXML
    private TableColumn<Contact, String> emailColumn;
    @FXML
    private Button updateContactButton;
    @FXML
    private Button deleteContactButton;



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



    public void updateView() {

        ObservableList<Contact> ObservableList = FXCollections.observableList(model.getContactHandler().getContactList());
        tableView.setItems(ObservableList);

    }



    public void actionSearch(ActionEvent event) {

        DbHandler.getInstance().searchPage(searchField.getText());

        updateContactButton.setDisable(true);
        deleteContactButton.setDisable(true);

    }



    public void actionListAllContacts(ActionEvent event) {

        DbHandler.getInstance().searchPage("");

    }



    public void actionAddNewContact(ActionEvent event) {

        model.setSelectedContact(null);

        ChangeView changeView = new ChangeView();
        changeView.newView("ContactView.fxml", event);

    }



    public void actionUpdateContact(ActionEvent event) {

        model.setSelectedContact(tableView.getSelectionModel().getSelectedItem());

        ChangeView changeView = new ChangeView();
        changeView.newView("ContactView.fxml", event);

    }



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



    public void rowSelectedInTable() {

        updateContactButton.setDisable(false);
        deleteContactButton.setDisable(false);

    }



    public void onEnter(ActionEvent event) {

        actionSearch(event);

    }


}