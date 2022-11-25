package com.codepresso.cheerup.dao;

import com.codepresso.cheerup.vo.RecruitReview;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RecruitReviewMapper {
    List<RecruitReview> getAllRecruitReview();
    RecruitReview getOneRecruitReview(int boardNo);
}
