package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.pharmacy.Medicine;
import model.pharmacy.Pharmacy;
import model.pharmacy.Storage;
import model.users.HeadPharmacist;
import model.users.Pharmacist;
import services.EmptyTextFieldException;
import services.SwitchScreenService;
import views.AlertBox;

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

    @FXML
    private TextField tfNewArticle;

    @FXML
    private TextField tfNewPrice;

    @FXML
    private TextField tfNewPieces;

    @FXML
    private CheckBox chckPrescription;

    @FXML
    private Button btnAdd;

    @FXML
    private Label lblSum;

    @FXML
    private Button btnPay;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(Pharmacy.getInstance().getLoggedInUser() instanceof HeadPharmacist) {
            btnStorage.setVisible(true);
            btnUsers.setVisible(true);
        } else if(Pharmacy.getInstance().getLoggedInUser() instanceof Pharmacist) {
            btnStorage.setVisible(true);
        }
    }

    @FXML
    private void sideMenuHandler(ActionEvent event) throws IOException {
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

    @FXML
    private void addToStorageHandler(ActionEvent event) {
        if(event.getSource() == btnAdd) {
            String name = tfNewArticle.getText();
            String strPieces = tfNewPieces.getText();
            String strPrice = tfNewPrice.getText();
            boolean prescription = chckPrescription.isSelected();

            try {
                if(name == null || strPieces == null || strPrice == null) {
                    throw new EmptyTextFieldException();
                } else {
                    int pieces = Integer.parseInt(strPieces);
                    double price = Double.parseDouble(strPrice);
                    Medicine medicine = new Medicine(name, price, prescription);
                    Storage storage = Pharmacy.getInstance().getStorage();

                    storage.addToStorage(medicine, pieces);
                }
            } catch (EmptyTextFieldException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @FXML
    private void payOrderHandler(ActionEvent event) {
        if(event.getSource() == btnPay) {
            Pharmacy pharmacy = Pharmacy.getInstance();
            int value = pharmacy.getLoggedInUser().payOrder(pharmacy.getOrder());

            lblSum.setText("0.00 €");

            if(value == 1) {
                AlertBox.display("Platba", "Objednávka bola zaplatená!");
            } else if(value == 2) {
                AlertBox.display("Chyba", "Objednávka vyždauje lekársky predpis!");
            } else {
                AlertBox.display("Chyba", "Nákupný košík je prázdny!");
            }
        }
    }
}
