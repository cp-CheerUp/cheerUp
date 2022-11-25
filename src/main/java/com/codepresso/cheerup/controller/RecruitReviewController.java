package com.codepresso.cheerup.controller;

import com.codepresso.cheerup.service.RecruitReviewService;
import com.codepresso.cheerup.vo.RecruitReview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(path="recruitReview")
public class RecruitReviewController {
    private final RecruitReviewService recruitReviewService;
    @GetMapping("/mainRecruitReview")
    public String getRecruitList(Model model) {
        List<RecruitReview> list = recruitReviewService.getAllRecruitReview();
        model.addAttribute("reviewList", list);
        return "recruitReview/mainRecruitReview";
    }

    @GetMapping("/writeReview")
    public String test2(){
        return "recruitReview/writeReview";
    }

    @GetMapping("/viewReview")
    public String viewReview(Model model, @RequestParam int boardNo){
        RecruitReview review = recruitReviewService.getOneRecruitReview(boardNo);
        model.addAttribute("review", review);
        return "recruitReview/viewReview";
    }

}
