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
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import static javafx.scene.paint.Color.*;

public class Homepage {
    @FXML private Button class1, class2, class3, class4, accountButton, logoutBun;
    @FXML private VBox vboxTeam1, vboxTeam2;

    public void creatButtonSubject(BufferedReader reader, VBox vbox) throws FileNotFoundException {
        Gson gson = new Gson();
        JsonArray array = gson.fromJson(reader, JsonArray.class);
        vbox.getChildren().clear();
        for(int i = 0 ; i < array.size() ; i++) {
            JsonElement element1 = array.get(i);
            Subject subject = gson.fromJson(element1, Subject.class);
            MenuButton button = new MenuButton(subject.getSubjectnumber() + "   " + subject.getSubjectname() + "   " +"(" +subject.getSubjectcredit() + ")");
            MenuItem item1 = new MenuItem("                                                  ลงเรียนแล้ว                                              ");
            MenuItem item2 = new MenuItem("                                                 ยังไม่ได้ลงเรียน                                              ");
            button.getItems().addAll(item1, item2);
            item1.setOnAction(e -> {
                button.setStyle("-fx-background-color: #006e0a;");
                button.setText(subject.getSubjectnumber() + "   " + subject.getSubjectname() + "   " +"(" +subject.getSubjectcredit() + ")" + "           ลงเรียนแล้ว");
                try {
                    setColorInFile("green", subject.getPassSub());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
            item2.setOnAction(e -> {button.setText(subject.getSubjectnumber() + "   " + subject.getSubjectname() + "   " +"(" +subject.getSubjectcredit() + ")" + "           ยังไม่ได้ลงเรียน");
            button.setStyle("-fx-background-color: #6e0200;");
                try {
                    setColorInFile("red", subject.getPassSub());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });

            BufferedReader readerColor = new BufferedReader(new FileReader("DataColorSub.json"));
            Gson gsonColor = new Gson();
            JsonArray arrayColor = gsonColor.fromJson(readerColor, JsonArray.class);
            for (int ii = 0; ii < arrayColor.size(); ii++) {
                JsonElement element = arrayColor.get(ii);
                DataAccSub dataAccSub = gsonColor.fromJson(element, DataAccSub.class);
                if (LoginController.getUserPass().equals(dataAccSub.getUser())) {
                    if (dataAccSub.getSub(subject.getPassSub()).getColorSub().equals("green")) {
                        button.setStyle("-fx-background-color: #006e0a;");
                        button.setText(subject.getSubjectnumber() + "   " + subject.getSubjectname() + "   " +"(" +subject.getSubjectcredit() + ")" + "           ลงเรียนแล้ว");
                    }
                    if (dataAccSub.getSub(subject.getPassSub()).getColorSub().equals("red")) {
                        button.setStyle("-fx-background-color: #6e0200;");
                        button.setText(subject.getSubjectnumber() + "   " + subject.getSubjectname() + "   " +"(" +subject.getSubjectcredit() + ")" + "           ยังไม่ได้ลงเรียน");
                    }
                    if (dataAccSub.getSub(subject.getPassSub()).getColorSub().equals("gray")) {
                        button.setStyle("-fx-background-color: #4f4f4f");
                    }
                }
            }
            button.setPrefWidth(500);
            button.setBorder(new Border(new BorderStroke(subject.getColorSub(), BorderStrokeStyle.SOLID, new CornerRadii(25), new BorderWidths(3))));
            button.setTextFill(LIGHTGREEN);
            vbox.getChildren().add(button);
            vbox.getChildren().add(new Text(""));
        }
    }


    public void setColorInFile(String color, int passSub) throws IOException {
        BufferedReader readerColor = new BufferedReader(new FileReader("DataColorSub.json"));
        Gson gsonColor = new Gson();
        JsonArray arrayColor = gsonColor.fromJson(readerColor, JsonArray.class);
        ArrayList<DataAccSub> all = new ArrayList<>();
        for (int i = 0; i < arrayColor.size(); i++) {
            JsonElement element = arrayColor.get(i);
            DataAccSub dataAccSub = gsonColor.fromJson(element, DataAccSub.class);
            if (LoginController.getUserPass().equals(dataAccSub.getUser())) {
                dataAccSub.getSub(passSub).setColorSub(color);
                if (color.equals("green")) dataAccSub.getSub(passSub).setStudy(true);
            }all.add(dataAccSub);
        }
        String json = gsonColor.toJson(all);
        PrintWriter printWriter = new PrintWriter(new FileWriter("DataColorSub.json"));
        printWriter.println(json);

        readerColor.close();
        printWriter.close();
    }

    public void onCilckLogout(ActionEvent actionEvent) throws IOException {
        Parent regis = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene regisView = new Scene(regis, 330, 310);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(regisView);
        window.show();
    }

    public void setColorButtonClass(Button aClass, Button bClass, Button cClass, Button dClass, Button eClass) {
        aClass.setStyle("-fx-background-color: #373737;");
        bClass.setStyle("-fx-background-color: #404040;");
        cClass.setStyle("-fx-background-color: #404040;");
        dClass.setStyle("-fx-background-color: #404040;");
        eClass.setStyle("-fx-background-color: #404040;");
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
