package com.example.project.Security;

import com.example.project.NewUser.NewUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import javax.validation.Valid;

/**
 * controller for login and logout
 * @see SecurityConfig
 * @see com.example.project.Security.Auth.UserService
 * @author Andrew
 */
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
    @GetMapping("/createUser")
    public String createUser(Model model)
    {
        model.addAttribute("newUser", new NewUser());
        return "synergy/CreateUser";
    }
    @PostMapping("/createUser")
    public String createUser(@Valid NewUser user, BindingResult bindingResult,Model model)
    {
        if (bindingResult.hasErrors())
        {
            return "synergy/CreateUser";
        }

        DynamoDbClient dbClient = DynamoDbClient.create();

    }


}
