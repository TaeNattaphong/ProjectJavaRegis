package sample;

import com.google.gson.Gson;
import javafx.scene.paint.Color;

import java.io.*;
import java.util.ArrayList;

public class MainClassWriteFile {
    public static void main(String[] args) throws IOException {
//        readFile();
        writeFile();
    }

//    private static void readFile() throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader("Account.json"));
//        Gson gson = new Gson();
//        JsonArray array = gson.fromJson(reader, JsonArray.class);
//        ArrayList<Account> allAccount = new ArrayList<>();
//        for (int i = 0; i < array.size(); i++) {
//            JsonElement element = array.get(i);
//            Account account = gson.fromJson(element, Account.class);
//            String name = account.getName();
//            String studentId = account.getStudentId();
//            String gender = account.getGender();
//            String accountName = account.getAccountName();
//            String pass = account.getPass();
//
//            Account a = new Account(name, studentId, gender, accountName, pass);
//            allAccount.add(a);
//        }
//        Account a = new Account("Tae", "MK", "admin1234", "mk@hotmail", "fg");
//        allAccount.add(a);
//        String json = gson.toJson(allAccount);
//        PrintWriter printWriter = new PrintWriter(new FileWriter("Account.json"));
//        printWriter.println(json);
//
//        reader.close();
//        printWriter.close();
//    }

    private static void writeFile() throws IOException {

        ArrayList<Subject> team1Pee1 = new ArrayList<>();
        team1Pee1.add(new Subject("01417111","Calculus I",3, Color.RED));
        team1Pee1.add(new Subject("01418112","Fund. Programming Concepts",3, Color.RED));
        team1Pee1.add(new Subject("01418114", "Intro. to Computer Science", 2, Color.RED));
        team1Pee1.add(new Subject("01418131", "Digital Computer Logic", 3, Color.RED));
        team1Pee1.add(new Subject("01999111", "ศาสตร์แห่งแผ่นดิน", 2, Color.RED));
        team1Pee1.add(new Subject("01", "(สาระภาษาฯ - ภาษาต่างประเทศ 1)", 3, Color.RED));
        team1Pee1.add(new Subject("01", "(สาระภาษาฯ - ภาษาไทย)", 3, Color.RED));

        ArrayList<Subject> team2Pee1 = new ArrayList<>();
        team2Pee1.add(new Subject("01417112", "Calculus II", 3, Color.RED));
        team2Pee1.add(new Subject("01418113", "Computer Programming", 3, Color.RED));
        team2Pee1.add(new Subject("01418132", "Fundamentals of Computing", 4, Color.RED));
        team2Pee1.add(new Subject("01175", "(สาระอยู่ดีมีสุข - พลศึกษา)", 1, Color.RED));
        team2Pee1.add(new Subject("01", "(สาระศาสตร์แห่งผู้ประกอบการ)", 3, Color.RED));
        team2Pee1.add(new Subject("01", "(สาระพลเมืองไทยฯ)", 1, Color.RED));
        team2Pee1.add(new Subject("01", "(สาระสุนทรียศาสตร์)", 3, Color.RED));

        ArrayList<Subject> team1Pee2 = new ArrayList<>();
        team1Pee2.add(new Subject("01417322", "Introductory Linear Algebra", 3, Color.RED));
        team1Pee2.add(new Subject("01418211", "Software Construction", 3, Color.RED));
        team1Pee2.add(new Subject("01418231", "Data Structures", 3, Color.RED));
        team1Pee2.add(new Subject("01422111", "Principles of Statistics", 3, Color.RED));
        team1Pee2.add(new Subject("01", "(สาระภาษาฯ - IT/Computer)", 1, Color.RED));
        team1Pee2.add(new Subject("01", "(สาระอยู่ดีมีสุข)", 2, Color.RED));
        team1Pee2.add(new Subject("01", "(ทั้ง 5 สาระ - คณะวิทยาศาสตร์)", 3, Color.RED));

        ArrayList<Subject> team2Pee2 = new ArrayList<>();
        team2Pee2.add(new Subject("01418221", "Fund. of Database Systems", 3, Color.RED));
        team2Pee2.add(new Subject("01418232", "Algorithms Design and Analysis", 3, Color.RED));
        team2Pee2.add(new Subject("01418233", "Assembly Lang. and Comp. Arch.", 4, Color.RED));
        team2Pee2.add(new Subject("01418", "Major Electives I", 3, Color.RED));
        team2Pee2.add(new Subject("01", "(สาระภาษาฯ - ภาษาต่างประเทศ 2)", 3, Color.RED));
        team2Pee2.add(new Subject("01", "(ทั้ง 5 สาระ - คณะวิทยาศาสตร์)", 2, Color.RED));

        ArrayList<Subject> team1Pee3 = new ArrayList<>();
        team1Pee3.add(new Subject("01418321", "System Analysis and Design", 3, Color.RED));
        team1Pee3.add(new Subject("01418331", "Operating Systems", 4, Color.RED));
        team1Pee3.add(new Subject("01418341", "Intellectual Prop & Profess. Ethics", 3, Color.RED));
        team1Pee3.add(new Subject("01418497", "Seminar", 1, Color.RED));
        team1Pee3.add(new Subject("01418", "Major Electives II", 3, Color.RED));
        team1Pee3.add(new Subject("01", "(สาระภาษาฯ - ภาษาต่างประเทศ 3)", 3, Color.RED));

        ArrayList<Subject> team2Pee3 = new ArrayList<>();
        team2Pee3.add(new Subject("01418332", "Information System Security", 3, Color.RED));
        team2Pee3.add(new Subject("01418333", "Automata Theory", 2, Color.RED));
        team2Pee3.add(new Subject("01418334", "Compiler Techniques", 2, Color.RED));
        team2Pee3.add(new Subject("01418351", "Prin. in CCs & Cloud Computing", 3, Color.RED));
        team2Pee3.add(new Subject("01418390", "Co-op. Education Preparation", 1, Color.RED));
        team2Pee3.add(new Subject("01418", "Major Electives III", 3, Color.RED));
        team2Pee3.add(new Subject("01", "Free Electives I", 3, Color.RED));

        ArrayList<Subject> team1Pee4 = new ArrayList<>();
        team1Pee4.add(new Subject("01418490", "Co-op. Education", 6, Color.RED));

        ArrayList<Subject> team2Pee4 = new ArrayList<>();
        team2Pee4.add(new Subject("01418499", "CS Project", 3, Color.RED));
        team2Pee4.add(new Subject("01418", "Major Electives IV", 3, Color.RED));
        team2Pee4.add(new Subject("01418", "Major Electives V", 3, Color.RED));
        team2Pee4.add(new Subject("01418", "Major Electives VI", 3, Color.RED));
        team2Pee4.add(new Subject("01", "Free Electives II", 3, Color.RED));

        Gson gson = new Gson();
        String json = gson.toJson(team1Pee1);

        PrintWriter printWriter = new PrintWriter(new FileWriter("SubjectPee1Team1.json"));
        printWriter.println(json);
        printWriter.close();
    }
}
