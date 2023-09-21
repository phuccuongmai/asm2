package com.example.controller;


import com.example.model.entity.Member;
import com.example.service.MemberService;
import com.example.validator.MemberValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class RegisterController {

    @Autowired
    private MemberValidator memberValidator;

    @Autowired
    private MemberService memberService;

    @GetMapping(value = "/register")
    public String showPage(Model model) {
        Member member = new Member();

        model.addAttribute("member", member);
        return "register";
    }

    @PostMapping(value = "/register")
    public String submit(Model model, @ModelAttribute("member") @Valid Member member, BindingResult bindingResult) {
        memberValidator.validate(member, bindingResult);

        // validator
        if (bindingResult.hasErrors()) {
            model.addAttribute("member", member);
            return "register";
        }

        // register for new user
        memberService.save(member);
        return "redirect:/login";
    }

}

