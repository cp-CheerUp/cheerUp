package com.codepresso.cheerup.service;

import com.codepresso.cheerup.dao.InterviewMapper;
import com.codepresso.cheerup.dao.UserMapper;
import com.codepresso.cheerup.vo.Interview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //final 객체 생성자 생성
public class InterviewService {

    private final InterviewMapper interviewMapper;

    //READ : 사용자가 선택한 카테고리 질문 가져오기(단일 선택)
    public List<Interview> getSingleList(String category_origin) {
        return interviewMapper.getSingleList(category_origin);
    }

    //READ : 사용자가 선택한 카테고리 질문 가져오기(복합 선택)
    public List<Interview> getMultiList(String[] multiArray) {
        return interviewMapper.getMultiList(multiArray);
    }


    public List<Interview> getMultiListTest(String[] multiArray, int limitCount) {
        return interviewMapper.getMultiListTest(multiArray,limitCount);
    }
}
