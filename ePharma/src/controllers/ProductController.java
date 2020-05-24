package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.pharmacy.Medicine;
import model.pharmacy.Order;
import model.pharmacy.Pharmacy;
import model.pharmacy.Storage;
import services.SerializationService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
    App app = new App();

    @FXML
    private Label lblName;

    @FXML
    private Label lblPrice;

    @FXML
    private Label lblPrescription;

    @FXML
    private TextField tfPieces;

    @FXML
    private Button btnBuy;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            app.deserializeInstance();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addToOrderHandler(ActionEvent event) throws IOException {
        if(event.getSource() == btnBuy) {
            String name = lblName.getText();
            int pieces = Integer.parseInt(tfPieces.getText());
            Pharmacy pharmacy = app.getPharmacy();
            Storage storage = pharmacy.getStorage();
            Order order = pharmacy.getOrder();
            Medicine medicine = storage.findMedicine(name);

            order.addToOrder(medicine, pieces, storage);
            SerializationService.serialize(app.getPharmacy());
        }
    }
}