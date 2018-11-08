package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Controller {
    @FXML private Button registerButton, login;
    @FXML private TextField userLogin;
    @FXML private PasswordField passLogin;

    public void changeRegisClick(ActionEvent actionEvent) throws IOException {
        Parent regis = FXMLLoader.load(getClass().getResource("regis.fxml"));
        Scene regisView = new Scene(regis);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(regisView);
        window.show();
    }

    public void loginIdPass(ActionEvent actionEvent) {
        String loginLabelUserPass = userLogin.getText() + passLogin.getText();
        userLogin.setText("");
        passLogin.setText("");
        System.out.println(loginLabelUserPass);
        Path file = Paths.get("IdPass.txt");
//        BufferedReader reader = Files.newBufferedReader(file, );
    }
}

