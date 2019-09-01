package exsample.dbauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  認証成功時の画面描画
 */
@Controller
public class AuthSuccessController {

    @RequestMapping("/sample")
    public String show() {
        return "success.html";
    }

}

