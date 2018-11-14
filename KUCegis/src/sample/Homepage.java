package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;


public class Homepage {
    @FXML
    private Label LabelName;
    @FXML
    private SplitMenuButton class0;
    @FXML
    private MenuItem class1, class2, class3, class4;


    @FXML
    public void initialize() {

    }

    @FXML
    public void handdleButton(ActionEvent event) {
        LabelName.setText("Hello");
    }

    @FXML
    public void setClass1(ActionEvent event) {
        class0.setText(class1.getText());
    }

    @FXML
    public void setClass2(ActionEvent event) {
        class0.setText(class2.getText());
    }

    @FXML
    public void setClass3(ActionEvent event) {
        class0.setText(class3.getText());
    }
    @FXML
    public void setClass4(ActionEvent event) {
        class0.setText(class4.getText());
    }
}
