package com.codepresso.cheerup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class adminController {
    @GetMapping("/admin/boardAdmin")
    public String Admin() {
        return "admin/boardAdmin";
    }


    @GetMapping("/admin/freeBoard")
    public String adminFreeBoard() {
        return "admin/freeboardAdmin";}

    @GetMapping("/admin/review")
    public String adminReview() {
        return "admin/reviewAdmin";}

    @GetMapping("/admin/feedback")
    public String adminFeedback() {
        return "admin/feedbackAdmin";}



}
