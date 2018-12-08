package UserInterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListOfContactsView.fxml"));
        Parent root = loader.load();

        ListOfContactsController listOfContactsController = loader.getController();
        listOfContactsController.init();
        listOfContactsController.setStage(primaryStage);

        primaryStage.setTitle("Drawing shapes");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

}
