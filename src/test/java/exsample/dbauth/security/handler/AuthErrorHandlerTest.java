package exsample.dbauth.security.handler;

import exsample.dbauth.security.exception.PasswordExpireException;
import exsample.dbauth.security.exception.UserDisableException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockRequestDispatcher;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AuthErrorHandlerTest {


    @DisplayName("BadCredentialsException")
    @Test
    public void onAuthenticationFailure01() {

        String validPath = "/login-error";

        HttpServletRequest request = mock(MockHttpServletRequest.class);
        when(request.getRequestDispatcher(validPath)).thenReturn(new MockRequestDispatcher(validPath));
        HttpServletResponse response = new MockHttpServletResponse();
        BadCredentialsException exception = new BadCredentialsException("junit");

        AuthErrorHandler handler = new AuthErrorHandler();
        // mockで指定したリクエストパスと実装が不一致の場合、RequestDispatcherが取得できずNullPointerExceptionが発生する
        assertDoesNotThrow(() -> handler.onAuthenticationFailure(request, response, exception));
    }

    @DisplayName("PasswordExpireException")
    @Test
    public void onAuthenticationFailure02() {
        String userId = "dummyUser";
        String validPath = "/password/reset?userId=" + userId;
        PasswordExpireException exception = new PasswordExpireException(userId, "message");

        HttpServletRequest request = mock(MockHttpServletRequest.class);
        when(request.getRequestDispatcher(validPath)).thenReturn(new MockRequestDispatcher(validPath));
        HttpServletResponse response = new MockHttpServletResponse();

        AuthErrorHandler handler = new AuthErrorHandler();
        // mockで指定したリクエストパスと実装が不一致の場合、RequestDispatcherが取得できずNullPointerExceptionが発生する
        assertDoesNotThrow(() -> handler.onAuthenticationFailure(request, response, exception));

    }

    @DisplayName("UserDisableException")
    @Test
    public void onAuthenticationFailure03() {
        String validPath = "/error/userDisabled";

        HttpServletRequest request = mock(MockHttpServletRequest.class);
        when(request.getRequestDispatcher(validPath)).thenReturn(new MockRequestDispatcher(validPath));
        HttpServletResponse response = new MockHttpServletResponse();
        UserDisableException exception = new UserDisableException("junit");

        AuthErrorHandler handler = new AuthErrorHandler();
        // mockで指定したリクエストパスと実装が不一致の場合、RequestDispatcherが取得できずNullPointerExceptionが発生する
        assertDoesNotThrow(() -> handler.onAuthenticationFailure(request, response, exception));

    }

    @DisplayName("その他のException")
    @Test
    public void onAuthenticationFailure04() {
        String validPath = "/error/authError";

        HttpServletRequest request = mock(MockHttpServletRequest.class);
        when(request.getRequestDispatcher(validPath)).thenReturn(new MockRequestDispatcher(validPath));
        HttpServletResponse response = new MockHttpServletResponse();

        SessionAuthenticationException exception = new SessionAuthenticationException("message");

        AuthErrorHandler handler = new AuthErrorHandler();
        // mockで指定したリクエストパスと実装が不一致の場合、RequestDispatcherが取得できずNullPointerExceptionが発生する
        assertDoesNotThrow(() -> handler.onAuthenticationFailure(request, response, exception));

    }
}
