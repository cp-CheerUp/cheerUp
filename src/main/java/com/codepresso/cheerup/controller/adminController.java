package com.codepresso.cheerup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class adminController {
    @GetMapping("/admin/admintest")
    public String feedbackBoard() {
        return "admin/boardAdmin";
    }
}
