package com.codepresso.cheerup.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class Interview {

    private Integer interview_id;
    private String category;
    private String content;
    private Integer output;
    private Integer failure_late;
    private LocalDateTime createdAt;

}
