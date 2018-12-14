package userinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class ChangeView {


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