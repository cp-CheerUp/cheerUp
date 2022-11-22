package com.codepresso.cheerup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="recruitReview")
public class RecruitReviewController {

    @GetMapping("/mainRecruitReview")
    public String test2(){
        return "recruitReview/mainRecruitReview";
    }
}
