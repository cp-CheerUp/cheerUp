package com.codepresso.cheerup.dao;

import com.codepresso.cheerup.vo.Interview;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InterviewMapper {
    
    //유저가 선택한 카테고리의 정보만 가져오기
    List<Interview> getSelectedList(Interview interview);

    List<Interview> getSingleList(String category_origin);
    List<Interview> getMultiList(String[] multiArray);

    List<Interview> getMultiListTest(String[] multiArray, int limitCount);
}
