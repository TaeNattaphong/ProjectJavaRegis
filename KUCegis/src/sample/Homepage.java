package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import static javafx.scene.paint.Color.*;

public class Homepage {
    @FXML private Button class1, class2, class3, class4, accountButton, logoutBun;
    @FXML private VBox vboxTeam1, vboxTeam2;
    private HashMap<Integer, PassColorSub> to;

    public HashMap<Integer, PassColorSub> updateTrueFalse() throws FileNotFoundException {
        HashMap<Integer,PassColorSub> to = new HashMap<>();
        BufferedReader readerColor = new BufferedReader(new FileReader(LoginController.getStudentIdPass()+".json"));
        Gson gson = new Gson();
        JsonArray arrayColor = gson.fromJson(readerColor, JsonArray.class);
        JsonElement element = arrayColor.get(0);
        DataAccSub dataAccSub = gson.fromJson(element, DataAccSub.class);
        for(int ii=0 ;ii<=46;ii++)
        {
            to.put(dataAccSub.getSub(ii).getId(), dataAccSub.getSub(ii));
        }
        return to;
    }

    public void creatButtonSubject(BufferedReader reader, VBox vbox, int numClass) throws FileNotFoundException {
        System.out.println(LoginController.getStudentIdPass());
        BufferedReader readerColor = new BufferedReader(new FileReader(LoginController.getStudentIdPass()+".json"));
        Gson gson = new Gson();
        JsonArray arrayColor = gson.fromJson(readerColor, JsonArray.class);
        JsonElement element = arrayColor.get(0);
        DataAccSub dataAccSub = gson.fromJson(element, DataAccSub.class);

        to = updateTrueFalse();

        JsonArray array = gson.fromJson(reader, JsonArray.class);
        vbox.getChildren().clear();
        for(int i = 0 ; i < array.size() ; i++) {
            JsonElement element1 = array.get(i);
            Subject subject = gson.fromJson(element1, Subject.class);

            if (subject.getPassSub() != 0) {
                MenuButton button = new MenuButton(subject.getSubjectnumber() + "   " + subject.getSubjectname() + "   "
                        + "(" + subject.getSubjectcredit() + ")"  );
                MenuItem item1 = new MenuItem("                                                  ผ่าน                                              ");
                MenuItem item2 = new MenuItem("                                                 ไม่ผ่าน                                              ");
                button.getItems().addAll(item1, item2);
                if(to.get(subject.getContinueSub1()).isStudy().equals("false")){
                    item1.setVisible(false);
                    item2.setVisible(false);
                    try {
                        setColorInFile("gray", subject);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    button.setStyle("-fx-background-color: #979797;");
                    button.setAccessibleHelp(subject.getSubjectnumber() + "   " + subject.getSubjectname() + "   " + "(" + subject.getSubjectcredit() + ")");
                }else {
                    item1.setOnAction(e -> {
                        button.setStyle("-fx-background-color: #006e0a;");
                        button.setText(subject.getSubjectnumber() + "   " + subject.getSubjectname() + "   " + "(" + subject.getSubjectcredit() + ")" + "           ผ่าน");
                        try {
                            setColorInFile("green", subject);
                            if (numClass == 1) setClass11();
                            if (numClass == 2) setClass22();
                            if (numClass == 3) setClass33();
                            if (numClass == 4) setClass44();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                    });
                    item2.setOnAction(e -> {
                        button.setText(subject.getSubjectnumber() + "   " + subject.getSubjectname() + "   " + "(" + subject.getSubjectcredit() + ")" + "           ไม่ผ่าน");
                        button.setStyle("-fx-background-color: #6e0200;");
                        try {
                            setColorInFile("red", subject);
                            if (numClass == 1) setClass11();
                            if (numClass == 2) setClass22();
                            if (numClass == 3) setClass33();
                            if (numClass == 4) setClass44();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    });
                }

                if (dataAccSub.getSub(subject.getPassSub()).getColorSub().equals("green")) {
                    button.setStyle("-fx-background-color: #006e0a;");
                    button.setText(subject.getSubjectnumber() + "   " + subject.getSubjectname() + "   " + "(" + subject.getSubjectcredit() + ")" + "           ผ่านแล้ว");
                }
                if (dataAccSub.getSub(subject.getPassSub()).getColorSub().equals("red")) {
                    button.setStyle("-fx-background-color: #6e0200;");
                    button.setText(subject.getSubjectnumber() + "   " + subject.getSubjectname() + "   " + "(" + subject.getSubjectcredit() + ")" + "           ไม่ผ่าน");
                }
                if (dataAccSub.getSub(subject.getPassSub()).getColorSub().equals("gray")) {
                    button.setStyle("-fx-background-color: #4f4f4f");
                }
                button.setPrefWidth(500);     //subject.getColorSub()
//                button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(25), new BorderWidths(3))));
                button.setTextFill(LIGHTGREEN);
                vbox.getChildren().add(button);
//                vbox.getChildren().add(new Text(""));
            }
        }
    }


    public void setColorInFile(String color, Subject subject) throws IOException {
        BufferedReader readerColor = new BufferedReader(new FileReader(LoginController.getStudentIdPass()+".json"));

        Gson gsonColor = new GsonBuilder().setPrettyPrinting().create();
        JsonArray arrayColor = gsonColor.fromJson(readerColor, JsonArray.class);
        ArrayList<DataAccSub> all = new ArrayList<>();
        JsonElement element = arrayColor.get(0);
        DataAccSub dataAccSub = gsonColor.fromJson(element, DataAccSub.class);
        dataAccSub.getSub(subject.getPassSub()).setColorSub(color);
        if (color.equals("green")) {
            dataAccSub.getSub(subject.getPassSub()).setStudy("true");
        }else if(color.equals("red")){
            dataAccSub.getSub(subject.getPassSub()).setStudy("false");
        }else  if(color.equals("gray")){
            dataAccSub.getSub(subject.getPassSub()).setStudy("false");
            dataAccSub.getSub(subject.getPassSub()).setColorSub("gray");
        }

        all.add(dataAccSub);
        String json = gsonColor.toJson(all);
        PrintWriter printWriter = new PrintWriter(new FileWriter(LoginController.getStudentIdPass()+".json"));
        printWriter.println(json);
        printWriter.flush();
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
        creatButtonSubject(reader1, vboxTeam1, 1);
        creatButtonSubject(reader2, vboxTeam2, 1);
    }

    public void setClass11() throws FileNotFoundException {
        BufferedReader reader1 = new BufferedReader(new FileReader("SubjectPee1Team1.json"));
        BufferedReader reader2 = new BufferedReader(new FileReader("SubjectPee1Team2.json"));
        creatButtonSubject(reader1, vboxTeam1, 1);
        creatButtonSubject(reader2, vboxTeam2, 1);
    }

    @FXML
    public void setClass2(ActionEvent event) throws FileNotFoundException {
        setColorButtonClass(class2,class1,class3,class4,accountButton);
        BufferedReader reader1 = new BufferedReader(new FileReader("SubjectPee2Team1.json"));
        BufferedReader reader2 = new BufferedReader(new FileReader("SubjectPee2Team2.json"));
        creatButtonSubject(reader1, vboxTeam1, 2);
        creatButtonSubject(reader2, vboxTeam2, 2);
    }

    public void setClass22() throws FileNotFoundException {
        BufferedReader reader1 = new BufferedReader(new FileReader("SubjectPee2Team1.json"));
        BufferedReader reader2 = new BufferedReader(new FileReader("SubjectPee2Team2.json"));
        creatButtonSubject(reader1, vboxTeam1, 2);
        creatButtonSubject(reader2, vboxTeam2, 2);
    }

    @FXML
    public void setClass3(ActionEvent event) throws FileNotFoundException {
        setColorButtonClass(class3,class1,class2,class4,accountButton);
        BufferedReader reader1 = new BufferedReader(new FileReader("SubjectPee3Team1.json"));
        BufferedReader reader2 = new BufferedReader(new FileReader("SubjectPee3Team2.json"));
        creatButtonSubject(reader1, vboxTeam1, 3);
        creatButtonSubject(reader2, vboxTeam2, 3);
    }
    public void setClass33() throws FileNotFoundException {
        BufferedReader reader1 = new BufferedReader(new FileReader("SubjectPee3Team1.json"));
        BufferedReader reader2 = new BufferedReader(new FileReader("SubjectPee3Team2.json"));
        creatButtonSubject(reader1, vboxTeam1, 3);
        creatButtonSubject(reader2, vboxTeam2, 3);
    }

    @FXML
    public void setClass4(ActionEvent event) throws FileNotFoundException {
        setColorButtonClass(class4,class1,class2,class3,accountButton);
        BufferedReader reader1 = new BufferedReader(new FileReader("SubjectPee4Team1.json"));
        BufferedReader reader2 = new BufferedReader(new FileReader("SubjectPee4Team2.json"));
        creatButtonSubject(reader1, vboxTeam1, 4);
        creatButtonSubject(reader2, vboxTeam2, 4);
    }
    public void setClass44() throws FileNotFoundException {
        BufferedReader reader1 = new BufferedReader(new FileReader("SubjectPee4Team1.json"));
        BufferedReader reader2 = new BufferedReader(new FileReader("SubjectPee4Team2.json"));
        creatButtonSubject(reader1, vboxTeam1, 4);
        creatButtonSubject(reader2, vboxTeam2, 4);
    }


    @FXML public void onClickAccount(ActionEvent actionEvent) throws IOException {
        setColorButtonClass(accountButton,class1,class2,class3,class4);
        AlertBox.displayAccount("Account", LoginController.getUserPass(), LoginController.getStudentIdPass(), 400, 200, accountButton);
    }
}
