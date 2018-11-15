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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;

public class LoginController {
    @FXML private Button registerButton, login, ok;
    @FXML private TextField userLogin;
    @FXML private PasswordField passLogin;
    @FXML private TextField name, accountName;
    @FXML private PasswordField studentId, id, reid;
    @FXML private RadioButton male, female;


    public void changeRegisClick(ActionEvent actionEvent) throws IOException {
        Parent regis = FXMLLoader.load(getClass().getResource("regisV2.fxml"));
        Scene regisView = new Scene(regis, 578, 263);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(regisView);
        window.show();
    }

    public void loginIdPass(ActionEvent actionEvent) throws IOException {
        String user = userLogin.getText();
        String pass = passLogin.getText();
        userLogin.setText("");
        passLogin.setText("");
        System.out.println(user + pass);

        boolean isUser = false;
        BufferedReader reader = new BufferedReader(new FileReader("Account.json"));
        Gson gson = new Gson();
        JsonArray array = gson.fromJson(reader, JsonArray.class);

        for (int i = 0 ; i < array.size() ; i++) {
            JsonElement element = array.get(i);
            Account account = gson.fromJson(element, Account.class);

            if (user.equals(account.getAccountName()) && pass.equals(account.getPass())) isUser = true;
        }
        reader.close();

        if (isUser) {
            Parent homepage = FXMLLoader.load(getClass().getResource("homepage.fxml"));
            Scene homepageView = new Scene(homepage);
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
        for (int i = 0; i < array.size(); i++) {
            JsonElement element = array.get(i);
            Account account = gson.fromJson(element, Account.class);
            String name = account.getName();
            String studentId = account.getStudentId();
            String gender = account.getGender();
            String accountName = account.getAccountName();
            String pass = account.getPass();

            Account a = new Account(name, studentId, gender, accountName, pass);
            allAccount.add(a);
        }

        String names = name.getText();
        String accountNames = accountName.getText();
        String studentIds = studentId.getText();
        String ids = id.getText();
        String reids = reid.getText();
        String sex = "male";
//        if (male.isArmed() && female.isCache()) sex = "male";
//        else if (male.isCache() && female.isArmed()) sex = "female";
//        else throw new IllegalArgumentException("เลือกเพศ");
        Account account = new Account(names, studentIds, sex, accountNames, ids);
        allAccount.add(account);
        String json = gson.toJson(allAccount);
        PrintWriter printWriter = new PrintWriter(new FileWriter("Account.json"));
        printWriter.println(json);

        reader.close();
        printWriter.close();

        Parent regis = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene regisView = new Scene(regis, 330, 310);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(regisView);
        window.show();
    }
}