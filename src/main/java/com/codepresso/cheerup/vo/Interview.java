package com.codepresso.cheerup.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@Data
public class Interview {

    private String interview_id;
    private String category;
    private String content;
    private String output;
    private String failure_late;

}
