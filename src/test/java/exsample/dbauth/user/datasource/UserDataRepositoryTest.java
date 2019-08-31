package exsample.dbauth.user.datasource;

import exsample.dbauth.user.model.UserData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest
public class UserDataRepositoryTest {

    @Autowired
    UserDataRepository userDataRepository;

    @InjectMocks
    UserDataRepository mockUserDataRepository;

    @Mock
    UserDataMapper userDataMapper;

    @DisplayName("id指定でのSELECT（検索結果あり）")
    @Sql(statements = "INSERT INTO user_data VALUES (9999, 'junit', 'junit', 'testname', CURRENT_DATE, '0', CURRENT_TIMESTAMP , CURRENT_TIMESTAMP)")
    @Test
    public void findById01() {
        UserData userData = userDataRepository.findById("junit");
        assertNotNull(userData);
        assertEquals("testname", userData.getName());
    }

    @DisplayName("id指定でのSELECT（検索結果なし）")
    @Test
    public void findById02() {
        UserData userData = userDataRepository.findById("111");
        assertNull(userData);
    }
    @DisplayName("パラメータ不正")
    @Test
    public void findById03() {
        assertThrows(AssertionError.class,
                () -> userDataRepository.findById(null));
    }

    @DisplayName("Update 更新対象あり")
    @Test
    public void updatePasswordById01() {

        int updateCount = userDataRepository.updatePasswordById("test01", "newpassword");
        UserData userData = userDataRepository.findById("test01");
        assertEquals(1, updateCount);
        assertEquals("newpassword", userData.getPassword());

    }

    @DisplayName("更新対象なし")
    @Test
    public void updatePasswordById02() {

        int updateCount = userDataRepository.updatePasswordById("nothing", "newpassword");
        assertEquals(0, updateCount);

    }

    @DisplayName("パラメータ不正")
    @Test
    public void updatePasswordById03() {

        assertThrows(AssertionError.class,
                () -> userDataRepository.updatePasswordById("test01", null));

    }

    @DisplayName("更新件数不正")
    @Test
    public void updatePasswordById04() {
        when(this.userDataMapper.updatePasswordById("test01", "newpassword")).thenReturn(2);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> mockUserDataRepository.updatePasswordById("test01", "newpassword"));
        assertEquals("更新件数が想定件数と異なりました。件数=2", exception.getMessage());

    }

}
