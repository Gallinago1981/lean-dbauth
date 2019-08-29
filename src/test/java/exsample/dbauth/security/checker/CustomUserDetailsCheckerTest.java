package exsample.dbauth.security.checker;

import exsample.dbauth.security.exception.PasswordExpireException;
import exsample.dbauth.security.exception.UserDisableException;
import exsample.dbauth.user.model.UserData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
public class CustomUserDetailsCheckerTest {

    CustomUserDetailsChecker checker;

    @BeforeEach
    public void setup() {
        checker = new CustomUserDetailsChecker();
    }
    @DisplayName("通常ユーザ。例外がthrowされないこと")
    @Test
    public void check01() {
        UserData userData = new UserData();
        userData.setId("test01");
        userData.setInvalidFlg("0");
        userData.setExpireDate(LocalDate.now().plusMonths(1));
        assertDoesNotThrow(() -> checker.check(userData));
    }
    @DisplayName("無効ユーザの場合、UserDisableExceptionがthrowされること")
    @Test
    public void check02() {
        UserData userData = new UserData();
        userData.setId("test01");
        userData.setInvalidFlg("1");
        assertThrows(UserDisableException.class, ()->checker.check(userData));
    }

    @DisplayName("有効期限切れの場合、PasswordExpireExceptionがthrowされること")
    @Test
    public void check03() {
        UserData userData = new UserData();
        userData.setId("test01");
        userData.setInvalidFlg("0");
        userData.setExpireDate(LocalDate.now().minusMonths(1));
        assertThrows(PasswordExpireException.class, ()->checker.check(userData));
    }
}
