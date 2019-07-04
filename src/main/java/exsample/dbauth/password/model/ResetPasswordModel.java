package exsample.dbauth.password.model;


public class ResetPasswordModel {

    private String username;

    private String oldPassword;

    private String newpPssword;

    private String confPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewpPssword() {
        return newpPssword;
    }

    public void setNewpPssword(String newpPssword) {
        this.newpPssword = newpPssword;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }
}
