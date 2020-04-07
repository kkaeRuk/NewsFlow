package com.example.newsflow.webapp.user.kakao.controller;

import com.example.newsflow.webapp.user.kakao.service.KakaoAPI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Api(tags = {"2.KakaoLogin"})
@Controller
@RequestMapping(value = "/user/kakao")
public class KakaoUserController {

    @Autowired
    private KakaoAPI kakao;

    @ApiOperation(value = "카카오 OAUTH 로그인")
    @ApiImplicitParam(name = "code", value = "코드", required = true, dataType = "string", paramType = "query", defaultValue = "")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(@RequestParam("code") String code, HttpSession session) {
        String access_Token = kakao.getAccessToken(code);
        HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
         System.out.println("userInfo : " + userInfo);
        if (userInfo.get("nickname") != null) {
            session.setAttribute("userId", userInfo.get("nickname"));
            session.setAttribute("access_Token", access_Token);
        }
        return "redirect:/user/base/login";
    }
    @ApiOperation(value = "카카오 OAUTH 로그아웃")
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        kakao.kakaoLogout((String)session.getAttribute("access_Token"));
        session.removeAttribute("access_Token");
        session.removeAttribute("userId");
        return "redirect:/user/base/login";
    }

}
