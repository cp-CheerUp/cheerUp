package com.codepresso.cheerup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeedbackBoardController {
    @GetMapping("/feedback")
    public String feedbackBoard() {
        return "feedbackBoard/feedback";
    }
}
