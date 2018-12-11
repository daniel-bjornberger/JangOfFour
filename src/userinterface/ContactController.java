package userinterface;

import contacthandling.Contact;
import databasehandling.DbHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class ContactController {


    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField emailField;
    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;


    public void actionSave(ActionEvent event) throws Exception {
        DbHandler.getInstance().add(new Contact(DbHandler.getInstance().generateID(),firstNameField.getText(),lastNameField.getText(),phoneField.getText(),addressField.getText(),emailField.getText()));

        //firstNameField.getText()

    }
}
