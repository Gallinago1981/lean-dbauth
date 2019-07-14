package exsample.dbauth.password.model;


public class PasswordResetModel {

    private String userId;

    private String oldPassword;

    private String newpPssword;

    private String confPassword;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
