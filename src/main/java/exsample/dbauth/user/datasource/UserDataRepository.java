package exsample.dbauth.user.datasource;

import exsample.dbauth.user.model.UserData;
import org.springframework.stereotype.Repository;

@Repository
public class UserDataRepository {

    private UserDataMapper userDataMapper;

    UserDataRepository(UserDataMapper userDataMapper) {
        this.userDataMapper = userDataMapper;
    }

    public UserData findById(String id) {
        return userDataMapper.findById(id);
    }

    public int updatePasswordById(String id, String newPassword) {
        int rownum =  userDataMapper.updatePasswordById(id, newPassword);
        if (rownum != 1) {
            throw new IllegalArgumentException("更新件数が想定件数と異なりました。件数=" + rownum);
        }
        return rownum;
    }
}
