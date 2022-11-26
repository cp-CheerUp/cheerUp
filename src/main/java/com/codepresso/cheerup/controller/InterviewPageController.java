package com.codepresso.cheerup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterviewPageController {

    //화면 이동 : interview 홈
    @GetMapping("/interview-home")
    public String interview_home(){
        return "user/interview/interview-home";
    }


    //interview 진행 중
    @GetMapping("/interviewing")
    public String interview(){
        return "user/interview/interview";
    }

    //interview 종료
    @GetMapping("/interview-result")
    public String result(){
        return "user/interview/interview-result";
    }
}
