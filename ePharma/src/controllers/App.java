package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.pharmacy.Pharmacy;
import services.SerializationService;

import java.io.IOException;

/**
 * Main class which we run
 */
public class App extends Application {
    private Pharmacy pharmacy;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Start method for loading very first view
     * @param primaryStage Stage
     * @throws Exception Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/LoginCustomer.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Method where we call SerializationService and deserialize pharmacy instance
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void deserializeInstance() throws IOException, ClassNotFoundException {
        pharmacy = (Pharmacy) SerializationService.deserialize();
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }
}
