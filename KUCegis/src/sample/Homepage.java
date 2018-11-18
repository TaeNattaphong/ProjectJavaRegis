package sample;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Homepage {
    @FXML private Label LabelName;
    @FXML private SplitMenuButton class0;
    @FXML private MenuItem class1, class2, class3, class4;
    @FXML private VBox vbox;

    @FXML
    public void initialize() {

    }


    @FXML
    public void handdleButton(ActionEvent event) {
        LabelName.setText("Hello");
    }

    @FXML
    public void setClass1(ActionEvent event) throws FileNotFoundException {
        class0.setText(class1.getText());
        BufferedReader reader = new BufferedReader(new FileReader("SubjectPee1Team1.json"));
        Gson gson = new Gson();
        JsonArray array = gson.fromJson(reader, JsonArray.class);
        for(int i = 0 ; i < array.size() ; i++){
            JsonElement element = array.get(i);
            Subject subject = gson.fromJson(element, Subject.class);
            Button button = new Button(subject.getSubjectnumber() + "   " + subject.getSubjectname() + "   " + subject.getSubjectcredit());
            button.setStyle(
                    "-fx-background-radius: 25; " +
                            "-fx-background-color: #979797");
            vbox.getChildren().add(new Text(""));
            vbox.getChildren().add(button);
        }

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
