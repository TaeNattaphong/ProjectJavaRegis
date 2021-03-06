package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import static javafx.scene.paint.Color.*;

public class Homepage {
    @FXML private Button class1, class2, class3, class4, accountButton, logoutBun;
    @FXML private VBox vboxTeam1, vboxTeam2;
    private File fileData;
    private HashMap<Integer, PassColorSub> to;
    private ArrayList<Subject> sub;

    public HashMap<Integer, PassColorSub> updateTrueFalse() throws FileNotFoundException {
        HashMap<Integer,PassColorSub> to = new HashMap<>();
        BufferedReader readerColor = new BufferedReader(new FileReader(fileData));
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
    ArrayList<Subject> sub() throws FileNotFoundException {
        sub = new ArrayList<>();
        BufferedReader reader1 = new BufferedReader(new FileReader("SubjectPee1Team1.json"));
        BufferedReader reader2 = new BufferedReader(new FileReader("SubjectPee1Team2.json"));
        BufferedReader reader3 = new BufferedReader(new FileReader("SubjectPee2Team1.json"));
        BufferedReader reader4 = new BufferedReader(new FileReader("SubjectPee2Team2.json"));
        BufferedReader reader5 = new BufferedReader(new FileReader("SubjectPee3Team1.json"));
        BufferedReader reader6 = new BufferedReader(new FileReader("SubjectPee3Team2.json"));
        BufferedReader reader7 = new BufferedReader(new FileReader("SubjectPee4Team1.json"));
        BufferedReader reader8 = new BufferedReader(new FileReader("SubjectPee4Team2.json"));

        Gson gson = new Gson();
        JsonArray array1 = gson.fromJson(reader1, JsonArray.class);
        JsonArray array2 = gson.fromJson(reader2, JsonArray.class);
        JsonArray array3 = gson.fromJson(reader3, JsonArray.class);
        JsonArray array4 = gson.fromJson(reader4, JsonArray.class);
        JsonArray array5 = gson.fromJson(reader5, JsonArray.class);
        JsonArray array6 = gson.fromJson(reader6, JsonArray.class);
        JsonArray array7 = gson.fromJson(reader7, JsonArray.class);
        JsonArray array8 = gson.fromJson(reader8, JsonArray.class);
        for(int i = 0 ; i < array1.size() ; i++) {
            JsonElement element1 = array1.get(i);
            Subject subject = gson.fromJson(element1, Subject.class);
            sub.add(subject);
        }
        for(int i = 0 ; i < array2.size() ; i++) {
            JsonElement element1 = array2.get(i);
            Subject subject = gson.fromJson(element1, Subject.class);
            sub.add(subject);
        }
        for(int i = 0 ; i < array3.size() ; i++) {
            JsonElement element1 = array3.get(i);
            Subject subject = gson.fromJson(element1, Subject.class);
            sub.add(subject);
        }
        for(int i = 0 ; i < array4.size() ; i++) {
            JsonElement element1 = array4.get(i);
            Subject subject = gson.fromJson(element1, Subject.class);
            sub.add(subject);
        }
        for(int i = 0 ; i < array5.size() ; i++) {
            JsonElement element1 = array5.get(i);
            Subject subject = gson.fromJson(element1, Subject.class);
            sub.add(subject);
        }
        for(int i = 0 ; i < array6.size() ; i++) {
            JsonElement element1 = array6.get(i);
            Subject subject = gson.fromJson(element1, Subject.class);
            sub.add(subject);
        }
        for(int i = 0 ; i < array7.size() ; i++) {
            JsonElement element1 = array7.get(i);
            Subject subject = gson.fromJson(element1, Subject.class);
            sub.add(subject);
        }
        for(int i = 0 ; i < array8.size() ; i++) {
            JsonElement element1 = array8.get(i);
            Subject subject = gson.fromJson(element1, Subject.class);
            sub.add(subject);
        }
        return sub;
    }
    MenuButton  makeButton(Subject subject,DataAccSub dataAccSub){
        MenuButton button ;
        DropShadow shadow = new DropShadow();
            Text text = new Text(subject.getSubjectnumber() + "   " + subject.getSubjectname() +
                    "   (" + subject.getSubjectcredit() + ")    "  );
            Text text1 = new Text();
            button = new MenuButton(text.getText());
            MenuButton finalButton1 = button;
            button.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
                if(subject.getColorSub().equals(Color.RED)){
                    text1.setText("                                                              ยากมาก");
                    button.setStyle("-fx-background-color: #db1515;");
                }if (subject.getColorSub().equals(Color.ORANGE)){
                    text1.setText("                                                              ปานกลาง");
                    button.setStyle("-fx-background-color: #00d4ff;");
                }if(subject.getColorSub().equals(Color.GREEN)){
                    text1.setText("                                                              ง่ายๆ");
                    button.setStyle("-fx-background-color: #94ef39;");
                }
                finalButton1.setEffect(shadow);
                text1.setFont(Font.font(80));
                button.setText(text1.getText());
                button.setTextFill(BLACK);
            });
            MenuButton finalButton = button;
            button.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        finalButton.setEffect(null);
                        if (dataAccSub.getSub(subject.getPassSub()).getColorSub().equals("green")) {
                            button.setStyle("-fx-background-color: #006e0a;");
                            button.setText(text.getText() + "ผ่านแล้ว");

                        }if(dataAccSub.getSub(subject.getPassSub()).getColorSub().equals("red")){
                            button.setStyle("-fx-background-color: #6e0200;");
                            button.setText(text.getText() + "ยังไม่ผ่าน");
                        }if (dataAccSub.getSub(subject.getPassSub()).getColorSub().equals("gray")) {
                            button.setStyle("-fx-background-color: #4f4f4f");
                            button.setText(text.getText());
                        }
                        button.setTextFill(LIGHTGREEN);

                    }
                });
            return  button;
    }
    public void createButtonSubject(BufferedReader reader, VBox vbox, int numClass) throws FileNotFoundException {
        BufferedReader readerColor = new BufferedReader(new FileReader(fileData));
        Gson gson = new Gson();
        JsonArray arrayColor = gson.fromJson(readerColor, JsonArray.class);
        JsonElement element = arrayColor.get(0);
        DataAccSub dataAccSub = gson.fromJson(element, DataAccSub.class);
        to = updateTrueFalse();
        Circle circle = new Circle();
        circle.setFill(Color.RED);
        JsonArray array = gson.fromJson(reader, JsonArray.class);
        vbox.getChildren().clear();

        for(int i = 0 ; i < array.size() ; i++) {
            JsonElement element1 = array.get(i);
            Subject subject = gson.fromJson(element1, Subject.class);
            if (subject.getPassSub() != 0) {
                MenuButton button = makeButton(subject,dataAccSub);
                MenuItem item1 = new MenuItem("                                                  ผ่าน                                              ");
                MenuItem item2 = new MenuItem("                                                 ไม่ผ่าน                                              ");
                button.getItems().addAll(item1, item2);

                if(to.get(subject.getContinueSub1()).isStudy().equals("false")){
                    ArrayList<Subject> sub  = sub();
                    item1.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Information Dialog");
                            alert.setHeaderText(null);
                            alert.setContentText("วิชา: "+"   "+sub.get(subject.getContinueSub1()).getSubjectname()+"  ยังไม่ผ่าน");
                            alert.showAndWait();
                        }
                    });
                    item2.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Information Dialog");
                            alert.setHeaderText(null);
                            alert.setContentText("วิชา: "+"   "+sub.get(subject.getContinueSub1()).getSubjectname()+"  ยังไม่ผ่าน");
                            alert.showAndWait();
                        }
                    });

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
                        button.setText(subject.getSubjectnumber() + "   " + subject.getSubjectname() + "   " + "(" + subject.getSubjectcredit() + ")" + "           ผ่านแล้ว");
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
                    button.setText(subject.getSubjectnumber() + "   " + subject.getSubjectname() + "   " + "(" + subject.getSubjectcredit() + ")" + "           ยังไม่ผ่าน");
                }
                if (dataAccSub.getSub(subject.getPassSub()).getColorSub().equals("gray")) {
                    button.setStyle("-fx-background-color: #4f4f4f");
                }
                button.setPrefWidth(520);
              button.setTextFill(LIGHTGREEN);
                vbox.getChildren().add(button);
            }
        }
    }


    public void setColorInFile(String color, Subject subject) throws IOException {
        BufferedReader readerColor = new BufferedReader(new FileReader(fileData));

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
        PrintWriter printWriter = new PrintWriter(new FileWriter(fileData));
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
        createButtonSubject(reader1, vboxTeam1, 1);
        createButtonSubject(reader2, vboxTeam2, 1);
    }

    public void setClass11() throws FileNotFoundException {
        BufferedReader reader1 = new BufferedReader(new FileReader("SubjectPee1Team1.json"));
        BufferedReader reader2 = new BufferedReader(new FileReader("SubjectPee1Team2.json"));
        createButtonSubject(reader1, vboxTeam1, 1);
        createButtonSubject(reader2, vboxTeam2, 1);
    }

    @FXML
    public void setClass2(ActionEvent event) throws FileNotFoundException {
        setColorButtonClass(class2,class1,class3,class4,accountButton);
        BufferedReader reader1 = new BufferedReader(new FileReader("SubjectPee2Team1.json"));
        BufferedReader reader2 = new BufferedReader(new FileReader("SubjectPee2Team2.json"));
        createButtonSubject(reader1, vboxTeam1, 2);
        createButtonSubject(reader2, vboxTeam2, 2);
    }

    public void setClass22() throws FileNotFoundException {
        BufferedReader reader1 = new BufferedReader(new FileReader("SubjectPee2Team1.json"));
        BufferedReader reader2 = new BufferedReader(new FileReader("SubjectPee2Team2.json"));
        createButtonSubject(reader1, vboxTeam1, 2);
        createButtonSubject(reader2, vboxTeam2, 2);
    }

    @FXML
    public void setClass3(ActionEvent event) throws FileNotFoundException {
        setColorButtonClass(class3,class1,class2,class4,accountButton);
        BufferedReader reader1 = new BufferedReader(new FileReader("SubjectPee3Team1.json"));
        BufferedReader reader2 = new BufferedReader(new FileReader("SubjectPee3Team2.json"));
        createButtonSubject(reader1, vboxTeam1, 3);
        createButtonSubject(reader2, vboxTeam2, 3);
    }
    public void setClass33() throws FileNotFoundException {
        BufferedReader reader1 = new BufferedReader(new FileReader("SubjectPee3Team1.json"));
        BufferedReader reader2 = new BufferedReader(new FileReader("SubjectPee3Team2.json"));
        createButtonSubject(reader1, vboxTeam1, 3);
        createButtonSubject(reader2, vboxTeam2, 3);
    }

    @FXML
    public void setClass4(ActionEvent event) throws FileNotFoundException {
        setColorButtonClass(class4,class1,class2,class3,accountButton);
        BufferedReader reader1 = new BufferedReader(new FileReader("SubjectPee4Team1.json"));
        BufferedReader reader2 = new BufferedReader(new FileReader("SubjectPee4Team2.json"));
        createButtonSubject(reader1, vboxTeam1, 4);
        createButtonSubject(reader2, vboxTeam2, 4);
    }
    public void setClass44() throws FileNotFoundException {
        BufferedReader reader1 = new BufferedReader(new FileReader("SubjectPee4Team1.json"));
        BufferedReader reader2 = new BufferedReader(new FileReader("SubjectPee4Team2.json"));
        createButtonSubject(reader1, vboxTeam1, 4);
        createButtonSubject(reader2, vboxTeam2, 4);
    }


    @FXML public void onClickAccount(ActionEvent actionEvent) throws IOException {
        setColorButtonClass(accountButton,class1,class2,class3,class4);
        AlertBox.displayAccount("Account", LoginController.getUserPass(), LoginController.getStudentIdPass(), 500, 250, accountButton);
    }

    public void setFileData(File fileData) {
        this.fileData = fileData;
    }
}
