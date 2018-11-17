package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class Homepage {
    @FXML
    private Label LabelName;
    @FXML
    private SplitMenuButton class0;
    @FXML
    private MenuItem class1, class2, class3, class4;
    @FXML
    private AnchorPane term1;
    @FXML
    private VBox vbox;
    @FXML private  Pane  pane;



    @FXML
    public void initialize() {


        for(int i=0 ; i<10; i++){
         vbox.getChildren().add(new Button("text   " + i));
         vbox.getChildren().add(new Text(""));
        }

//        term1.getChildren().set(number.setText("001"));
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
