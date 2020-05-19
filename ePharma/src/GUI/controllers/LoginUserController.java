package GUI.controllers;

import GUI.views.AllertBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pharmacy.Pharmacy;
import services.LoginService;
import services.SwitchScreenService;

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
        SwitchScreenService.newScreen(event, "/GUI/views/LoginCustomer.fxml");
    }

    @FXML
    public void loginUser(ActionEvent event) throws IOException {
        if(event.getSource() == btnLogin) {
            if(LoginService.verifyLogin(tfUsername.getText(), pfPassword.getText(), Pharmacy.getInstance())) {
                SwitchScreenService.newScreen(event, "/GUI/views/Home.fxml");
            } else {
                AllertBox.display("Nesprávne prihlasovacie údaje!");
            }
        }
    }
}
