package com.example.controller;

import com.example.model.entity.Member;
//import com.example.model.mapper.MemberMapper;
import com.example.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    MemberService memberService;

//    @Autowired
//    MemberMapper memberMapper;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String doGet() {
        return "login";
    }

    @PostMapping("/login")
    public String doPost(Model model, HttpSession session, @RequestParam String email, @RequestParam String password) {
        String showError = null;

        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
            showError = "Please enter Email and Password!";
            model.addAttribute("showError", showError);
            return "login";
        }

        Member member = memberService.findMemberByEmail(email);
        model.addAttribute("email", email);

        if (member == null || !BCrypt.checkpw(password, member.getPassword())) {
            showError = "Email or Password is Incorrect!";
            model.addAttribute("showError", showError);
            return "login";
        } else {
            model.addAttribute("email", email);
            session.setAttribute("userLogin", member);
            return "welcome";
        }
    }
}

