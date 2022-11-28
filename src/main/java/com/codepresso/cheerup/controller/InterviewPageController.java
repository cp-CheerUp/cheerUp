package com.codepresso.cheerup.controller;

import com.codepresso.cheerup.service.InterviewService;
import com.codepresso.cheerup.vo.Interview;
import com.codepresso.cheerup.vo.Interview_response;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class InterviewPageController {

    private final InterviewService interviewService;

    //화면 이동 : interview 홈
    @GetMapping("/interview-home")
    public String interview_home(){
        return "user/interview/interview-home";
    }

    //interview 종료
    @PostMapping("/interview-result")
    public String result(String interview_id, String interview_answer, Authentication authentication ){

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String id = userDetails.getUsername();

        String[] id_array = interview_id.split(",");
        String[] answer_array = interview_answer.split(",");


        System.out.println("여기는 컨트롤러"+interview_id);
        System.out.println("여기는 컨트롤러"+interview_answer);

        //사용자의 응답 데이터 저장
        int result = interviewService.insertUserResponse(id, id_array,answer_array);

        System.out.println(result);

        //질문 total 갯수 1 증가시키기
        //     interviewService.updateTotal =

        return "/";
    }


    //interview 진행 중
    @GetMapping("/interview")
    public String interview( Interview interview, Model model) {

        String category_origin = interview.getCategory();
        System.out.println("여기는 컨트롤러고 카테고리를 받았어요" + category_origin);

        //(1)카테고리의 id 값을 넘겨서 사용자가 선택한 질문 카테고리만 가져오기
        if (!(category_origin.contains(","))) {
            //(1)-(1) : 단일 카테고리 작업
            System.out.println("여기는 컨트롤러고 조건문 단일 카테고리가 안에 있어요" + category_origin);

            List<Interview> singleList = interviewService.getSingleList(category_origin);
            //질문들의 output 카운트 +1 증가

            model.addAttribute("list", singleList);

        } else {
            //(1)-(2) : 복합 카테고리 작업
            String[] multiArray = category_origin.split(",");
            System.out.println("여기는 컨트롤러고 조건문 복합 카테고리 안에 있어요" + multiArray);

            //쿼리 갯수 제한 카운트
            int limitCount = 0;

            if (multiArray.length == 2) {
                //카테고리 2개 -> 각 카테고리당 5개씩
                limitCount = 5;
            } else if (multiArray.length == 3) {
                //카테고리 3개 -> 각 카테고리당 3개씩
                limitCount = 4;
            } else if (multiArray.length == 4) {
                //카테고리 4개 -> 각 카테고리당 3개씩
                limitCount = 3;
            } else if (multiArray.length == 5) {
                //카테고리 5개 -> 각 카테고리당 3개씩
                limitCount = 3;
            } else if (multiArray.length == 6) {
                limitCount = 3;
            } else if (multiArray.length == 7) {
                limitCount = 2;
            } else if (multiArray.length == 8) {
                limitCount = 2;
            }

            //     List<Interview> multiList = interviewService.getMultiList(multiArray);
            //    model.addAttribute("list", multiList);

            List<Interview> multiListTest = interviewService.multiListTest(multiArray, limitCount);
            model.addAttribute("list", multiListTest);

            System.out.println(multiListTest.toString());
        }

        return "user/interview/interview";

    }
}
