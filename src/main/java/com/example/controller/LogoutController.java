package com.example.controller;

import com.example.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String doGet(HttpSession session) {
        session.invalidate();
        return "login";
    }
}
