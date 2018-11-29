package sample;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private  String subjectnumber;
    private  String subjectname;
    private  int subjectcredit;
    private Color colorSub;
    private int passSub;
    private int continueSub1;
    private int continueSub2;


    public Subject(String subjectnumber, String subjectname, int subjectcredit, Color colorSub, int passSub, int continueSub1, int continueSub2) {
        this.subjectnumber = subjectnumber;
        this.subjectname = subjectname;
        this.subjectcredit = subjectcredit;
        this.colorSub = colorSub;
        this.passSub = passSub;
        this.continueSub1 = continueSub1;
        this.continueSub2 = continueSub2;
    }
    public Subject(int passSub){
        this.subjectnumber = subjectnumber;
        this.subjectname = subjectname;
        this.subjectcredit = subjectcredit;
        this.colorSub = Color.RED;
        this.passSub = passSub;
    }

    public int getContinueSub1() {
        return continueSub1;
    }

    public int getContinueSub2() {
        return continueSub2;
    }

    public String getSubjectnumber() {
        return subjectnumber;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public int getSubjectcredit() {
        return subjectcredit;
    }

    public Color getColorSub() {
        return colorSub;
    }

    public void setColorSub(Color colorSub) {
        this.colorSub = colorSub;
    }

    public int getPassSub() {
        return passSub;
    }
}
