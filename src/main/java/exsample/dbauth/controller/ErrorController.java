package exsample.dbauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  エラー画面制御用コントローラ
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/authError")
    public String authenticationError() {
        return "error/auth-error.html";
    }

    @RequestMapping("/userDisabled")
    public String userDisabledError() {
        return "error/user-disabled.html";
    }
}
