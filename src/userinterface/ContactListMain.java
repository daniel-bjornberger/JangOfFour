package userinterface;

import databasehandling.DBValidator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/** Class that extends javafx.application.Application, the class is used to launch JavaFX.
 * @author Daniel Björnberger
 */
public class ContactListMain extends Application {


    /** The method start is called when the JavaFX application is started. The method sets up a scene/view within the Stage.
     * The scene/view is defined by the fxml file ListOfContactsView.
     * @param stage The object stage is where the the visual parts of the JavaFX application will be displayed,
     *              the stage is created by the JavaFX runtime.
     * @throws Exception The method FXMLLoader.load may throw an IOException.
     */
    @Override
    public void start(Stage stage) throws Exception {

        DBValidator dbValidator = new DBValidator();

        Parent root = FXMLLoader.load(getClass().getResource("ListOfContactsView.fxml"));

        stage.setTitle("Jang Of Four Contact List");

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }


    /** The main method calls the static method launch in the Application class, which launches JavaFX runtime and the JavaFX application.
     * @param args Parameters to the Java main method, not used.
     */
    public static void main(String[] args) {

        launch(args);

    }


}
