package exsample.dbauth.security.config;


import exsample.dbauth.security.checker.CustomUserDetailsChecker;
import exsample.dbauth.security.handler.AuthErrorHandler;
import exsample.dbauth.user.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 *  USER_DATA テーブルに登録されているユーザ情報で認証を行う。
 *
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /** DBからユーザを検索するサービス */
    @Autowired
    UserDataService userDataService;

    /** パスワードの暗号化、複合化を行う */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        // DataSourceを利用するためにService化している
        daoAuthenticationProvider.setUserDetailsService(userDataService);
        // 独自のユーザ情報の状態チェックを行う。
        // 省略した場合はデフォルトの「DaoAuthenticationProvider#DefaultPreAuthenticationChecks」が利用される。
        daoAuthenticationProvider.setPreAuthenticationChecks(new CustomUserDetailsChecker());
        auth.authenticationProvider(daoAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login-form", "/password/**", "/error/**", "/logout").permitAll()
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/login-form")
                .successForwardUrl("/sample")
                .failureHandler(new AuthErrorHandler())
            .and()
                .logout();
        http.csrf().disable();
    }
}
