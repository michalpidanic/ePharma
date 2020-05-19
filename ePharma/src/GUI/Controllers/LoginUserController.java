package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginUserController implements Initializable {
    @FXML
    private TextField tfUsername;

    @FXML
    private TextField pfPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnSwitchUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void switchUser(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/fxml/LoginCustomer.fxml"));
        Parent content = loader.load();

        Scene newScene = new Scene(content);

        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());

        window.setScene(newScene);
        window.show();
    }
}
