package UserInterface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Gui extends Application {

    Stage window;
    Scene loginForm;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("ePharma");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));

        Text loginTxt = new Text("Login");
        loginTxt.setFont(Font.font("Arial Black", FontWeight.LIGHT, 25));
        grid.add(loginTxt, 0, 0);

        Label lblUser = new Label("Username");
        grid.add(lblUser, 0, 1);

        TextField txtUser = new TextField();
        txtUser.setPromptText("username");
        grid.add(txtUser, 1, 1);

        Label lblPass = new Label("Password");
        grid.add(lblPass, 0, 2);

        PasswordField txtPass = new PasswordField();
        txtPass.setPromptText("password");
        grid.add(txtPass, 1, 2);

        Button loginBtn = new Button("Login");
        grid.add(loginBtn, 1,3);

        loginForm = new Scene(grid, 500, 500);
        window.setScene(loginForm);
        window.show();
    }
}
