package com.codepresso.cheerup.dao;

import com.codepresso.cheerup.vo.Interview;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InterviewMapper {
    
    //유저가 선택한 카테고리의 정보만 가져오기
    List<Interview> getSelectedList(Interview interview);

    List<Interview> getSingleList(String category_origin);
    List<Interview> getMultiList(String[] multiArray);

    List<Interview> getProgrammingList(String category, int limitCount);

    List<Interview> getData_structureList(String category, int limitCount);

    List<Interview> getAlgorithmList(String category, int limitCount);

    List<Interview> getDatabaseList(String category, int limitCount);

    List<Interview> getNetworkList(String category, int limitCount);

    List<Interview> getOsList(String category, int limitCount);

    List<Interview> getPersonalityList(String category, int limitCount);

    List<Interview> getSurpriseList(String category, int limitCount);

    int insertUserResponse(String id, @Param("id_array") String[] id_array, @Param("answer_array") String[] answer_array);
}
