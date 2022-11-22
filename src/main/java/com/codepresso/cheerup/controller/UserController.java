package com.codepresso.cheerup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/signup")
    public String signup(){
        return "user/manage/sign-up";
    }

    @GetMapping("/login")
    public String login(){
        return "user/manage/login";
    }


}
