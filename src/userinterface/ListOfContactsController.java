package userinterface;

import contacthandling.Contact;
import databasehandling.DbHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class ListOfContactsController {


    public Model model = new Model();

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
    private Button updateButton0;
    @FXML
    private Button deleteButton0;
    @FXML
    private Button updateButton1;
    @FXML
    private Button deleteButton1;
    @FXML
    private Button updateButton2;
    @FXML
    private Button deleteButton2;
    @FXML
    private Button updateButton3;
    @FXML
    private Button deleteButton3;
    @FXML
    private Button updateButton4;
    @FXML
    private Button deleteButton4;
    @FXML
    private Button updateButton5;
    @FXML
    private Button deleteButton5;
    @FXML
    private Button updateButton6;
    @FXML
    private Button deleteButton6;
    @FXML
    private Button updateButton7;
    @FXML
    private Button deleteButton7;
    @FXML
    private Button updateButton8;
    @FXML
    private Button deleteButton8;
    @FXML
    private Button updateButton9;
    @FXML
    private Button deleteButton9;
    @FXML
    private Pagination pagination;

    public Pagination getPagination() {
        return pagination;
    }


    private ObservableList<Contact> contacts = FXCollections.observableList(new ArrayList<>());







    /*

    public ListOfContactsController() {
    }

    */


    public void initialize() {


        contacts.add(new Contact(1, "Octavius", "Rodriguez", "04 01 19 17 30", "Ap #964-2867 Sed St.", "et.malesuada@feugiatnonlobortis.net"));
        contacts.add(new Contact(2, "Fallon", "Nixon", "05 21 98 15 70", "908-6447 Euismod St.", "euismod.ac.fermentum@posuere.org"));
        contacts.add(new Contact(3, "Erasmus", "Vasquez", "06 06 87 13 34", "Ap #355-933 Curabitur St.", "Cras@volutpat.edu"));
        contacts.add(new Contact(4, "Erasmus", "Mcclure", "03 42 24 35 93", "P.O. Box 727, 3883 Facilisis, Ave", "Maecenas@sitametante.ca"));
        contacts.add(new Contact(5, "Heather", "Reilly", "04 09 48 25 34", "Ap #572-9149 Sed St.", "facilisi@odio.ca"));
        contacts.add(new Contact(6, "MacKenzie", "Leblanc", "04 88 98 01 83", "245 Sed Ave", "ac@estarcuac.ca"));
        contacts.add(new Contact(7, "Anne", "Quinn", "04 37 39 86 68", "Ap #842-6534 Eu Street", "dignissim.tempor.arcu@malesuadaid.co.uk"));
        contacts.add(new Contact(8, "Ulla", "Beard", "01 00 00 13 59", "8583 Ipsum Ave", "tincidunt.nunc.ac@nislsem.edu"));
        contacts.add(new Contact(9, "William", "Buckner", "06 09 33 76 71", "Ap #270-8558 Vehicula. St.", "neque@ante.org"));
        contacts.add(new Contact(10, "Hyatt", "Pruitt", "03 67 57 28 90", "2922 Pharetra Ave", "Donec.vitae.erat@velit.com"));
       /* contacts.add(new Contact(11, "Uriah", "Collier", "01 23 04 37 24", "P.O. Box 430, 2814 Cursus Av.", "nonummy@nullavulputate.co.uk"));
        contacts.add(new Contact(12, "Drake", "Weeks", "08 55 70 17 53", "Ap #379-2560 Sed, Road", "nunc.risus@sagittis.com"));
        contacts.add(new Contact(13, "Fredericka", "Russo", "01 39 91 49 35", "Ap #220-5616 Augue Rd.", "ut@nuncsit.edu"));
        contacts.add(new Contact(14, "Gareth", "Goff", "06 21 69 85 47", "Ap #811-6087 Vivamus Rd.", "nec.ante@mollisInteger.org"));
        contacts.add(new Contact(15, "Rashad", "Gamble", "09 60 27 68 92", "329-8417 Cum Av.", "semper.rutrum.Fusce@semmolestiesodales.com"));
        contacts.add(new Contact(16, "Buckminster", "Bean", "08 09 16 01 91", "8967 Turpis Avenue", "Mauris.non.dui@semmollisdui.ca"));
        contacts.add(new Contact(17, "Rashad", "Pena", "02 82 87 79 86", "Ap #628-9731 Auctor, Rd.", "at.risus@Phaselluslibero.edu"));
        contacts.add(new Contact(18, "Leigh", "Tyler", "02 46 78 77 57", "9424 Dui St.", "Duis@nonummyFusce.co.uk"));
        contacts.add(new Contact(19, "Abdul", "Holland", "06 19 78 67 42", "P.O. Box 649, 2195 Suspendisse Rd.", "blandit.mattis@IntegermollisInteger.edu"));
        contacts.add(new Contact(20, "Patrick", "Cunningham", "06 89 49 84 24", "2308 Ac Ave", "Donec.dignissim@habitantmorbitristique.co.uk"));
        contacts.add(new Contact(21, "Ethan", "Le", "03 84 86 81 53", "706-5400 Proin St.", "sociis.natoque.penatibus@amet.org"));
        contacts.add(new Contact(22, "Raphael", "Carr", "05 26 29 41 19", "Ap #189-3194 Parturient Street", "odio.auctor@justoProin.org"));
        contacts.add(new Contact(23, "Ebony", "Navarro", "06 92 92 45 55", "3777 Orci Av.", "nostra@idenim.org"));
        contacts.add(new Contact(24, "Skyler", "Hines", "01 29 53 56 24", "1121 Augue Rd.", "Duis.gravida.Praesent@magnis.com"));
        contacts.add(new Contact(25, "Benjamin", "Hampton", "09 26 87 48 97", "883-7641 Nunc Street", "faucibus.orci@Aliquam.com"));
        contacts.add(new Contact(26, "Thane", "Parks", "02 33 32 41 58", "P.O. Box 278, 3756 Non Road", "placerat@ligulaAliquamerat.com"));
        contacts.add(new Contact(27, "Sheila", "Pennington", "05 44 53 12 69", "8787 Vitae Avenue", "odio@nonbibendumsed.edu"));
        contacts.add(new Contact(28, "Ahmed", "Britt", "04 64 66 52 67", "172-7985 Eleifend Street", "Lorem@aliquet.net"));
        contacts.add(new Contact(29, "Daryl", "Richard", "05 14 34 95 87", "Ap #797-9976 Rutrum St.", "Praesent.interdum@erateget.org"));
        contacts.add(new Contact(30, "Clementine", "Lane", "09 90 32 83 94", "9213 Amet, St.", "sodales.at@hendreritconsectetuercursus.ca"));
        contacts.add(new Contact(31, "Armand", "Valentine", "08 28 90 56 51", "259-2927 Quis Av.", "congue@Phasellusin.net"));
        contacts.add(new Contact(32, "Rogan", "Lynch", "09 84 06 56 04", "5253 Convallis Avenue", "ultrices@libero.edu"));
        contacts.add(new Contact(33, "Garrison", "Park", "07 26 03 06 09", "P.O. Box 242, 4467 Nunc Road", "vel.sapien.imperdiet@lectus.co.uk"));*/


        System.out.println("Hej!");

        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));


        //tableView.setItems(contacts);
        model.getContactHandler().addListener((c) -> updateView());
        //tableView.setItems((ObservableList<Contact>) model.getContactHandler().getContactList())
    }

    public void updateView() {
        ObservableList<Contact> ObservableList = FXCollections.observableList(model.getContactHandler().getContactList());
        tableView.setItems(ObservableList);
    }

    public void actionSearch(ActionEvent event) {
        DbHandler.getInstance().searchPage(searchField.getText());
    }

    public void actionAddNewContact(ActionEvent event) {

        /*
        ChangeView changeView = new ChangeView();
        changeView.newWindow("ContactView.fxml");
        */


        Parent parent = null;

        try {
            parent = FXMLLoader.load(getClass().getResource("ContactView.fxml"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        Scene scene = new Scene(parent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();


    }
}
