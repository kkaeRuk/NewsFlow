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
    @GetMapping({"", "/"})
    public String getAuthorizationMessage() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping({"/loginSuccess", "/hello"})
    public String loginSuccess(Model model, Principal principal) {
        model.addAttribute("userID", principal.getName());
        return "hello";
    }

    @GetMapping("/loginFailure")
    public String loginFailure() {
        return "loginFailure";
    }

    @RequestMapping("/unlink")
    public String unlink() {
        return "redirect:login";
    }

}


