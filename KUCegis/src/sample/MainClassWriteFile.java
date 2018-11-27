package sample;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import javafx.scene.paint.Color;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainClassWriteFile {
    public static void main(String[] args) throws IOException {
//        readFile();
//        writeFile();
        write();
    }

    private static void readFile() throws IOException {
        BufferedReader readerColor = new BufferedReader(new FileReader("DataColorSub.json"));
        Gson gsonColor = new Gson();
        JsonArray arrayColor = gsonColor.fromJson(readerColor, JsonArray.class);
        ArrayList<DataAccSub> all = new ArrayList<>();
        for (int i = 0; i < arrayColor.size(); i++) {
            JsonElement element = arrayColor.get(i);
            DataAccSub dataAccSub = gsonColor.fromJson(element, DataAccSub.class);
            DataAccSub a = dataAccSub;
            System.out.println(a.getUser());
            all.add(a);
        }
        String json = gsonColor.toJson(all);
        PrintWriter printWriter = new PrintWriter(new FileWriter("DataColorSub.json"));
        printWriter.println(json);

        readerColor.close();
        printWriter.close();
    }

    private static void write() throws IOException {
        ArrayList<DataAccSub> dataAccSubs = new ArrayList<>();
        dataAccSubs.add(new DataAccSub("adminadmin" , new PassColorSub(1), new PassColorSub(2), new PassColorSub(3), new PassColorSub(4),
                new PassColorSub(5), new PassColorSub(6), new PassColorSub(7), new PassColorSub(8), new PassColorSub(9),
                new PassColorSub(10), new PassColorSub(11), new PassColorSub(12), new PassColorSub(13), new PassColorSub(14),
                new PassColorSub(15), new PassColorSub(16), new PassColorSub(17), new PassColorSub(18), new PassColorSub(19),
                new PassColorSub(20), new PassColorSub(21), new PassColorSub(22), new PassColorSub(23), new PassColorSub(24),
                new PassColorSub(25), new PassColorSub(26), new PassColorSub(27), new PassColorSub(28), new PassColorSub(29),
                new PassColorSub(30), new PassColorSub(31), new PassColorSub(32), new PassColorSub(33), new PassColorSub(34),
                new PassColorSub(35), new PassColorSub(36), new PassColorSub(37), new PassColorSub(38), new PassColorSub(39),
                new PassColorSub(40), new PassColorSub(41), new PassColorSub(42), new PassColorSub(43), new PassColorSub(44),
                new PassColorSub(45), new PassColorSub(46)));
        Gson gson = new Gson();
        String json = gson.toJson(dataAccSubs);

        PrintWriter printWriter = new PrintWriter(new FileWriter("DataColorSub.json"));
        printWriter.println(json);
        printWriter.close();
    }

    private static void writeFile() throws IOException {

        ArrayList<Subject> team1Pee1 = new ArrayList<>();
        team1Pee1.add(new Subject("01417111","Calculus I",3, Color.RED, 1));
        team1Pee1.add(new Subject("01418112","Fund. Programming Concepts",3, Color.RED, 2));
        team1Pee1.add(new Subject("01418114", "Intro. to Computer Science", 2, Color.RED, 3));
        team1Pee1.add(new Subject("01418131", "Digital Computer Logic", 3, Color.RED, 4));
        team1Pee1.add(new Subject("01999111", "ศาสตร์แห่งแผ่นดิน", 2, Color.RED, 5));
        team1Pee1.add(new Subject("01", "(สาระภาษาฯ - ภาษาต่างประเทศ 1)", 3, Color.RED, 6));
        team1Pee1.add(new Subject("01", "(สาระภาษาฯ - ภาษาไทย)", 3, Color.RED, 7));

        ArrayList<Subject> team2Pee1 = new ArrayList<>();
        team2Pee1.add(new Subject("01417112", "Calculus II", 3, Color.RED, 8));
        team2Pee1.add(new Subject("01418113", "Computer Programming", 3, Color.RED, 9));
        team2Pee1.add(new Subject("01418132", "Fundamentals of Computing", 4, Color.RED, 10));
        team2Pee1.add(new Subject("01175", "(สาระอยู่ดีมีสุข - พลศึกษา)", 1, Color.RED, 11));
        team2Pee1.add(new Subject("01", "(สาระศาสตร์แห่งผู้ประกอบการ)", 3, Color.RED, 12));
        team2Pee1.add(new Subject("01", "(สาระพลเมืองไทยฯ)", 1, Color.RED, 13));
        team2Pee1.add(new Subject("01", "(สาระสุนทรียศาสตร์)", 3, Color.RED, 14));

        ArrayList<Subject> team1Pee2 = new ArrayList<>();
        team1Pee2.add(new Subject("01417322", "Introductory Linear Algebra", 3, Color.RED, 15));
        team1Pee2.add(new Subject("01418211", "Software Construction", 3, Color.RED, 16));
        team1Pee2.add(new Subject("01418231", "Data Structures", 3, Color.RED, 17));
        team1Pee2.add(new Subject("01422111", "Principles of Statistics", 3, Color.RED, 18));
        team1Pee2.add(new Subject("01", "(สาระภาษาฯ - IT/Computer)", 1, Color.RED, 19));
        team1Pee2.add(new Subject("01", "(สาระอยู่ดีมีสุข)", 2, Color.RED, 20));
        team1Pee2.add(new Subject("01", "(ทั้ง 5 สาระ - คณะวิทยาศาสตร์)", 3, Color.RED, 21));

        ArrayList<Subject> team2Pee2 = new ArrayList<>();
        team2Pee2.add(new Subject("01418221", "Fund. of Database Systems", 3, Color.RED, 22));
        team2Pee2.add(new Subject("01418232", "Algorithms Design and Analysis", 3, Color.RED, 23));
        team2Pee2.add(new Subject("01418233", "Assembly Lang. and Comp. Arch.", 4, Color.RED, 24));
        team2Pee2.add(new Subject("01418", "Major Electives I", 3, Color.RED, 25));
        team2Pee2.add(new Subject("01", "(สาระภาษาฯ - ภาษาต่างประเทศ 2)", 3, Color.RED, 26));
        team2Pee2.add(new Subject("01", "(ทั้ง 5 สาระ - คณะวิทยาศาสตร์)", 2, Color.RED, 27));

        ArrayList<Subject> team1Pee3 = new ArrayList<>();
        team1Pee3.add(new Subject("01418321", "System Analysis and Design", 3, Color.RED, 28));
        team1Pee3.add(new Subject("01418331", "Operating Systems", 4, Color.RED, 29));
        team1Pee3.add(new Subject("01418341", "Intellectual Prop & Profess. Ethics", 3, Color.RED, 30));
        team1Pee3.add(new Subject("01418497", "Seminar", 1, Color.RED, 31));
        team1Pee3.add(new Subject("01418", "Major Electives II", 3, Color.RED, 32));
        team1Pee3.add(new Subject("01", "(สาระภาษาฯ - ภาษาต่างประเทศ 3)", 3, Color.RED, 33));

        ArrayList<Subject> team2Pee3 = new ArrayList<>();
        team2Pee3.add(new Subject("01418332", "Information System Security", 3, Color.RED, 34));
        team2Pee3.add(new Subject("01418333", "Automata Theory", 2, Color.RED, 35));
        team2Pee3.add(new Subject("01418334", "Compiler Techniques", 2, Color.RED, 36));
        team2Pee3.add(new Subject("01418351", "Prin. in CCs & Cloud Computing", 3, Color.RED, 37));
        team2Pee3.add(new Subject("01418390", "Co-op. Education Preparation", 1, Color.RED, 38));
        team2Pee3.add(new Subject("01418", "Major Electives III", 3, Color.RED, 39));
        team2Pee3.add(new Subject("01", "Free Electives I", 3, Color.RED, 40));

        ArrayList<Subject> team1Pee4 = new ArrayList<>();
        team1Pee4.add(new Subject("01418490", "Co-op. Education", 6, Color.RED, 41));

        ArrayList<Subject> team2Pee4 = new ArrayList<>();
        team2Pee4.add(new Subject("01418499", "CS Project", 3, Color.RED, 42));
        team2Pee4.add(new Subject("01418", "Major Electives IV", 3, Color.RED, 43));
        team2Pee4.add(new Subject("01418", "Major Electives V", 3, Color.RED, 44));
        team2Pee4.add(new Subject("01418", "Major Electives VI", 3, Color.RED, 45));
        team2Pee4.add(new Subject("01", "Free Electives II", 3, Color.RED, 46));

        Gson gson = new Gson();
        String json = gson.toJson(team1Pee1);

        PrintWriter printWriter = new PrintWriter(new FileWriter("SubjectPee1Team1.json"));
        printWriter.println(json);
        printWriter.close();
    }
}
