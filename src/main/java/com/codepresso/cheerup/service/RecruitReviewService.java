package com.codepresso.cheerup.service;

import com.codepresso.cheerup.dao.RecruitReviewMapper;
import com.codepresso.cheerup.vo.RecruitReview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecruitReviewService {
// 예전에는 속도 implements로 나눴지만 나눴지만 지금은 상관이 없어서 한파일로 해도됨

    private final RecruitReviewMapper recruitReviewMapper;

    public List<RecruitReview> getAllRecruitReview() {
        return recruitReviewMapper.getAllRecruitReview();
    }

    public RecruitReview getOneRecruitReview(int boardNo) {return recruitReviewMapper.getOneRecruitReview(boardNo);}
}
