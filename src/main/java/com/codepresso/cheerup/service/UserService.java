package com.codepresso.cheerup.service;

import com.codepresso.cheerup.dao.UserMapper;
import com.codepresso.cheerup.vo.Member;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private UserMapper userMapper;

    public UserService(UserMapper _userMapper){
        this.userMapper = _userMapper;
    }

    //회원가입 처리
    @Transactional
    public int insertMember(Member member) {
        member.setRole("USER");
        int result = this.userMapper.insertMember(member);

        return result;
    }

    //로그인 처리
    public String loginCheck(String id, String password) {
        String role = userMapper.loginCheck(id,password);

        return role;
    }
}
