package com.codepresso.cheerup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterviewController {

    @GetMapping("/interview-home")
    public String interview_home(){
        return "user/interview/interview-home";
    }
    
    //interview 진행 중
    
    //interview 종료
}
