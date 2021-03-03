package com.example.project.Security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserServiceController {

    @GetMapping("/login")
    public String getLoginView()
    {
        return "synergy/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "synergy/logout";
    }
}
