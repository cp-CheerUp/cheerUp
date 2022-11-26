package com.codepresso.cheerup.controller;

import com.codepresso.cheerup.service.InterviewService;
import com.codepresso.cheerup.service.UserService;
import com.codepresso.cheerup.vo.Interview;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor //final 객체 생성자 생성
public class InterviewController {

    private final InterviewService interviewService;


    //사용자가 선택한 카테고리의 질문 조회
    @PostMapping("/interview")
    public List<Interview> interview_select(Interview interview, Authentication authentication){

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String id = userDetails.getUsername();

        System.out.println("컨트롤러의 인터뷰 카테고리"+interview);
        //카테고리의 id 값을 넘겨서 사용자가 선택한 질문 카테고리만 가져오기
      List<Interview> interview_list = interviewService.getSelectedList(interview);
        //질문들의 output 카운트 +1 증가


        return interview_list;
    }

}
