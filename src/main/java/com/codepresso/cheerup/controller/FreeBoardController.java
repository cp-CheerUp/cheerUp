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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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
    public String freeboardWrite(Model model, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String user = ((User) userDetails).getId();

        model.addAttribute("user", user);
        return "freeBoard/freeboardWrite";
    }

    @PostMapping("/insert")
    public String insertFreeBoard(Model model, FreeBoard freeBoard) {
        int insertFreeBoard = freeBoardService.insertFreeBoard(freeBoard);
        return "redirect:main";
    }

    @PostMapping("/update")
    public String updateFreeBoard(Model model, HttpServletRequest httpServletRequest) {
        FreeBoard freeBoard = new FreeBoard();
        freeBoard.setBoardNo(Integer.parseInt(httpServletRequest.getParameter("md-boardNo")));
        freeBoard.setTitle(httpServletRequest.getParameter("md-title"));
        freeBoard.setContent(httpServletRequest.getParameter("md-content"));

        int updateFreeBoard = freeBoardService.updateFreeBoard(freeBoard);
        return "redirect:view?boardNo="+freeBoard.getBoardNo();
    }

    @GetMapping("/delete")
    public String deleteFreeBoard(Model model, @RequestParam int boardNo) {
        int result = freeBoardService.deleteFreeBoard(boardNo);
        if (result == 1) {
            return "redirect:main";
        } else {
            return "삭제가 되지 않았습니다.";
        }
    }
}
