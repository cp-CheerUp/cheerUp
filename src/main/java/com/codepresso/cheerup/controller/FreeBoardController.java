package com.codepresso.cheerup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FreeBoardController {
    @GetMapping("/freeboard")
    public String freeboard() {
        return "freeBoard/freeboard";
    }
}
