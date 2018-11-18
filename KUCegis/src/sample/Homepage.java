package sample;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Homepage {
//    @FXML private Label labelName, labelNum;
    @FXML private Button class1, class2, class3, class4, accountButton;
    @FXML private VBox vboxTeam1, vboxTeam2;

    @FXML
    public void initialize() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader("Account.json"));
        JsonArray array = gson.fromJson(reader, JsonArray.class);
        JsonElement element = array.get(0);
        Account account = gson.fromJson(element, Account.class);
//        labelName.setText(account.getName());
//        labelNum.setText(account.getStudentId());
    }

    public void setColorButtonClass(Button aClass, Button bClass, Button cClass, Button dClass, Button eClass) {
        aClass.setStyle("-fx-background-color: #373737;");
        bClass.setStyle("-fx-background-color: #404040;");
        cClass.setStyle("-fx-background-color: #404040;");
        dClass.setStyle("-fx-background-color: #404040;");
        eClass.setStyle("-fx-background-color: #404040;");
    }


    public void creatButtonSubject(BufferedReader reader, VBox vbox) {
        Gson gson = new Gson();
        JsonArray array = gson.fromJson(reader, JsonArray.class);
        vbox.getChildren().clear();
        for(int i = 0 ; i < array.size() ; i++){
            JsonElement element1 = array.get(i);
            Subject subject = gson.fromJson(element1, Subject.class);
            Button button = new Button(subject.getSubjectnumber() + "   " + subject.getSubjectname() + "   " + subject.getSubjectcredit());
            button.setStyle(
                    "-fx-background-radius: 25; " +
                            "-fx-background-color: #979797");
            button.setPrefSize(500, 30);
            button.setBorder(new Border(new BorderStroke(Color.web("#345232"), BorderStrokeStyle.SOLID, new CornerRadii(25), new BorderWidths(3))));
            button.setTextFill(Color.WHITE);
            vbox.getChildren().add(new Text(""));
            vbox.getChildren().add(button);
        }
    }

    @FXML
    public void setClass1(ActionEvent event) throws FileNotFoundException {
        setColorButtonClass(class1,class2,class3,class4,accountButton);
        BufferedReader reader1 = new BufferedReader(new FileReader("SubjectPee1Team1.json"));
        BufferedReader reader2 = new BufferedReader(new FileReader("SubjectPee1Team2.json"));
        creatButtonSubject(reader1, vboxTeam1);
        creatButtonSubject(reader2, vboxTeam2);
    }

    @FXML
    public void setClass2(ActionEvent event) throws FileNotFoundException {
        setColorButtonClass(class2,class1,class3,class4,accountButton);
        BufferedReader reader1 = new BufferedReader(new FileReader("SubjectPee2Team1.json"));
        BufferedReader reader2 = new BufferedReader(new FileReader("SubjectPee2Team2.json"));
        creatButtonSubject(reader1, vboxTeam1);
        creatButtonSubject(reader2, vboxTeam2);
    }

    @FXML
    public void setClass3(ActionEvent event) throws FileNotFoundException {
        setColorButtonClass(class3,class1,class2,class4,accountButton);
        BufferedReader reader1 = new BufferedReader(new FileReader("SubjectPee3Team1.json"));
        BufferedReader reader2 = new BufferedReader(new FileReader("SubjectPee3Team2.json"));
        creatButtonSubject(reader1, vboxTeam1);
        creatButtonSubject(reader2, vboxTeam2);
    }
    @FXML
    public void setClass4(ActionEvent event) throws FileNotFoundException {
        setColorButtonClass(class4,class1,class2,class3,accountButton);
        BufferedReader reader1 = new BufferedReader(new FileReader("SubjectPee4Team1.json"));
        BufferedReader reader2 = new BufferedReader(new FileReader("SubjectPee4Team2.json"));
        creatButtonSubject(reader1, vboxTeam1);
        creatButtonSubject(reader2, vboxTeam2);
    }
}
