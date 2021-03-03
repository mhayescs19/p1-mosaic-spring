package com.example.project.Security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserServiceController {

    @GetMapping("/login")
    public String getLoginView()
    {
        return "synergy/login";
    }

}
