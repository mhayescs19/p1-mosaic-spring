package com.example.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import com.example.project.ap.practice.PasswordGenerator;

@Controller
public class MainController {

    @GetMapping("/ap-practice")
    public String apPractice() {

        return "ap-practice/menuAP";//.html";
    }

    @GetMapping("/ap-practice/andrew") // root for Andrew page
    public String apPracticeAndrew(){

        return "ap-practice/andrew";//.html";
    }








    @GetMapping("/ap-practice/nakul") // root for Nakul page
    public String apPracticeNakul(){

        return "ap-practice/nakul";//.html";
    }








    @GetMapping("/ap-practice/sara") // root for Sara page
    public String apPracticeSara(){
        return "ap-practice/sara";//"html";
    }








    @GetMapping("/ap-practice/michael") // root for Michael page
    public String apPracticeMichael(@RequestParam (name="length", required=false, defaultValue="4") String length, @RequestParam(name="prefix", required=false, defaultValue="A") String prefix, Model model){ // use multiple @RequestParam annotations if you have multiple variables in HTML (correct way to reference them?)

        PasswordGenerator newPassword = new PasswordGenerator(Integer.parseInt(length), prefix);


        model.addAttribute("passwords", newPassword.getPasswordList()); // s: goes to variable name in HTML
        model.addAttribute("passwordGenerated", newPassword.pwGen());

        return "ap-practice/michael"; // use path to HTML file without .html OR it does not recognize model attributes!
    }
}
