package com.codepresso.cheerup.controller;

import com.codepresso.cheerup.service.InterviewService;
import com.codepresso.cheerup.vo.Interview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor //final 객체 생성자 생성
public class InterviewPageController {

    private final InterviewService interviewService;


    //화면 이동 : interview 홈
    @GetMapping("/interview-home")
    public String interview_home(){
        return "user/interview/interview-home";
    }


    //interview 진행 중
    @GetMapping("/interviewing")
    public String interview(Interview interview, Model model){

        String category_origin = interview.getCategory();
        List<Interview> singleList = interviewService.getSingleList(category_origin);

        model.addAttribute("interview",singleList);

        return "user/interview/interview";

    }

    //interview 종료
    @GetMapping("/interview-result")
    public String result(){
        return "user/interview/interview-result";
    }
}
