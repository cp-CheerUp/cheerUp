package com.codepresso.cheerup.dao;

import com.codepresso.cheerup.vo.Interview;
import com.codepresso.cheerup.vo.Interview_response;
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

    int insertUserResponse2(String id, String interview_id, String interview_answer);

    void updateTotalCount(String id_array);

    List<Interview> getResponseList(String[] id_array);

//    int getRowCount();

    void insertFailCount( @Param("failId") String[] failId );

    void updateFailCounting(@Param("id_list") List<Object> id_list);

    void updateFailCounting2(String failId);

    int getPgCount(@Param("id")String id);

    int getDsCount(@Param("id") String id);

    int getAgCount(@Param("id") String id);

    int getDbCount(@Param("id") String id);

    int getNwCount(@Param("id") String id);

    int getOsCount(@Param("id") String id);

    int getPsCount(@Param("id") String id);

    int getSpCount(@Param("id")  String id);

    List<Interview> getFailList(String id);
}
