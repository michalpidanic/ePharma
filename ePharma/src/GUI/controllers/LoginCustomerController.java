package GUI.controllers;

import GUI.views.AllertBox;
import pharmacy.Pharmacy;
import services.LoginService;
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

public class LoginCustomerController implements Initializable {
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
    public void switchUser(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/views/LoginUser.fxml"));
        Parent content = loader.load();

        Scene newScene = new Scene(content);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.hide();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    public void loginCustomer(ActionEvent event) throws IOException {
        if(event.getSource() == btnLogin) {
            if(LoginService.verifyLogin(tfInsuranceNumber.getText(), Pharmacy.getInstance())) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/GUI/views/Home.fxml"));
                Parent content = loader.load();

                Scene newScene = new Scene(content);

                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                window.hide();
                window.setScene(newScene);
                window.show();
            } else {
                AllertBox.display("Nesprávne číslo poistenca!");
            }
        }
    }
}
