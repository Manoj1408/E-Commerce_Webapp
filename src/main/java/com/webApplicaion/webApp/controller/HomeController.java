package com.webApplicaion.webApp.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @RequestMapping("/")
    public String great(){
        return "Welcome to My web application";
    }
    @RequestMapping("/about")
    public String about(){
        return "Welcome to About Tab";
    }

}
