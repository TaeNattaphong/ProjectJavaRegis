package sample;

import javafx.scene.paint.Color;

public class Subject {
    private  String subjectnumber;
    private  String subjectname;
    private  int subjectcredit;
    private Color colorSub;

    public Subject(String subjectnumber, String subjectname, int subjectcredit, Color colorSub) {
        this.subjectnumber = subjectnumber;
        this.subjectname = subjectname;
        this.subjectcredit = subjectcredit;
        this.colorSub = colorSub;
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
}
