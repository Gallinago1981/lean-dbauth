package exsample.dbauth.security.config;

import org.mybatis.spring.SqlSessionFactoryBean;

import javax.sql.DataSource;

/**
 * MyBatis Config
 *
 * http://www.mybatis.org/mybatis-3/ja/configuration.html
 */
//@Configuration
//@MapperScans({@MapperScan("exsample.dbauth.security.user.datasource")})
public class MyBatisConfig {

    //@Autowired
    private DataSource dataSource;

    //@Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration c = new org.apache.ibatis.session.Configuration();
        c.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(c);
        bean.setDataSource(dataSource);
        return bean;
    }
}
