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
import java.io.*;
import java.util.ArrayList;


public class Homepage {
//    @FXML private Label labelName, labelNum;
    @FXML private Button class1, class2, class3, class4, accountButton;
    @FXML private VBox vboxTeam1, vboxTeam2;
    private DataAccSub user;


    @FXML
    public void initialize() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("DataColorSub.json"));
        Gson gson = new Gson();
        JsonArray array = gson.fromJson(reader, JsonArray.class);
        ArrayList<DataAccSub> allDataAccSub = new ArrayList<>();
        if (array != null) {
            for (int i = 0; i < array.size(); i++) {
                JsonElement element = array.get(i);
                DataAccSub dataAccSub = gson.fromJson(element, DataAccSub.class);
                if (LoginController.getUserPass().equals(dataAccSub.getUser())) {
                    user = dataAccSub;
                    break;
                }
            }
        }
        else {
            DataAccSub d = createDataAccSub(LoginController.getUserPass());
            allDataAccSub.add(d);
            String json = gson.toJson(allDataAccSub);
            PrintWriter printWriter = new PrintWriter(new FileWriter("DataColorSub.json"));
            printWriter.println(json);

            reader.close();
            printWriter.close();
            user = d;
        }
    }

    public DataAccSub createDataAccSub(String user) {
        DataAccSub dataAccSub = new DataAccSub(user , new PassColorSub(1), new PassColorSub(2), new PassColorSub(3), new PassColorSub(4),
                new PassColorSub(5), new PassColorSub(6), new PassColorSub(7), new PassColorSub(8), new PassColorSub(9),
                new PassColorSub(10), new PassColorSub(11), new PassColorSub(12), new PassColorSub(13), new PassColorSub(14),
                new PassColorSub(15), new PassColorSub(16), new PassColorSub(17), new PassColorSub(18), new PassColorSub(19),
                new PassColorSub(20), new PassColorSub(21), new PassColorSub(22), new PassColorSub(23), new PassColorSub(24),
                new PassColorSub(25), new PassColorSub(26), new PassColorSub(27), new PassColorSub(28), new PassColorSub(29),
                new PassColorSub(30), new PassColorSub(31), new PassColorSub(32), new PassColorSub(33), new PassColorSub(34),
                new PassColorSub(35), new PassColorSub(36), new PassColorSub(37), new PassColorSub(38), new PassColorSub(39),
                new PassColorSub(40), new PassColorSub(41), new PassColorSub(42), new PassColorSub(43), new PassColorSub(44),
                new PassColorSub(45), new PassColorSub(46));
        return dataAccSub;
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
            MenuButton button = new MenuButton(subject.getSubjectnumber() + "   " + subject.getSubjectname() + "   " +"(" +subject.getSubjectcredit() + ")");
            MenuItem item1 = new MenuItem("                                                  ลงเรียนแล้ว                                              ");
            MenuItem item2 = new MenuItem("                                                 ยังไม่ได้ลงเรียน                                              ");
            button.getItems().addAll(item1, item2);
            item1.setOnAction(e -> {
                button.setStyle("-fx-background-color: #006e0a;");
                button.setText(subject.getSubjectnumber() + "   " + subject.getSubjectname() + "   " +"(" +subject.getSubjectcredit() + ")" + "           ลงเรียนแล้ว");
            });
            item2.setOnAction(e -> {button.setText(subject.getSubjectnumber() + "   " + subject.getSubjectname() + "   " +"(" +subject.getSubjectcredit() + ")" + "           ยังไม่ได้ลงเรียน");
            button.setStyle("-fx-background-color: #6e0200;");
            });
            button.setStyle(
                            "-fx-background-color: rgba(43,40,41,0.9)");
            button.setPrefWidth(500);
            button.setBorder(new Border(new BorderStroke(subject.getColorSub(), BorderStrokeStyle.SOLID, new CornerRadii(25), new BorderWidths(3))));
            button.setTextFill(Color.LIGHTGREEN);
            vbox.getChildren().add(button);
            vbox.getChildren().add(new Text(""));
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

    @FXML public void onClickAccount(ActionEvent actionEvent) throws IOException {
        setColorButtonClass(accountButton,class1,class2,class3,class4);
        AlertBox.displayAccount("Account", LoginController.getUserPass(), LoginController.getStudentIdPass(), 400, 200, accountButton);
    }
}
