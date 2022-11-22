package com.codepresso.cheerup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="recruitReview")
public class RecruitReviewController {

    @GetMapping("/mainRecruitReview")
    public String test1(){
        return "recruitReview/mainRecruitReview";
    }

    @GetMapping("/writeReview")
    public String test2(){
        return "recruitReview/writeReview";
    }

    @GetMapping("/viewReview")
    public String test3(){
        return "recruitReview/viewReview";
    }
}
