package com.codepresso.cheerup.controller;

import com.codepresso.cheerup.service.RecruitReviewService;
import com.codepresso.cheerup.vo.RecruitReview;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path="recruitReview")
public class RecruitReviewController {

    private final RecruitReviewService recruitReviewService;
    
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

    @GetMapping("/test")
    public List<RecruitReview> test() {
        return recruitReviewService.getAllRecruitReview();
    }
}
