package sample;

public class Subject {
    private  String subjectnumber;
    private  String subjectname;
    private  String subjectcredit;

    public Subject(String subjectnumber, String subjectname, String subjectcredit) {
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

    public String getSubjectcredit() {
        return subjectcredit;
    }
}
