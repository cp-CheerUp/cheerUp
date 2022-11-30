package com.codepresso.cheerup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {
    @GetMapping("/")
    public String test(){
        return "index";
    }

    @GetMapping("/inner-page")
    public String test2(){
        return "inner-page";
    }

//    @GetMapping("/freeboard")
//    public String freeboard() {
//        return "freeboard";
//    }
}
