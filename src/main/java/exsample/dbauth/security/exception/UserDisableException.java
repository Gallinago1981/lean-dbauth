package exsample.dbauth.security.exception;


import org.springframework.security.core.AuthenticationException;

public class UserDisableException extends AuthenticationException {

    public UserDisableException(String msg) {
        super(msg);
    }
}
