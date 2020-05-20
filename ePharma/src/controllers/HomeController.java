package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.pharmacy.Pharmacy;
import model.users.HeadPharmacist;
import services.EmptyTextFieldException;
import services.SwitchScreenService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private Button btnMenu;

    @FXML
    private Button btnOrder;

    @FXML
    private Button btnStorage;

    @FXML
    private Button btnUsers;

    @FXML
    private Button btnLogout;

    @FXML
    private GridPane pnMenu;

    @FXML
    private GridPane pnOrder;

    @FXML
    private GridPane pnStorage;

    @FXML
    private GridPane pnUsers;

    @FXML
    private TextField tfNewUsername;

    @FXML
    private TextField tfNewID;

    @FXML
    private PasswordField pfNewPassword;

    @FXML
    private Button btnRegister;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleClicks(ActionEvent event) throws IOException {
        if(event.getSource() == btnMenu) {
            pnMenu.toFront();

        } else if(event.getSource() == btnOrder) {
            pnOrder.toFront();

        } else if(event.getSource() == btnStorage) {
            pnStorage.toFront();

        } else if(event.getSource() == btnUsers) {
            pnUsers.toFront();

        } else if(event.getSource() == btnLogout) {
            Pharmacy pharmacy = Pharmacy.getInstance();
            pharmacy.logout(pharmacy.getLoggedInUser());

            SwitchScreenService.newScreen(event, "/views/LoginCustomer.fxml");
        }
    }

    @FXML
    private void registrationHandler(ActionEvent event) {
        if(event.getSource() == btnRegister) {
            String name = tfNewUsername.getText();
            String id = tfNewID.getText();
            String password = pfNewPassword.getText();

            try {
                if(name == null || id == null || password == null) {
                    throw new EmptyTextFieldException();
                } else {
                    HeadPharmacist admin = (HeadPharmacist) Pharmacy.getInstance().getLoggedInUser();
                    admin.registerUser(name, password, id, Pharmacy.getInstance());
                }
            } catch (EmptyTextFieldException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
