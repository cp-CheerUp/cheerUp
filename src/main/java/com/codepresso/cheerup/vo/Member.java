package com.codepresso.cheerup.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private String id;
    private String password;
    private String name;
    private String phone;
    private String role;
    private String education;
    private String isMajor;

}
