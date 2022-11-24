package com.codepresso.cheerup.dao;

import com.codepresso.cheerup.vo.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    //회원가입
    int insertMember(Member member);

    //로그인
    String loginCheck(String id, String password);
}
