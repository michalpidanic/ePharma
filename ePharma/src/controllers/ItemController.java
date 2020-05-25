package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.pharmacy.Medicine;
import model.pharmacy.Order;
import model.pharmacy.Pharmacy;
import model.pharmacy.Storage;
import services.SerializationService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for Item view
 */
public class ItemController implements Initializable {
    App app = new App();

    @FXML
    private Label lblName;

    @FXML
    private Label lblPrice;

    @FXML
    private Label lblPrescription;

    @FXML
    private Label lblPieces;

    @FXML
    private Button btnTake;

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
     * Method calls method from model for Order takeFromOrder, takes one piece of item from order and Serialization of pharmacy will be provided
     * @param event Click on btnTake
     * @throws IOException
     */
    @FXML
    void takeFromOrderHandler(ActionEvent event) throws IOException {
        if(event.getSource() == btnTake) {
            String name = lblName.getText();
            int pieces = Integer.parseInt(lblPieces.getText());
            if(pieces > 0) {
                Pharmacy pharmacy = app.getPharmacy();
                Storage storage = pharmacy.getStorage();
                Order order = pharmacy.getOrder();
                Medicine medicine = storage.findMedicine(name);


                lblPieces.setText(String.valueOf(pieces - 1));

                order.takeFromOrder(medicine, storage);
                SerializationService.serialize(app.getPharmacy());
            }
        }
    }

    /**
     * Method sets all the labels and visibility of button on Item view
     * @param name Name of medicine
     * @param price Price of medicine
     * @param prescription Boolean if medicine is on prescription
     * @param pieces Pieces of medicine in cart/storage
     * @param hide Boolean whether we want to hide btnTake or not
     */
    @FXML
    public void setElements(String name, double price, boolean prescription, int pieces, boolean hide) {
        lblName.setText(name);
        lblPrice.setText(String.valueOf(price));
        lblPieces.setText(String.valueOf(pieces));
        if(prescription) {
            lblPrescription.setText("na predpis");
        } else {
            lblPrescription.setText("voľný predaj");
        }
        if(hide) {
            btnTake.setVisible(false);
        }
    }
}
