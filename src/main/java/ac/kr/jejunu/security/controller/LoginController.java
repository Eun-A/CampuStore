package ac.kr.jejunu.security.controller;

import ac.kr.jejunu.security.model.LoginUserDetails;
import ac.kr.jejunu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Boobby on 17-5-19.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/mypage", produces = "text/html")
    public String mypage(@AuthenticationPrincipal LoginUserDetails userDetails) {
        return "mypage";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }


}
