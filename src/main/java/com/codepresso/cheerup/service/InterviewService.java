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

    public List<Interview> getSelectedList(Interview interview) {

        return interviewMapper.getSelectedList(interview);

    }
}
