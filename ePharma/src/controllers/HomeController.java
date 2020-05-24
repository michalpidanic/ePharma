package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.pharmacy.Medicine;
import model.pharmacy.Pharmacy;
import model.pharmacy.Storage;
import model.users.HeadPharmacist;
import model.users.Pharmacist;
import services.*;
import views.AlertBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    App app = new App();

    @FXML
    private Button btnProducts;

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

    @FXML
    private Button btnCancel;

    @FXML
    private VBox pnCart;

    @FXML
    private VBox pnProducts;

    @FXML
    private VBox pnStore;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            app.deserializeInstance();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(app.getPharmacy().getLoggedInUser() instanceof HeadPharmacist) {
            btnStorage.setVisible(true);
            btnUsers.setVisible(true);
        } else if(app.getPharmacy().getLoggedInUser() instanceof Pharmacist) {
            btnStorage.setVisible(true);
        }

        ProductsViewService.paneInit(app.getPharmacy().getStorage(), pnProducts);
    }

    @FXML
    private void sideMenuHandler(ActionEvent event) throws IOException, ClassNotFoundException {
        if(event.getSource() == btnProducts) {
            app.deserializeInstance();
            pnProducts.getChildren().clear();
            ProductsViewService.paneInit(app.getPharmacy().getStorage(), pnProducts);
            pnMenu.toFront();

        } else if(event.getSource() == btnOrder) {
            app.deserializeInstance();
            pnCart.getChildren().clear();
            CartViewService.paneInit(app.getPharmacy().getOrder(), pnCart);
            pnOrder.toFront();

        } else if(event.getSource() == btnStorage) {
            app.deserializeInstance();
            pnStore.getChildren().clear();
            StoreViewService.paneInit(app.getPharmacy().getStorage(), pnStore);
            pnStorage.toFront();

        } else if(event.getSource() == btnUsers) {
            app.deserializeInstance();
            pnUsers.toFront();

        } else if(event.getSource() == btnLogout) {
            app.getPharmacy().logout(app.getPharmacy().getLoggedInUser());

            SerializationService.serialize(app.getPharmacy());
            SwitchScreenService.newScreen(event, "/views/LoginCustomer.fxml");
        }
    }

    @FXML
    private void registrationHandler(ActionEvent event) throws IOException {
        if(event.getSource() == btnRegister) {
            String name = tfNewUsername.getText();
            String id = tfNewID.getText();
            String password = pfNewPassword.getText();

            try {
                if(name == null || id == null || password == null) {
                    throw new EmptyTextFieldException();
                } else {
                    HeadPharmacist admin = (HeadPharmacist) app.getPharmacy().getLoggedInUser();
                    admin.registerUser(name, password, id, app.getPharmacy());
                    SerializationService.serialize(app.getPharmacy());
                    tfNewUsername.setText(null);
                    tfNewID.setText(null);
                    pfNewPassword.setText(null);
                }
            } catch (EmptyTextFieldException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @FXML
    private void addToStorageHandler(ActionEvent event) throws IOException {
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
                    Storage storage = app.getPharmacy().getStorage();

                    storage.addToStorage(medicine, pieces);
                    SerializationService.serialize(app.getPharmacy());
                }
            } catch (EmptyTextFieldException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @FXML
    private void payOrderHandler(ActionEvent event) throws IOException {
        if(event.getSource() == btnPay) {
            Pharmacy pharmacy = app.getPharmacy();
            int value = pharmacy.getLoggedInUser().payOrder(pharmacy.getOrder());
            SerializationService.serialize(app.getPharmacy());

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

    @FXML
    private void cancelOrderHandler(ActionEvent event) throws IOException {
        if(event.getSource() == btnCancel) {
            Pharmacy pharmacy = app.getPharmacy();
            pharmacy.getOrder().cancelOrder(pharmacy.getStorage());
            SerializationService.serialize(app.getPharmacy());

            lblSum.setText("0.00 €");

            AlertBox.display("Zrušené", "Objednávka bola zrušená!");
        }
    }
}