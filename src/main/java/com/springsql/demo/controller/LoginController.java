package com.springsql.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class LoginController {

    @RequestMapping(value = "/login")
    public String login(String username, String userpwd) {
        return "登录成功";
    }
}
