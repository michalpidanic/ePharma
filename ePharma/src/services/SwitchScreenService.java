package services;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Service that provides switching view
 */
public class SwitchScreenService {
    /**
     * Method for screen change
     * @param event Event
     * @param path Path to .fxml file we to to switch to
     * @throws IOException Exception when .fxml file not found
     */
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
