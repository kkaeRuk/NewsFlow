package com.example.newsflow.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class OAuth2Controller {

    // 메인화면
    @GetMapping({"", "/"})
    public String getAuthorizationMessage() {
        return "home";
    }

    // 로그인화면
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // 로그인성공
    @GetMapping({"/loginSuccess", "/hello"})
    public String loginSuccess(Model model, Principal principal) {
        model.addAttribute("userID", principal.getName());
        return "hello";
    }

    // 로그인실패
    @GetMapping("/loginFailure")
    public String loginFailure() {
        return "loginFailure";
    }


    // 카카오 oauth 연결끊기(로그아웃X, 앱연결해제) 수정중
    @RequestMapping("/unlink")
    public String unlink() {
        return "redirect:login";
    }

}


