package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML private Button registerButton;

    public void changeRegisClick(ActionEvent actionEvent) throws IOException {
        Parent regis = FXMLLoader.load(getClass().getResource("regis.fxml"));
        Scene regisView = new Scene(regis);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(regisView);
        window.show();
    }
}

