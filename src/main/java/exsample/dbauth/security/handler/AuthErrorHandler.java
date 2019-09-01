package exsample.dbauth.security.handler;

import exsample.dbauth.security.exception.PasswordExpireException;
import exsample.dbauth.security.exception.UserDisableException;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  認証エラーハンドラー
 *
 *
 *  PasswordExpireException, UserDisableExceptionは{@see exsample.dbauth.security.checker.}で発生する。
 *
 */
public class AuthErrorHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (exception instanceof  BadCredentialsException) {
            // パスワード不一致
            forward(request, response,"/login-error");
        } else if (exception instanceof PasswordExpireException) {
            // パスワード有効期限切れ
            PasswordExpireException pee = (PasswordExpireException) exception;
            forward(request, response, "/password/reset?userId=" + ((PasswordExpireException) exception).getUserId());
        } else if (exception instanceof UserDisableException) {
            forward(request, response,"/error/userDisabled");
        } else {
            forward(request, response,"/error/authError");
        }

    }

    private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws IOException, ServletException {
        request.getRequestDispatcher(path).forward(request, response);
    }

}
