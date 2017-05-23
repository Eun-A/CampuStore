package ac.kr.jejunu.security.controller;

import ac.kr.jejunu.common.entity.User;
import ac.kr.jejunu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Boobby on 17-5-20.
 */
@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(ModelMap modelMap) {
        User user = new User();
        modelMap.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(value = "/registerProcessing", method = RequestMethod.POST)
    public String registerProcessing(@ModelAttribute("user") User user) {
        boolean isSuccessful = userService.register(user);
        String url = "";
        if (isSuccessful) url = "/login?registerSuccessful";
        else url = "/register?error";

        return "redirect:" + url;
    }
}
