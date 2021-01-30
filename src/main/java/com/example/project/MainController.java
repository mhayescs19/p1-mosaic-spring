package com.example.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

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
    public String apPracticeNakul(){
        return "ap-practice/nakul.html";
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
