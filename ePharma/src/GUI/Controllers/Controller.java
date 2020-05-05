package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
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
    private Label btnClose;

    @FXML
    private GridPane pnMenu;

    @FXML
    private GridPane pnOrder;

    @FXML
    private GridPane pnStorage;

    @FXML
    private GridPane pnUsers;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleClicks(ActionEvent event) {
        if(event.getSource() == btnMenu) {
            pnMenu.toFront();

        } else if(event.getSource() == btnOrder) {
            pnOrder.toFront();

        } else if(event.getSource() == btnStorage) {
            pnStorage.toFront();

        } else if(event.getSource() == btnUsers) {
            pnUsers.toFront();

        } else if(event.getSource() == btnLogout) {
            pnMenu.toFront();
        }
    }

    @FXML
    private void handleClose(MouseEvent event) {
        if(event.getSource() == btnClose) {
            System.exit(0);
        }
    }
}
