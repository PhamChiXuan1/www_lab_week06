package vn.edu.iuh.fit.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.edu.iuh.fit.backend.services.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login(){
        return "login-form";
    }

    @PostMapping("/login")
    public String Login(String email, String password){
        boolean login = userService.checkLogin(email, password);
        if(login){
            return "redirect:/blog";
        }
        else {
            return "login-form";
        }
    }
}
