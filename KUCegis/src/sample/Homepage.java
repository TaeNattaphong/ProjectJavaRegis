package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;



public class Homepage {
    @FXML
    private  Label LabelName;

    @FXML
    public void handdleButton(ActionEvent event){
        LabelName.setText("Hello");
    }
}
