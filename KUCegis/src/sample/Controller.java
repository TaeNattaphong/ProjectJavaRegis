package sample;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;

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

    public void loginIdPass(ActionEvent actionEvent) throws IOException {
        String user = userLogin.getText();
        String pass = passLogin.getText();
        userLogin.setText("");
        passLogin.setText("");
        System.out.println(user + pass);

        boolean isUser = false;
        BufferedReader reader = new BufferedReader(new FileReader("Data.json"));
        Gson gson = new Gson();
        JsonArray array = gson.fromJson(reader, JsonArray.class);

        for (int i = 0 ; i < array.size() ; i++) {
            JsonElement element = array.get(i);
            Account account = gson.fromJson(element, Account.class);

            if (user.equals(account.getAccountName()) && pass.equals(account.getPass())) isUser = true;
        }
        reader.close();

        if (isUser) {
            Parent homepage = FXMLLoader.load(getClass().getResource("homepage.fxml"));
            Scene homepageView = new Scene(homepage);
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.setScene(homepageView);
            window.show();
        }
    }
}

