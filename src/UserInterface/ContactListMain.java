package UserInterface;

import databaseHandling.DBValidator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ContactListMain extends Application {


    @Override
    public void start(Stage stage) throws Exception{
        DBValidator dbValidator=new DBValidator();

        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("ListOfContactsView.fxml"));
        Parent root = loader.load();

        ListOfContactsController listOfContactsController = loader.getController();
        listOfContactsController.init();
        //listOfContactsController.setStage(primaryStage);

        primaryStage.setTitle("Jang Of Four Contact List");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();*/


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
