package exsample.dbauth.password.controller;

import exsample.dbauth.password.model.PasswordResetModel;
import exsample.dbauth.password.service.PasswordResetService;
import exsample.dbauth.user.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/password")
public class PasswordResetController {

    @Autowired
    UserDataService userDataService;

    @Autowired
    PasswordResetService passwordResetService;

    @RequestMapping("/reset")
    public String show(@RequestParam String userId, Model model) {
        PasswordResetModel passwordResetModel = new PasswordResetModel();
        passwordResetModel.setUserId(userId);
        model.addAttribute("passwordResetModel", passwordResetModel);
        return "password/reset.html";
    }

    @RequestMapping(value="/reset", params="reset")
    public String reset(@Validated PasswordResetModel resetPasswordModel, BindingResult bindingResult) {

        boolean passwordFaild = passwordResetService.confirmOldPassword(
                resetPasswordModel.getUserId(), resetPasswordModel.getOldPassword());

        if (!passwordFaild) {
            bindingResult.rejectValue("oldPassword", null, "パスワードが間違っています。");
        }

        if (!resetPasswordModel.getNewPassword().equals(
                resetPasswordModel.getConfPassword())) {
            bindingResult.rejectValue("newPassword", null, "確認用パスワードが不一致です。");
        }

        if (bindingResult.hasErrors()) {
            return "password/reset.html";
        }

        passwordResetService.updateNewPassword(resetPasswordModel.getUserId(), resetPasswordModel.getNewPassword());

        return "password/resetFinish.html";
    }


}
