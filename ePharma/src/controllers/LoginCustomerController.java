package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.LoginService;
import services.SerializationService;
import services.SwitchScreenService;
import views.AlertBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginCustomerController implements Initializable {
    App app = new App();

    @FXML
    private TextField tfInsuranceNumber;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnSwitchUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            app.deserializeInstance();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void switchUser(ActionEvent event) throws IOException {
        SwitchScreenService.newScreen(event, "/views/LoginUser.fxml");
    }

    @FXML
    public void loginCustomer(ActionEvent event) throws IOException {
        if(event.getSource() == btnLogin) {
            if(LoginService.verifyLogin(tfInsuranceNumber.getText(), app.getPharmacy())) {
                SerializationService.serialize(app.getPharmacy());
                SwitchScreenService.newScreen(event, "/views/Home.fxml");
            } else {
                AlertBox.display("Chyba", "Nesprávne číslo poistenca!");
            }
        }
    }
}
