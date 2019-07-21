package exsample.dbauth.user.datasource;

import exsample.dbauth.user.model.UserData;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDataMapper {

    @Select("select * from user_data where id = '${id}'")
    @Results(id = "userDataResult", value= {
        @Result(column = "seq", property = "seq"),
        @Result(column = "id", property = "id"),
        @Result(column = "password", property = "password"),
        @Result(column = "name", property = "name"),
        @Result(column = "expire_date", property = "expireDate"),
        @Result(column = "invalid_flg", property = "invalidFlg")
    })
    UserData findById(@Param("id") String id);

    @Update("update user_data set password = '${password}', expire_date = DATEADD(MONTH, 1, CURRENT_DATE) where id = '${id}'")
    int updatePasswordById(@Param("id") String id, @Param("password") String password);
}
