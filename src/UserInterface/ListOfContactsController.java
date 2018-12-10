package UserInterface;

import ContactHandling.Contact;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class ListOfContactsController {


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
    private Pagination pagination;






}
