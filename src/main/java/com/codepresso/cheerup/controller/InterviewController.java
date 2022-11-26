package com.codepresso.cheerup.controller;

import com.codepresso.cheerup.vo.Interview;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class InterviewController {


    //사용자가 선택한 카테고리의 질문 조회
    @PostMapping("/interview")
    public String interview_select(Interview interview, Authentication authentication){

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String id = userDetails.getUsername();

        //카테고리의 id 값을 넘겨서 사용자가 선택한 질문 카테고리만 가져오기

        //질문들의 output 카운트 +1 증가


        return "/";
    }

}
