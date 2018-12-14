package userinterface;

import databasehandling.DBValidator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ContactListMain extends Application {


    @Override
    public void start(Stage stage) throws Exception{

        DBValidator dbValidator = new DBValidator();

        Parent root = FXMLLoader.load(getClass().getResource("ListOfContactsView.fxml"));

        stage.setTitle("Jang Of Four Contact List");

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }



    public static void main(String[] args) {

        launch(args);

    }


}
