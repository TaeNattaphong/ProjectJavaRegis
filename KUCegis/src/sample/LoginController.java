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
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;

public class LoginController {
    @FXML private Button registerButton, login, ok;
    @FXML private TextField userLogin;
    @FXML private PasswordField passLogin;
    @FXML private TextField name, accountName;
    @FXML private TextField studentId;
    @FXML private PasswordField  pass;
    @FXML private MenuItem male, female;
    @FXML private MenuButton gender;
    private static String UserPass;
    private static String studentIdPass;

    public void changeRegisClick(ActionEvent actionEvent) throws IOException {
        Parent regis = FXMLLoader.load(getClass().getResource("regisV2.fxml"));
        Scene regisView = new Scene(regis, 588, 220);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(regisView);
        window.show();
    }

    public void loginIdPass(ActionEvent actionEvent) throws IOException {
        String user = userLogin.getText();
        String pass = passLogin.getText();
        userLogin.setText("");
        passLogin.setText("");
        setUserPass(user +"\t"+ pass);


        boolean isUser = false;
        BufferedReader reader = new BufferedReader(new FileReader("Account.json"));
        Gson gson = new Gson();
        JsonArray array = gson.fromJson(reader, JsonArray.class);

        for (int i = 0 ; i < array.size() ; i++) {
            JsonElement element = array.get(i);
            Account account = gson.fromJson(element, Account.class);

            if (user.equals(account.getAccountName()) && pass.equals(account.getPass())) {
                studentIdPass =  account.getStudentId() ;
                isUser = true;
            }
        }
        reader.close();

        if (isUser) {
            Parent homepage = FXMLLoader.load(getClass().getResource("homepage.fxml"));
            Scene homepageView = new Scene(homepage, 693, 470);
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.setScene(homepageView);
            window.show();
        }
    }

    public void onClickRegisOk(ActionEvent actionEvent) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Account.json"));
        Gson gson = new Gson();
        JsonArray array = gson.fromJson(reader, JsonArray.class);
        ArrayList<Account> allAccount = new ArrayList<>();

        if (array == null) {
            Account account = new Account(name.getText(), studentId.getText(), gender.getText(), accountName.getText(), pass.getText());

            allAccount.add(account);

            String json = gson.toJson(allAccount);
            PrintWriter printWriter = new PrintWriter(new FileWriter("Account.json"));
            printWriter.println(json);

            reader.close();
            printWriter.close();

            ArrayList<DataAccSub> dataAccSubs = new ArrayList<>();
            dataAccSubs.add(createDataAccSub(name.getText()));
            Gson gsonColor = new Gson();
            String jsonColor = gsonColor.toJson(dataAccSubs);

            File file = new File(studentId.getText()+".json");
            FileWriter file1 = new FileWriter(file);
            PrintWriter printWriterColor = new PrintWriter(file1);
            printWriterColor.println(jsonColor);
            printWriterColor.flush();
            file.createNewFile();
            printWriterColor.close();
        } else{
            for (int i = 0; i < array.size(); i++) {
                JsonElement element = array.get(i);
                Account account = gson.fromJson(element, Account.class);
                allAccount.add(account);
            }
            Account a = new Account(name.getText(), studentId.getText(), gender.getText(), accountName.getText(), pass.getText());
            allAccount.add(a);
            String json = gson.toJson(allAccount);
            PrintWriter printWriter = new PrintWriter(new FileWriter("Account.json"));
            printWriter.println(json);
            reader.close();
            printWriter.close();

            ArrayList<DataAccSub> dataAccSubs = new ArrayList<>();
            dataAccSubs.add(createDataAccSub(name.getText()));
            Gson gsonColor = new Gson();
            String jsonColor = gsonColor.toJson(dataAccSubs);

            File file = new File(studentId.getText()+".json");
            FileWriter file1 = new FileWriter(file);
            PrintWriter printWriterColor = new PrintWriter(file1);
            printWriterColor.println(jsonColor);
            printWriterColor.flush();
            file.createNewFile();
            printWriterColor.close();

        }

        Parent regis = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene regisView = new Scene(regis, 330, 310);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(regisView);
        window.show();
    }



    public static String getUserPass() {
        return UserPass;
    }

    private static void setUserPass(String userPass) {
        UserPass = userPass;
    }

    public static String getStudentIdPass() {
        return studentIdPass;
    }

    public void setGenderM(ActionEvent actionEvent) {
        gender.setText(male.getText());
    }

    public void setGenderF(ActionEvent actionEvent) {
        gender.setText(female.getText());
    }

    public DataAccSub createDataAccSub(String user) {
        DataAccSub dataAccSub = new DataAccSub(user ,new PassColorSub(0), new PassColorSub(1), new PassColorSub(2), new PassColorSub(3), new PassColorSub(4),
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
}