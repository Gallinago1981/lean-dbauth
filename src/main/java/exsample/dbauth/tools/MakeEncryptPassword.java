package exsample.dbauth.tools;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MakeEncryptPassword {

    public static void main(String[] args) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        for (String pw : new String[]{"pass01", "pass02", "pass03"}) {
            String encryptPw = passwordEncoder.encode(pw);
            System.out.println(pw + ":" + encryptPw);
        }

    }
}
