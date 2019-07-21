package exsample.dbauth.password.model;


import javax.validation.constraints.NotBlank;

public class PasswordResetModel {

    private String userId;

    @NotBlank(message = "変更前のパスワードを入力してください。")
    private String oldPassword;

    @NotBlank(message = "新しいパスワードを入力してください。")
    private String newPassword;

    @NotBlank(message = "確認用のパスワードを入力してください。")
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

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }
}
