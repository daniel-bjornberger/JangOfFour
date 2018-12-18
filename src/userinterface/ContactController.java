package userinterface;

import contacthandling.Contact;
import databasehandling.DbHandler;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;


/** Class that handles the JavaFX view that is defined by the fxml file ContactView,
 *  and the actions triggered by the controls in the view.
 * @author Daniel Björnberger
 */
public class ContactController {

    /** An instance of the singleton class Model. */
    Model model = Model.getInstance();

    /** An instance of the class Contact which is used to store the contact selected to be updated in the ContactView. */
    private Contact selectedContact;


    /** Label used as heading in the ContactView,
     * the text to be set is depending on if a new contact shall be added
     * or an existing contact shall be updated.  */
    @FXML
    private Label contactHeading;

    /** Text field used for input/update of the first name of the contact. */
    @FXML
    private TextField firstNameField;

    /** Text field used for input/update of the last name of the contact. */
    @FXML
    private TextField lastNameField;

    /** Text field used for input/update of the phone number of the contact. */
    @FXML
    private TextField phoneField;

    /** Text field used for input/update of the address of the contact. */
    @FXML
    private TextField addressField;

    /** Text field used for input/update of the email of the contact. */
    @FXML
    private TextField emailField;

    /** Button used to confirm the addition of a new contact / update of an existing contact,
     * and return to the ListOfContacts view. */
    @FXML
    private Button saveButton;

    /** Button used to abort addition of a new contact / update of an existing contact,
     * and return to the ListOfContacts view. */
    @FXML
    private Button cancelButton;


    /** The method initialize is automatically called when the ContactController view is shown,
     * in this method the save button disable property is bound to the text properties of the five text fields
     * in order to make sure that the save button can't be clicked when one or more of the text fields have incorrect values.
     * Also, if an existing contact has been selected for an update, the five text fields are filled with the
     * corresponding contact data. */
    public void initialize() {

        Pattern atSign = Pattern.compile(".*@.*");
        Pattern period = Pattern.compile(".*[.].*");

        saveButton.disableProperty().bind((firstNameField.textProperty().length().lessThan(2))
                .or(lastNameField.textProperty().length().lessThan(2))
                .or(phoneField.textProperty().length().lessThan(9))
                .or(addressField.textProperty().length().lessThan(5))
                .or(patternTextFieldBinding(emailField, period))
                .or(patternTextFieldBinding(emailField, atSign)));

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



    /** The method patternTextFieldBinding creates a BooleanBinding between a TextField and a Pattern.
     * @param textField The TextField for which the text shall be matched to a Pattern.
     * @param pattern The Pattern that shall be fulfilled by the text in the TextField.
     * @return A BooleanBinding between the text in the TextField and a defined Pattern.
     */
    private BooleanBinding patternTextFieldBinding(TextField textField, Pattern pattern) {

        BooleanBinding binding = Bindings.createBooleanBinding(() ->
                !pattern.matcher(textField.getText()).matches(), textField.textProperty());
        return binding;

    }



    /** The method actionSave is used to trigger the update of an existing contact in the database, or the addition
     * of a new contact to the database. Finally, the view is switched to the ListOfContactsView.
     * @param event The ActionEvent that triggered the save of a contact, in this case a click on the save button.
     */
    public void actionSave(ActionEvent event) {

        if (model.getSelectedContact() == null) {

            try {
                DbHandler.getInstance().add(new Contact(DbHandler.getInstance().generateID(),firstNameField.getText(),lastNameField.getText(),phoneField.getText(),addressField.getText(),emailField.getText()));
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }
        else {

            try {
                DbHandler.getInstance().update(new Contact(model.getSelectedContact().getId(),firstNameField.getText(),lastNameField.getText(),phoneField.getText(),addressField.getText(),emailField.getText()));
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }

        ChangeView changeView = new ChangeView();
        changeView.newView("ListOfContactsView.fxml", event);

    }



    /** The method actionCancel is used to switch back to the ListOfContactsView without doing any modification
     * of the database.
     * @param event The ActionEvent that triggered the save of a contact, in this case a click on the cancel button.
     */
    public void actionCancel(ActionEvent event) {

        ChangeView changeView = new ChangeView();
        changeView.newView("ListOfContactsView.fxml", event);

    }


}
