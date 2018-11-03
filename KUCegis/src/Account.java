public class Account {
    private String fName;
    private String lName;
    private String sex;
    private String accountName;
    private String pass;
    private String rePass;
    private String eMail;

    public boolean isPass() {
        if (this.pass.equals(this.rePass)) {
            return true;
        }else {
            return false;
        }
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getSex() {
        return sex;
    }

    public String getAccountName() {
        return accountName;
    }

    public String geteMail() {
        return eMail;
    }
}
