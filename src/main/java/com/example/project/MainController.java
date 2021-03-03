package com.example.project;

import AndrewFrq1.LightSequence;
import Tools.DynamoDb.hashMapToItem;
import Tools.DynamoDb.itemToHashMap;
import com.example.project.ap.practice.Invitation;
import com.example.project.mini.games.Hangman;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import AndrewFrq1.StringStruct;

import com.example.project.ap.practice.PasswordGenerator;
import com.example.project.ap.practice.Consecutive;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import software.amazon.awssdk.enhanced.dynamodb.internal.converter.attribute.EnhancedAttributeValue;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ResourceNotFoundException;
import synergy.Assignment;
import synergy.Class;
import synergy.Schedule;
import synergy.Synergy;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    Hangman control_java = new Hangman();

    @GetMapping("/ap-practice")
    public String apPractice() {
        return "ap-practice/menuAP.html";
    }

    @GetMapping("/ap-practice/andrew") // root for Andrew page
    public String apPracticeAndrew(Model model) {
        model.addAttribute("StringStruct", new StringStruct());
        return "ap-practice/Andrew/andrew.html";
    }

    @GetMapping("/frq1")
    public String Display2(@ModelAttribute("StringStruct") StringStruct stringStruct, Model model) {
        System.out.println(stringStruct);
        LightSequence lightSequence = new LightSequence(stringStruct.getField1());
        model.addAttribute("Sequenceone", lightSequence.seq);
        lightSequence.remove(lightSequence.seq, stringStruct.getField3());
        lightSequence.printStraightline(stringStruct.anInt1, stringStruct.anInt2);
        model.addAttribute("InsertedSegment", lightSequence.insertSegment(stringStruct.field2, stringStruct.anInt1));
        model.addAttribute("removeSegment", lightSequence.newSeq);
        model.addAttribute("mathReturn", lightSequence.thing);
        return "ap-practice/Andrew/frq1.html";
    }

    @PostMapping("/frq1")
    public String Display(@ModelAttribute("StringStruct") StringStruct stringStruct, Model model) {
        System.out.println(stringStruct);
        LightSequence lightSequence = new LightSequence(stringStruct.getField1());
        model.addAttribute("Sequenceone", lightSequence.seq);
        lightSequence.remove(lightSequence.seq, stringStruct.getField3());
        lightSequence.printStraightline(stringStruct.anInt1, stringStruct.anInt2);
        model.addAttribute("InsertedSegment", lightSequence.insertSegment(stringStruct.field2, stringStruct.anInt1));
        model.addAttribute("removeSegment", lightSequence.newSeq);
        model.addAttribute("mathReturn", lightSequence.thing);
        return "ap-practice/Andrew/frq1.html";
    }


    @GetMapping("/ap-practice/nakul") // root for Nakul page
    public String apPracticeNakul(@RequestParam(name = "str", required = false, defaultValue = "ccaaaaattt") String str, Model model) {
        Consecutive consecutive = new Consecutive();
        consecutive.longestStreak(str);

        model.addAttribute("consecutiveChar", consecutive.getCharacter());
        model.addAttribute("consecutiveTotal", consecutive.getTotalConsecutive());

        return "ap-practice/nakul";
    }

    @GetMapping("/labs") // root for menuLabs page
    public String Labs() {
        return "labs/menuLabs";
    }

    @GetMapping("/labs/Pythagorean") // root for Pythagoras page
    public String Pythagoras() {
        return "labs/Pythagorean";
    }


    @GetMapping("/ap-practice/sara") // root for Sara page
    public String apPracticeSara(@RequestParam(name = "rsvp", required = true, defaultValue = "true") String rsvp, @RequestParam(name = "selection", required = false, defaultValue = "1") String prefix, Model model) {

        // Unit 3 FRQ, Question #1
        Invitation invitation = new Invitation();
        // use invitation to get option1
        model.addAttribute("rsvp", invitation.getClass());
        model.addAttribute("selection", invitation.getClass());

        return "ap-practice/sara.html";
    }


    @GetMapping("/labs/Tip")
    public String Tips() {
        return "labs/tipCalc";
    }


    @GetMapping("/ap-practice/michael") // root for Michael page
    public String apPracticeMichael(@RequestParam(name = "length", required = false, defaultValue = "4") String length, @RequestParam(name = "prefix", required = false, defaultValue = "A") String prefix, Model model) { // use multiple @RequestParam annotations if you have multiple variables in HTML (correct way to reference them?)

        // UNIT 5 FRQ PART A
        PasswordGenerator newPassword = new PasswordGenerator(Integer.parseInt(length), prefix);


        model.addAttribute("passwords", newPassword.getPasswordList()); // s: goes to variable name in HTML
        model.addAttribute("passwordGenerated", newPassword.pwGen());

        return "ap-practice/michael"; // use path to HTML file without .html OR it does not recognize model attributes!
    }


    @GetMapping("/labs/hangman")
    public String hangmanGame(@RequestParam(name = "alphaSelection", required = false, defaultValue = "A") String alphaSelection, Model model) {


        control_java.checkLetter(Character.toLowerCase(alphaSelection.charAt(0))); // gets char from button return, passed it in to the existing control

        model.addAttribute("displayPhrase", control_java.getCurrentPhraseForDisplay()); // updates current display phrase, is set in a simple <p> in html
        model.addAttribute("guessesRemaining", control_java.getRemainingGuesses()); // displays guesses remaining

        return "labs/hangman";
    }


    @GetMapping("/synergy")
    public String Synergy() {
        return "synergy/loginView";
    }

    @GetMapping("/teacherView")
    @PreAuthorize("hasAnyRole('ROLE_TEACHER')")
    public String showForm(Synergy synergy) {
        return "synergy/teacherView";
    }

    @PostMapping("/teacherView")
    @PreAuthorize("hasAnyRole('ROLE_TEACHER')")
    public String teacherView(@Valid Synergy synergy, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "synergy/teacherView";
        }
        model.addAttribute("studentname", synergy.getName());
        model.addAttribute("studentage", synergy.getAge());
        model.addAttribute("studentyear", synergy.getYear());
        model.addAttribute("studentgrade", synergy.getGrade());
        return "synergy/teacherView";
    }

    @GetMapping("/synergy/student/home")
    public String studentHome(Model model) {

        //displays ArrayList via ThymeLeaf for:each in HTML
        ArrayList<Class> schedule = new ArrayList<>();
        schedule.add(new Class("AP CMTR SCI A (2)", "Mortensen"));
        schedule.add(new Class("AP CHEM (2)", "Ozuna"));
        schedule.add(new Class("AP SPANISH (2)", "DeAlba"));
        schedule.add(new Class("EXPOS 2", "West"));
        schedule.add(new Class("OFFROLL TRI2 P5", "Giame"));

        model.addAttribute("schedule", schedule);
        return "synergy/studentHome";
    }

    @GetMapping("/synergy/student/calendar")
    public String studentCalendar() {
        return "synergy/studentCalendar";
    }

    @GetMapping("/synergy/student/gradeBook")
    public String studentGradeBook(Model model) {

        // displays ArrayList via ThymeLeaf for:each in HTML
        ArrayList<Assignment> assignments = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            assignments.add(new Assignment("2/2" + i + "/21", "HW " + i, ((double)i*15)/10, (((double)i*15)/10) * 2, "test data"));
        }

        model.addAttribute("assignments", assignments);
        return "synergy/studentGradeBook";
    }

    @GetMapping("/synergy/student/info")
    public String studentInfo() {
        return "synergy/studentInfo";
    }

    @GetMapping("/synergy/student/schoolInformation")
    public String schoolInformation() {
        return "synergy/schoolInformation";
    }
    @PostMapping("/test/text")
    public String Testing(@RequestBody Map<String,Object> string)
    {
        System.out.println(string);
        if (string != null) {
            for (Object obj: string.values()) {
                if (obj == null) {
                    continue;
                }
                else
                    System.out.println(obj.toString());

            }
        }
        return "synergy/loginView"; // just for fun
    }


    /**
     * A way we can use back end to get information from the db and send it back to the user who requested it
     *
     * @param idNumber idNumber to look up in database
     * @return html page
     */
    @PostMapping("/synergy/student/get")
    public String getStudent(@RequestParam(name = "IdNumber", defaultValue = "") String idNumber, Model model) {
        System.out.println(idNumber);
        DynamoDbClient dbClient = DynamoDbClient.create();
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("IDNumber", AttributeValue.builder().s(idNumber).build());
        GetItemRequest request = GetItemRequest.builder().tableName("Students").key(key).build();
        Map<String, AttributeValue> returnedItems;
        try {
            returnedItems = dbClient.getItem(request).item();
        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            model.addAttribute("error", "Error encounter, Our backend was not able to get the item that you ask for (" + idNumber + ")");
            return "synergy/Error"; // Destination for webReturn this wont change the end point just the html shown going to have the fields name the same for the js to read
        }
        if (returnedItems.isEmpty()) {
            model.addAttribute("error", "Error the item you asked for is either empty or does not exist");
            return "synergy/Error";
        } else {
            Map<String, Object> objectMap = new itemToHashMap().convertItemToMap(EnhancedAttributeValue.fromMap(returnedItems));
            String json;
            try {
                json = new ObjectMapper().writeValueAsString(objectMap);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                model.addAttribute("error", "Error Json Failed to be created :(");
                return "synergy/Error";
            }
            model.addAttribute("studentInfo", json); // adds the json to the model should allow us to get
            return "synergy/studentReturn"; // place holder
        }
    }


    @PostMapping("/synergy/student/put")
    public String putStudent(@RequestBody Synergy synergy, Model model) {
        System.out.println(synergy.toHashMap().toString());
        DynamoDbClient dbClient = DynamoDbClient.create();
       HashMap<String,AttributeValue> attributeValueHashMap = new hashMapToItem().hashMapToValue(synergy.toHashMap());
       PutItemRequest request = PutItemRequest.builder().tableName("Students").item(attributeValueHashMap).conditionExpression("attribute_not_exists(IDNumber)").build();
        try {
            dbClient.putItem(request);
        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            model.addAttribute("error", "Error encounter, Our backend was not able to put the item that you entered");
            //throw a http error
            return "synergy/Error"; // Destination for webReturn this wont change the end point just the html shown going to have the fields name the same for the js to read
        }

        return "synergy/studentReturn"; // place holder
    }
}
