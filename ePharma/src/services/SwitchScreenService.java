package services;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SwitchScreenService {
    @FXML
    public static void newScreen(ActionEvent event, String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(SwitchScreenService.class.getResource(path));
        Parent content = loader.load();

        Scene newScene = new Scene(content);

        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());

        window.setScene(newScene);
        window.show();
    }

}
