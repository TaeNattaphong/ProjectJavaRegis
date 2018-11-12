package sample;

public class Account {
    private String name;
    private Gender gender;
    private String accountName;
    private String pass;
    private String eMail;

    public Account(String name, Gender gender, String accountName, String pass, String eMail) {
        this.name = name;
        this.gender = gender;
        this.accountName = accountName;
        this.pass = pass;
        this.eMail = eMail;
    }

    public String getPass() {
        return pass;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getAccountName() {
        return accountName;
    }

    public String geteMail() {
        return eMail;
    }
}
