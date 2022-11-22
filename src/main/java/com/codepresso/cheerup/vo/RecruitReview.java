package com.codepresso.cheerup.vo;

import lombok.Data;

import java.util.Date;

@Data
public class RecruitReview {
    private int boardNo;
    private String title;
    private String content;
    private String category;
    private String writeId;
    private String regdate;
    private String company;
    private String codingDiff;
}
