package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class Homepage {
    @FXML
    private  Label LabelName;

    @FXML
    public void handdleButton(ActionEvent event){
        LabelName.setText("Hello");
    }

    @FXML private VBox addBottonVbox;

    @FXML
    public void initialize() {
        for (int i=0; i<100; i++) {
            addBottonVbox.getChildren().add(new Button(i + ""));
        }
    }
}
