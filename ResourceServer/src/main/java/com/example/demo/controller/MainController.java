package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/secure")
    public String secure(){
        return "This is SECURE route";
    }
    @GetMapping("/unsecure")
    public String unsecure(){
        return "This is UNSECURE route";
    }
}
