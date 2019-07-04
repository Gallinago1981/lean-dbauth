package exsample.dbauth.password.controller;

import exsample.dbauth.password.model.ResetPasswordModel;
import exsample.dbauth.security.user.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/password")
public class PasswordResetController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDataService userDataService;

    @RequestMapping("/reset")
    public String show() {
        return "password/reset.html";
    }

    public void reset(ResetPasswordModel resetPasswordModel) {



    }


}
