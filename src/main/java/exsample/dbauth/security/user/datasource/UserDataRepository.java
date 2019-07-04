package exsample.dbauth.security.user.datasource;

import exsample.dbauth.security.user.model.UserData;
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


}
