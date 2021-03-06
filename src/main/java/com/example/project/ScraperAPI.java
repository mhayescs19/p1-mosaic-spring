package com.example.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api")
public class ScraperAPI {

    @GetMapping("/delnorte")
    public String scraperAPI() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder().uri(URI.create("https://www.powayusd.com/en-US/Schools/HS/DNHS/Contacts/Staff-Directory")).build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException e){
            System.err.println(e.getMessage());
            throw new InterruptedException("Encountered Error");
        }

        //System.out.println(response.body());
        return response.body();
    }
}
