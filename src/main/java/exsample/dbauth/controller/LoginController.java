package exsample.dbauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ログイン画面表示処理
 */
@Controller
public class LoginController {

    @RequestMapping("/login-form")
    public String show() {
        return "login-form.html";
    }

    @RequestMapping("/login-error")
    public String error(Model model) {
        model.addAttribute("loginError", true);
        return "login-form.html";
    }

}
