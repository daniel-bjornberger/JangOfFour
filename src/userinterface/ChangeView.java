package userinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


/** Class with one single method that is used to switch view in the JavaFX stage.
 * @author Daniel Björnberger
 */
public class ChangeView {


    /** The method newView switches to a different view, in the same window that is already used by JavaFX.
     * @param path The string 'path' contains the file name of the fxml file that defines the view to be switched to.
     * @param event The ActionEvent that triggered the switch of view, typically a click on a button.
     */
    public void newView(String path, ActionEvent event) {

        Parent parent = null;

        try {
            parent = FXMLLoader.load(getClass().getResource(path));
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }

        Scene scene = new Scene(parent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();

    }


}