package com.codepresso.cheerup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="freeboard")
public class FreeBoardController {
    @GetMapping("/main")
    public String freeboard() {
        return "freeBoard/freeboard";
    }

    @GetMapping("/write")
    public String freeboardWrite() {
        return "freeBoard/freeboardWrite";
    }

    @GetMapping("/view")
    public String freeboardView() {
        return "freeBoard/freeboardView";
    }
}
