package exsample.dbauth.security.checker;

import exsample.dbauth.security.exception.PasswordExpireException;
import exsample.dbauth.security.user.model.UserData;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetailsChecker extends AccountStatusUserDetailsChecker {

    @Override
    public void check(UserDetails user) {

        if (!user.isAccountNonExpired()) {
            UserData userData = (UserData) user;
            throw new PasswordExpireException(userData.getId(), "パスワード有効期限切れ");
        }

        // User
        super.check(user);

    }
}
