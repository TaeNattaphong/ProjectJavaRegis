package sample;

public class Account {
    private String name;
    private String studentId;
    private String gender;
    private String accountName;
    private String pass;

    public Account(String name, String studentId, String gender, String accountName, String pass) {
        this.name = name;
        this.studentId = studentId;
        this.gender = gender;
        this.accountName = accountName;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getPass() {
        return pass;
    }
}
