package com.example.newsflow.webapp.user.base.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Api(tags = {"1.Login"})
@Controller
@RequestMapping(value = "/user/base")
public class UserController {

    @ApiOperation(value = "로그인화면")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String main() {
        return "/user/base/login";
    }

}
