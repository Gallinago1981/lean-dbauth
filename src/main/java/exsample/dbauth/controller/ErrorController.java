package exsample.dbauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {
    @RequestMapping("/authError")
    public String authenticationError() {
        return "error/auth-error.html";
    }

}
