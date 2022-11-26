package com.codepresso.cheerup.controller;

import com.codepresso.cheerup.service.UserService;
import com.codepresso.cheerup.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor //final 객체 생성자 생성
public class UserController {

    private final UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //회원가입 페이지 이동
    @GetMapping("/signup")
    public String signup(){
        return "user/manage/sign-up";
    }

    //로그인 페이지 이동
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false)String error,
                        @RequestParam(value = "exception", required = false)String exception,
                        Model model) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "user/manage/login";
    }

    //중복 아이디 처리
    @ResponseBody
    @PostMapping("/id-check")
    public int idChk(@RequestParam("id") String id) throws Exception {
        int result = userService.idChk(id);

        return result;
    }

    /*로그인체크
    @ResponseBody
    @PostMapping("/loginCheck")
    public String loginCheck(String id, String password, HttpSession session){


        System.out.println("컨트롤러의 User"+id+"와"+password);
        String view_pw = password;

        //id의 row 가져오기
        User user = this.userService.loadUserByUsername(id);

        System.out.println("db password"+user.getPassword());
        System.out.println("db encode_password"+passwordEncoder().encode(user.getPassword()));

        //회원일 때 View 처리
        if(user != null){

            //password 확인
            String db_pw = passwordEncoder().encode(user.getPassword());

                if(passwordEncoder().matches(view_pw,user.getPassword())){
                    //사용자 입력 password와 DB의 password 일치
                    session.setAttribute("id",id);
                    session.setAttribute("password",password);
                    session.setAttribute("role",user.getRole());

                    return "<script>alert('[안내] 로그인 성공');location.replace('/interview');</script>";

                }else{
                    //사용자 입력 password와 DB의 password 불일치
                    return "<script>alert('[안내] 로그인 실패 : 아이디와 비밀번호를 다시 확인해주세요.');location.replace('/login');</script>";
                }
        }else{
            //로그인 실패
            return "<script>alert('[안내] 로그인 실패 : 아이디와 비밀번호를 다시 확인해주세요.');location.replace('/login');</script>";
        }
    } */


    //로그아웃
    @GetMapping("/logout")
    public String logoutConfirm(HttpServletRequest request, HttpServletResponse response) {

        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());

        return "redirect:/login";
    }

    //회원가입 처리
    @ResponseBody
    @PostMapping("/register")
    public String register(User user, Model model, HttpServletResponse response) throws Exception {

        System.out.println("여기 컨트롤러인데요. 왔나요?");
        System.out.println("컨트롤러의 User"+user);

        //아이디 중복 확인
        String id = user.getId();
        int idCheck = userService.idChk(id);
        System.out.println(idCheck);

        //아이디 중복되지 않음 -> 회원 가입 처리
        if (idCheck == 0) {

            //아이디 중복되지 않음 -> 회원 가입 처리
            user.setRole("ROLE_USER");
            this.userService.insertMember(user);
            return "<script>alert('[안내] 회원가입 완료!');location.replace('/login');</script>";

        } else {
            //아이디 중복 -> 회원가입 취소
//            response.setContentType("text/html;charset=utf-8");
//            PrintWriter out = response.getWriter();
//            out.append("<script>");out.append("alert('[안내] 중복된 아이디입니다. 다른 아이디를 입력해주세요.');");
//            out.append("location.replace('/sighup');");
//            out.append("</script>");

            return "<script>alert('[안내] 중복된 아이디입니다. 다른 아이디를 입력해주세요.');location.replace('/sighup');</script>";
        }
    }


}