package exsample.dbauth.security.exception;

import org.springframework.security.core.AuthenticationException;

public class PasswordExpireException extends AuthenticationException {

    private String username;

    public PasswordExpireException(String username, String msg, Throwable t) {
        super(msg, t);
        this.username = username;
    }

    public PasswordExpireException(String username, String msg) {
        super(msg);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
