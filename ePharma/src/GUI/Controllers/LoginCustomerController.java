package GUI.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginCustomerController implements Initializable {
    @FXML
    private Label btnClose;

    @FXML
    private TextField tfInsuranceNumber;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnSwitchUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void setBtnSwitchUser(ActionEvent event) throws IOException {
        if(event.getSource() == btnSwitchUser) {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/LoginUser.fxml"));

            Scene scene = btnSwitchUser.getScene();
        }
    }

    @FXML
    private void handleClose(MouseEvent event) {
        if(event.getSource() == btnClose) {
            System.exit(0);
        }
    }
}
