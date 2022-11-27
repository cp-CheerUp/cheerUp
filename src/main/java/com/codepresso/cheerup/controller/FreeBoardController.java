package com.codepresso.cheerup.controller;

import com.codepresso.cheerup.service.FreeBoardService;
import com.codepresso.cheerup.vo.FreeBoard;
import com.codepresso.cheerup.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(path="freeboard")
public class FreeBoardController {
    private final FreeBoardService freeBoardService;

    @GetMapping("/main")
    public String freeboard(Model model, FreeBoard freeBoard, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String user = ((User) userDetails).getId();

        List<FreeBoard> list = new ArrayList<>();
        list = freeBoardService.getAllFreeBoardList();

        model.addAttribute("freeboardList", list);
        model.addAttribute("user", user);

        return "freeBoard/freeboard";
    }

    @GetMapping("/view")
    public String freeboardView(Model model, @RequestParam int boardNo, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String user = ((User) userDetails).getId();

        FreeBoard freeBoardDetail = freeBoardService.getFreeBoardDetail(boardNo);

        model.addAttribute("freeboardDetail", freeBoardDetail);
        model.addAttribute("user", user);
        return "freeBoard/freeboardView";
    }

    @GetMapping("/write")
    public String freeboardWrite() {
        return "freeBoard/freeboardWrite";
    }
}
