package exsample.dbauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthSuccessController {

    @RequestMapping("/sample")
    public String show() {
        return "success.html";
    }



}

