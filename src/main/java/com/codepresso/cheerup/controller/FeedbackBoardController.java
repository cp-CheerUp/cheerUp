package com.codepresso.cheerup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="feedback")
public class FeedbackBoardController {
    @GetMapping("/main")
    public String feedbackboard() {
        return "feedbackBoard/feedback";
    }

    @GetMapping("/write")
    public String feedbackboardWrite() {
        return "feedbackBoard/feedbackWrite";
    }

    @GetMapping("/view")
    public String feedbackboardView() {
        return "feedbackBoard/feedbackView";
    }
}
