package sample;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.*;
import java.net.URISyntaxException;
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
    private File fileAccount;
    private File fileData;
    private String pathAccount;
    private String pathData;

    public LoginController() throws URISyntaxException {
        String jarDirPath = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();
        this.fileAccount = new File(jarDirPath+"\\"+"Account.json");
        this.pathAccount = fileAccount.toURI().toString();
        this.pathData = jarDirPath+"\\";
    }

    public String getPathData() {
        return pathData;
    }

    public void changeRegisClick(ActionEvent actionEvent) throws IOException {
        Parent regis = FXMLLoader.load(getClass().getResource("regisV2.fxml"));
        Scene regisView = new Scene(regis, 588, 220);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(regisView);
        window.show();
    }

    @FXML
    private void loginIdPass(ActionEvent actionEvent) throws IOException {
        String user = userLogin.getText();
        String pass = passLogin.getText();
        userLogin.setText("");
        passLogin.setText("");

        if (user.equals("") || pass.equals("")) AlertBox.display("WARNING!!!", "ใส่ข้อมูลให้ครบถ้วน!!!", 300, 250);
        else {
            boolean isUser = false;
            if (!fileAccount.exists()) {
                try {
                    fileAccount.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            BufferedReader reader = new BufferedReader(new FileReader(fileAccount));
            Gson gson = new Gson();
            JsonArray array = gson.fromJson(reader, JsonArray.class);

            try {
                for (int i = 0 ; i < array.size() ; i++) {
                    JsonElement element = array.get(i);
                    Account account = gson.fromJson(element, Account.class);

                    if (user.equals(account.getAccountName()) && pass.equals(account.getPass())) {
                        studentIdPass =  account.getStudentId() ;
                        UserPass = account.getName();
                        isUser = true;
                    }
                }
                reader.close();
            } catch (NullPointerException e) {
                AlertBox.display("WARNING!!!", "ยังไม่มีข้อมูล กรุณาลงทะเบียน!!!", 300, 250);
            }

            if (isUser) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
                Parent homepage = loader.load();
                Scene homepageView = new Scene(homepage, 693, 470);
                Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

                Homepage controller = loader.getController();
                controller.setFileData(new File(pathData + studentIdPass +".json"));
                window.setScene(homepageView);
                window.show();
            } else {
                try {
                    array.size();
                    AlertBox.display("WARNING!!!", "User || Pass ไม่ถูกต้อง!!!", 300, 250);

                } catch (NullPointerException e) {
                    AlertBox.display("WARNING!!!", "ยังไม่มีข้อมูล กรุณาลงทะเบียน!!!", 300, 250);
                }
            }
        }
    }

    @FXML
    private void onClickRegisOk(ActionEvent actionEvent) {
        ArrayList<Account> allAccount = readAccount();

        receiveData(allAccount);
        writeAccount(allAccount, fileAccount);

        ArrayList<DataAccSub> dataAccSubs = new ArrayList<>();
        dataAccSubs.add(createDataAccSub(name.getText()));
        this.fileData = new File(pathData + studentId.getText()+".json");
        writeAccount(dataAccSubs, fileData);
        openLoginPage(actionEvent);
//        System.out.println(allAccount);
    }

    private void openLoginPage(ActionEvent actionEvent) {
        try {
            Parent regis = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene regisView = new Scene(regis, 330, 310);
            Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(regisView);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void receiveData(ArrayList<Account> allAccount) {
        if (name.getText().equals("")
                || studentId.getText().equals("")
                || gender.getText().equals("     เพศ")
                || accountName.getText().equals("")
                || pass.getText().equals(""))
        {
            AlertBox.display("WARNING!!!", "ใส่ข้อมูลให้ครบถ้วน!!!", 300, 250);
            return;
        }
        Account account = new Account(name.getText(), studentId.getText(), gender.getText(), accountName.getText(), pass.getText());
        allAccount.add(account);
    }

    private void writeAccount(ArrayList<?> array, File stream) {
        Gson gson = new Gson();
        String json = gson.toJson(array);

        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(stream));
            printWriter.println(json);

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Account> readAccount() {
        ArrayList<Account> allAccount = null;

        if (!fileAccount.exists()) {
            return new ArrayList<>();
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileAccount));
            allAccount = new Gson().fromJson(reader, new TypeToken<ArrayList<Account>>(){}.getType());

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allAccount;
    }

    public static String getUserPass() {
        return UserPass;
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