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

/**
 * Controller for LoginCustomer view
 */
public class LoginCustomerController implements Initializable {
    App app = new App();

    @FXML
    private TextField tfInsuranceNumber;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnSwitchUser;

    /**
     * Method for view and controller initialization
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            app.deserializeInstance();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for switching view on LoginUser
     * @param event Click on btnSwitchUser
     * @throws IOException Exception when .fxml file not found
     */
    @FXML
    public void switchUser(ActionEvent event) throws IOException {
        SwitchScreenService.newScreen(event, "/views/LoginUser.fxml");
    }

    /**
     * Method calls LoginService and if typed in insurance number is correct, user will be logged in and view will be switched via SwitchScreenService
     * When insurance number is incorrect, AlertBox pops up
     * @param event Click on btnLogin
     * @throws IOException Exception when .fxml file not found
     */
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
