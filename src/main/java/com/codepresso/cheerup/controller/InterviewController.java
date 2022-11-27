package com.codepresso.cheerup.controller;

import com.codepresso.cheerup.service.InterviewService;
import com.codepresso.cheerup.vo.Interview;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
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
        String category_origin = interview.getCategory();
        System.out.println("여기는 컨트롤러고 카테고리를 받았어요"+category_origin);

        //(1)카테고리의 id 값을 넘겨서 사용자가 선택한 질문 카테고리만 가져오기
        if(!(category_origin.contains(","))){
            //(1)-(1) : 단일 카테고리 작업
            System.out.println("여기는 컨트롤러고 조건문 단일 카테고리가 안에 있어요"+category_origin);

            List<Interview> singleList = interviewService.getSingleList(category_origin);


            return singleList;

        }else{
            //(1)-(2) : 복합 카테고리 작업
            String[] multiArray = category_origin.split(",");
            System.out.println("여기는 컨트롤러고 조건문 복합 카테고리 안에 있어요"+multiArray);

            List<Interview> multiList = interviewService.getMultiList(multiArray);

            return multiList;

//            String[] comma_seperate = category_origin.split(",");
//            List<String> multipleList = new ArrayList<>();
//
//            for(int i=0;i<comma_seperate.length; i++){
//                multipleList.add(comma_seperate[i]);
//            }


        }


//                interviewService.getSelectedList(interview);
        //질문들의 output 카운트 +1 증가

    }

}
