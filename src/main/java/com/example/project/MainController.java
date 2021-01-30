package com.example.project;

import com.example.project.ap.practice.Consecutive;
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
        return "ap-practice/menuAP.html";
    }

    @GetMapping("/ap-practice/andrew") // root for Andrew page
    public String apPracticeAndrew(){
        return "ap-practice/Andrew/andrew.html";
    }








    @GetMapping("/ap-practice/nakul") // root for Nakul page
    public String apPracticeNakul(@RequestParam(name="str", required=false,  defaultValue="ccaaaaattt") String str, Model model){
        Consecutive consecutive = new Consecutive();
        consecutive.longestStreak(str);

        model.addAttribute("consecutiveChar", consecutive.getCharacter());
        model.addAttribute("consecutiveTotal", consecutive.getTotalConsecutive());

        return "ap-practice/nakul";
    }








    @GetMapping("/ap-practice/sara") // root for Sara page
    public String apPracticeSara(){
        return "ap-practice/sara.html";
    }








    @GetMapping("/ap-practice/michael") // root for Michael page
    public String apPracticeMichael(){
        return "ap-practice/michael.html";
    }
}
