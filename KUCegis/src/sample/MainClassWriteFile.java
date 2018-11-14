package sample;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.*;
import java.util.ArrayList;

public class MainClassWriteFile {
    public static void main(String[] args) throws IOException {
        readFile();
//        writeFile();
    }

    private static void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Data.json"));
        Gson gson = new Gson();
        JsonArray array = gson.fromJson(reader, JsonArray.class);

        for (int i=0; i<array.size(); i++) {
            JsonElement element = array.get(i);
            Account account = gson.fromJson(element, Account.class);

            System.out.println(account.getAccountName());
        }
        reader.close();
    }

    private static void writeFile() throws IOException{
        Account account = new Account("Tae", "MK", "admin1234", "mk@hotmail", "fg");
        Account account2 = new Account("Bossoo", "K", "admin", "k@hotmail", "df");

        ArrayList<Account> allAccount = new ArrayList<>();
        allAccount.add(account);
        allAccount.add(account2);

        Gson gson = new Gson();
        String json = gson.toJson(allAccount);

        BufferedWriter writer = new BufferedWriter(new FileWriter("Data.json"));
        PrintWriter printWriter = new PrintWriter(writer);

        printWriter.println(json);
        printWriter.close();
    }
}
