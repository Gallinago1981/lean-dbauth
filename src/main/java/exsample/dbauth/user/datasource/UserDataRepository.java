package exsample.dbauth.user.datasource;

import exsample.dbauth.user.model.UserData;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

@Repository
public class UserDataRepository {

    private UserDataMapper userDataMapper;

    UserDataRepository(UserDataMapper userDataMapper) {
        this.userDataMapper = userDataMapper;
    }

    public UserData findById(String id) {
        assert !StringUtils.isEmpty(id);
        return userDataMapper.findById(id);
    }

    @Transactional
    public int updatePasswordById(String id, String newPassword) {
        assert !StringUtils.isEmpty(id);
        assert !StringUtils.isEmpty(newPassword);
        int rownum =  userDataMapper.updatePasswordById(id, newPassword);
        if (rownum > 1) {
            throw new IllegalArgumentException("更新件数が想定件数と異なりました。件数=" + rownum);
        }
        return rownum;
    }
}
