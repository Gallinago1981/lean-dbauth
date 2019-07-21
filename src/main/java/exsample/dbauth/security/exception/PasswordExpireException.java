package exsample.dbauth.security.exception;

import org.springframework.security.core.AuthenticationException;

public class PasswordExpireException extends AuthenticationException {

    private String userId;

    public PasswordExpireException(String userId, String msg, Throwable t) {
        super(msg, t);
        this.userId = userId;
    }

    public PasswordExpireException(String userId, String msg) {
        super(msg);
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
