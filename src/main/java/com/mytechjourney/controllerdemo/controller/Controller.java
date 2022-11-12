package com.mytechjourney.controllerdemo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mytechjourney.controllerdemo.model.Person;

@RestController
public class Controller {
    
    Map<String, Integer> personToAgeMap = new HashMap<String, Integer>();

    @PostMapping("/ping")
    public String Ping(){
        return "Pinged successfully.";
    }

    @PostMapping("/addAgeUsingRequestParams")
    public String addAgeUsingRequestParams(@RequestParam String name, @RequestParam Integer age){
        int count = personToAgeMap.size();
        try{
            personToAgeMap.put(name, age);
            if(personToAgeMap.size() == (count + 1)){
                return "Age added successfully.";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Age was not added.";
        } 
        return "Age was not added.";
    }

    @PostMapping("/addAgeUsingRequestBody")
    public String addAgeUsingRequestBody(@RequestBody Person person){
        int count = personToAgeMap.size();
        try{
            personToAgeMap.put(person.getName(), person.getAge());
            if(personToAgeMap.size() == (count + 1)){
                return "Age added successfully.";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Age was not added.";
        } 
        return "Age was not added.";
    }

    @GetMapping("/getAge/{name}")
    public Integer getAge(@PathVariable(name = "name") String name){
        try{
            int age = personToAgeMap.get(name);
            return age;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

}
