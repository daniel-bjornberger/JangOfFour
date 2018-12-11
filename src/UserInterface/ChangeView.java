package UserInterface;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class ChangeView {


    public  void newWindow(String path) {


        try {


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ContactView.fxml"));
            Parent content = loader.load();
            //root = FXMLLoader.load(getClass().getClassLoader().getResource("ContactView.fxml"),r);
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(content, 1536, 864));
            stage.show();
            // Hide this current window (if this is what you want)
            //((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
