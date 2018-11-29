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
        writeFile();
//        write();
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
        dataAccSubs.add(new DataAccSub("adminadmin" ,new PassColorSub(0), new PassColorSub(1), new PassColorSub(2), new PassColorSub(3), new PassColorSub(4),
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
        team1Pee1.add(new Subject("0","0",0,Color.RED,0,0,0));
        team1Pee1.add(new Subject("01417111","Calculus I",3, Color.RED, 1, 0, 0));
        team1Pee1.add(new Subject("01418112","Fund. Programming Concepts",3, Color.RED, 2, 0, 0));
        team1Pee1.add(new Subject("01418114", "Intro. to Computer Science", 2, Color.RED, 3, 0, 0));
        team1Pee1.add(new Subject("01418131", "Digital Computer Logic", 3, Color.RED, 4, 0, 0));
        team1Pee1.add(new Subject("01999111", "ศาสตร์แห่งแผ่นดิน", 2, Color.RED, 5, 0, 0));
        team1Pee1.add(new Subject("01", "(สาระภาษาฯ - ภาษาต่างประเทศ 1)", 3, Color.RED, 6, 0, 0));
        team1Pee1.add(new Subject("01", "(สาระภาษาฯ - ภาษาไทย)", 3, Color.RED, 7, 0 , 0));

        ArrayList<Subject> team2Pee1 = new ArrayList<>();
        team2Pee1.add(new Subject("01417112", "Calculus II", 3, Color.RED, 8, 1, 0));
        team2Pee1.add(new Subject("01418113", "Computer Programming", 3, Color.RED, 9, 2, 0));
        team2Pee1.add(new Subject("01418132", "Fundamentals of Computing", 4, Color.RED, 10, 0, 0));
        team2Pee1.add(new Subject("01175", "(สาระอยู่ดีมีสุข - พลศึกษา)", 1, Color.RED, 11, 0, 0));
        team2Pee1.add(new Subject("01", "(สาระศาสตร์แห่งผู้ประกอบการ)", 3, Color.RED, 12, 0, 0));
        team2Pee1.add(new Subject("01", "(สาระพลเมืองไทยฯ)", 1, Color.RED, 13, 0, 0));
        team2Pee1.add(new Subject("01", "(สาระสุนทรียศาสตร์)", 3, Color.RED, 14, 0, 0));

        ArrayList<Subject> team1Pee2 = new ArrayList<>();
        team1Pee2.add(new Subject("01417322", "Introductory Linear Algebra", 3, Color.RED, 15, 8, 0));
        team1Pee2.add(new Subject("01418211", "Software Construction", 3, Color.RED, 16, 9, 0));
        team1Pee2.add(new Subject("01418231", "Data Structures", 3, Color.RED, 17, 9, 0));
        team1Pee2.add(new Subject("01422111", "Principles of Statistics", 3, Color.RED, 18, 0, 0));
        team1Pee2.add(new Subject("01", "(สาระภาษาฯ - IT/Computer)", 1, Color.RED, 19, 0,0));
        team1Pee2.add(new Subject("01", "(สาระอยู่ดีมีสุข)", 2, Color.RED, 20, 0, 0));
        team1Pee2.add(new Subject("01", "(ทั้ง 5 สาระ - คณะวิทยาศาสตร์)", 3, Color.RED, 21, 0, 0));

        ArrayList<Subject> team2Pee2 = new ArrayList<>();
        team2Pee2.add(new Subject("01418221", "Fund. of Database Systems", 3, Color.RED, 22, 9, 0));
        team2Pee2.add(new Subject("01418232", "Algorithms Design and Analysis", 3, Color.RED, 23, 10, 0));
        team2Pee2.add(new Subject("01418233", "Assembly Lang. and Comp. Arch.", 4, Color.RED, 24, 9, 0));
        team2Pee2.add(new Subject("01418", "Major Electives I", 3, Color.RED, 25, 0, 0));
        team2Pee2.add(new Subject("01", "(สาระภาษาฯ - ภาษาต่างประเทศ 2)", 3, Color.RED, 26, 0, 0));
        team2Pee2.add(new Subject("01", "(ทั้ง 5 สาระ - คณะวิทยาศาสตร์)", 2, Color.RED, 27, 0, 0));

        ArrayList<Subject> team1Pee3 = new ArrayList<>();
        team1Pee3.add(new Subject("01418321", "System Analysis and Design", 3, Color.RED, 28, 16, 22));
        team1Pee3.add(new Subject("01418331", "Operating Systems", 4, Color.RED, 29, 24, 0));
        team1Pee3.add(new Subject("01418341", "Intellectual Prop & Profess. Ethics", 3, Color.RED, 30, 0, 0));
        team1Pee3.add(new Subject("01418497", "Seminar", 1, Color.RED, 31, 23, 24));
        team1Pee3.add(new Subject("01418", "Major Electives II", 3, Color.RED, 32, 0,0));
        team1Pee3.add(new Subject("01", "(สาระภาษาฯ - ภาษาต่างประเทศ 3)", 3, Color.RED, 33,0,0));

        ArrayList<Subject> team2Pee3 = new ArrayList<>();
        team2Pee3.add(new Subject("01418332", "Information System Security", 3, Color.RED, 34, 29, 0));
        team2Pee3.add(new Subject("01418333", "Automata Theory", 2, Color.RED, 35, 10,0));
        team2Pee3.add(new Subject("01418334", "Compiler Techniques", 2, Color.RED, 36, 29,0));
        team2Pee3.add(new Subject("01418351", "Prin. in CCs & Cloud Computing", 3, Color.RED, 37, 0,0));
        team2Pee3.add(new Subject("01418390", "Co-op. Education Preparation", 1, Color.RED, 38, 28, 0));
        team2Pee3.add(new Subject("01418", "Major Electives III", 3, Color.RED, 39, 0, 0));
        team2Pee3.add(new Subject("01", "Free Electives I", 3, Color.RED, 40, 0, 0));

        ArrayList<Subject> team1Pee4 = new ArrayList<>();
        team1Pee4.add(new Subject("01418490", "Co-op. Education", 6, Color.RED, 41, 38,0));

        ArrayList<Subject> team2Pee4 = new ArrayList<>();
        team2Pee4.add(new Subject("01418499", "CS Project", 3, Color.RED, 42, 28, 0));
        team2Pee4.add(new Subject("01418", "Major Electives IV", 3, Color.RED, 43, 0,0));
        team2Pee4.add(new Subject("01418", "Major Electives V", 3, Color.RED, 44, 0,0));
        team2Pee4.add(new Subject("01418", "Major Electives VI", 3, Color.RED, 45,0,0));
        team2Pee4.add(new Subject("01", "Free Electives II", 3, Color.RED, 46,0,0));

        Gson gson1 = new Gson();
        Gson gson2 = new Gson();
        Gson gson3 = new Gson();
        Gson gson4 = new Gson();
        Gson gson5 = new Gson();
        Gson gson6 = new Gson();
        Gson gson7 = new Gson();
        Gson gson8 = new Gson();
        String json1 = gson1.toJson(team1Pee1);
        String json2 = gson2.toJson(team2Pee1);
        String json3 = gson3.toJson(team1Pee2);
        String json4 = gson4.toJson(team2Pee2);
        String json5 = gson5.toJson(team1Pee3);
        String json6 = gson6.toJson(team2Pee3);
        String json7 = gson7.toJson(team1Pee4);
        String json8 = gson8.toJson(team2Pee4);

        PrintWriter printWriter1 = new PrintWriter(new FileWriter("SubjectPee1Team1.json"));
        PrintWriter printWriter2 = new PrintWriter(new FileWriter("SubjectPee1Team2.json"));
        PrintWriter printWriter3 = new PrintWriter(new FileWriter("SubjectPee2Team1.json"));
        PrintWriter printWriter4 = new PrintWriter(new FileWriter("SubjectPee2Team2.json"));
        PrintWriter printWriter5 = new PrintWriter(new FileWriter("SubjectPee3Team1.json"));
        PrintWriter printWriter6 = new PrintWriter(new FileWriter("SubjectPee3Team2.json"));
        PrintWriter printWriter7 = new PrintWriter(new FileWriter("SubjectPee4Team1.json"));
        PrintWriter printWriter8 = new PrintWriter(new FileWriter("SubjectPee4Team2.json"));
        printWriter1.println(json1);
        printWriter1.close();
        printWriter2.println(json2);
        printWriter2.close();
        printWriter3.println(json3);
        printWriter3.close();
        printWriter4.println(json4);
        printWriter4.close();
        printWriter5.println(json5);
        printWriter5.close();
        printWriter6.println(json6);
        printWriter6.close();
        printWriter7.println(json7);
        printWriter7.close();
        printWriter8.println(json8);
        printWriter8.close();
    }
}
