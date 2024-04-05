package com.eliehome.EmployeeInformation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {
    private String welcome = "Welcome To Employees Information Data";
@GetMapping("/")
    public String welcomeToEmployeeInfo(){
        return welcome;
    }
}
