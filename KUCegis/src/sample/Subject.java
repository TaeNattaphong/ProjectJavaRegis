package sample;

public class Subject {
    private  String subjectnumber;
    private  String subjectname;
    private  int subjectcredit;

    public Subject(String subjectnumber, String subjectname, int subjectcredit) {
        this.subjectnumber = subjectnumber;
        this.subjectname = subjectname;
        this.subjectcredit = subjectcredit;
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
}
