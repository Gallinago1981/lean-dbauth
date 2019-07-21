package exsample.dbauth.password.service;

import exsample.dbauth.user.datasource.UserDataRepository;
import exsample.dbauth.user.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * パスワードリセットサービス
 */
@Service
public class PasswordResetService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDataRepository userDataRepository;

    /**
     * 入力値が変更前のパスワードと一致しているかを判別する
     * @param userId
     * @param oldPassword
     * @return
     */
    public boolean confirmOldPassword(String userId, String oldPassword) {

        UserData userData = userDataRepository.findById(userId);
        if (userData == null) return false;

        return passwordEncoder.matches(oldPassword, userData.getPassword());
    }

    /**
     * 新しいパスワードに更新し有効期間を１ヵ月伸ばす
     * @param userId
     * @param newPassword
     * @return
     */
    public boolean updateNewPassword(String userId, String newPassword) {

        String encodePassword = passwordEncoder.encode(newPassword);
        userDataRepository.updatePasswordById(userId, encodePassword);

        return true;
    }


}
