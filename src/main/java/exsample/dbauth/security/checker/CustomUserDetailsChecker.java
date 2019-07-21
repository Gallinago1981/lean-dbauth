package exsample.dbauth.security.checker;

import exsample.dbauth.security.exception.PasswordExpireException;
import exsample.dbauth.security.exception.UserDisableException;
import exsample.dbauth.user.model.UserData;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;

/**
 * ユーザの状態チェック処理
 */
public class CustomUserDetailsChecker implements UserDetailsChecker {

    @Override
    public void check(UserDetails user) {

        UserData userData = (UserData) user;
        if (!user.isEnabled()) {
            throw new UserDisableException("無効ユーザです。User ID:" + ((UserData) user).getId());
        }
        if (!user.isAccountNonExpired()) {
            throw new PasswordExpireException(userData.getId(), "パスワード有効期限切れ");
        }

    }
}
