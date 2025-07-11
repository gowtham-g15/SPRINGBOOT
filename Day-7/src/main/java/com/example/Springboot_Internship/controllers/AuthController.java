package com.example.Springboot_Internship.controllers;

import com.example.Springboot_Internship.models.RegisterDetails;
import com.example.Springboot_Internship.models.UserDetailsDto;
import com.example.Springboot_Internship.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping ("/register")
    public String addNewEmployee(@RequestBody UserDetailsDto register){
        authService.addNewEmployee(register);

        return "Employee Registered Successfully";
    }
    @PostMapping("/login")
    public String Login(@RequestBody RegisterDetails login){

        return  authService.authenticate(login);
    }

}
