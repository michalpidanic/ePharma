package views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Alert box with manually coded handler without using FXML
 */
public class AlertBox {
    /**
     * Method pops up alert box and freezes entire view behind it
     * @param title Title of alert box
     * @param message Message that alert box contains
     */
    public static void display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(250);

        Label label = new Label();
        label.setText(message);
        Button btnClose = new Button("Zrušiť");
        btnClose.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, btnClose);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
