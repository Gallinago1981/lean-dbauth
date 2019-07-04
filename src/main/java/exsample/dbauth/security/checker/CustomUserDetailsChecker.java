package exsample.dbauth.security.checker;

import exsample.dbauth.security.exception.PasswordExpireException;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetailsChecker extends AccountStatusUserDetailsChecker {

    @Override
    public void check(UserDetails user) {

        if (!user.isAccountNonExpired()) {
            throw new PasswordExpireException(user.getUsername(), "パスワード有効期限切れ");
        }

        // User
        super.check(user);

    }
}
