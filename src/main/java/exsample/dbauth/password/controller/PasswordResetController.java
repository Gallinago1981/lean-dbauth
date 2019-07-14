package exsample.dbauth.password.controller;

import exsample.dbauth.password.model.PasswordResetModel;
import exsample.dbauth.security.user.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/password")
public class PasswordResetController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDataService userDataService;

    @RequestMapping("/reset")
    public String show(@RequestParam String userId, Model model) {
        PasswordResetModel passwordResetModel = new PasswordResetModel();
        passwordResetModel.setUserId(userId);
        model.addAttribute("passwordResetModel", passwordResetModel);
        return "password/reset.html";
    }

    public void reset(PasswordResetModel resetPasswordModel) {



    }


}
