package userinterface;

import contacthandling.Contact;
import databasehandling.DbHandler;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class ContactController {

    Model model = Model.getInstance();
    private Contact selectedContact;


    @FXML
    private Label contactHeading;
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
    private Button saveButton;
    @FXML
    private Button cancelButton;



    public void initialize() {

        saveButton.disableProperty().bind((Bindings.isEmpty(firstNameField.textProperty()))
                .or(Bindings.isEmpty(lastNameField.textProperty()))
                .or(Bindings.isEmpty(phoneField.textProperty()))
                .or(Bindings.isEmpty(addressField.textProperty()))
                .or(Bindings.isEmpty(emailField.textProperty())));

        selectedContact = model.getSelectedContact();

        if (selectedContact != null) {

            firstNameField.setText(selectedContact.getFirstname());
            lastNameField.setText(selectedContact.getLastname());
            phoneField.setText(selectedContact.getPhone());
            addressField.setText(selectedContact.getAddress());
            emailField.setText(selectedContact.getEmail());

            contactHeading.setText("Update contact");

        }
        else {

            contactHeading.setText("Add new contact");

        }

    }





    public void actionSave(ActionEvent event) throws Exception {
        if(model.getSelectedContact()==null){
            DbHandler.getInstance().add(new Contact(DbHandler.getInstance().generateID(),firstNameField.getText(),lastNameField.getText(),phoneField.getText(),addressField.getText(),emailField.getText()));
        }else {
            DbHandler.getInstance().update(new Contact(model.getSelectedContact().getId(),firstNameField.getText(),lastNameField.getText(),phoneField.getText(),addressField.getText(),emailField.getText()));
        }

        Parent parent = null;

        try {
            parent = FXMLLoader.load(getClass().getResource("ListOfContactsView.fxml"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        Scene scene = new Scene(parent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
        //firstNameField.getText()

    }

    public void actionCancel(ActionEvent event) {

        Parent parent = null;

        try {
            parent = FXMLLoader.load(getClass().getResource("ListOfContactsView.fxml"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        Scene scene = new Scene(parent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();

    }


    /*public void initTextFields(Contact contact) {

        selectedContact = contact;

        firstNameField.setText(selectedContact.getFirstname());
        lastNameField.setText(selectedContact.getLastname());
        phoneField.setText(selectedContact.getPhone());
        addressField.setText(selectedContact.getAddress());
        emailField.setText(selectedContact.getEmail());

    }*/


}
