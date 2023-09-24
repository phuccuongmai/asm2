package com.example.controller;

import com.example.model.entity.Member;
import com.example.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EditProfileController {

    @Autowired
    MemberService memberService;

    @GetMapping(value = "/user-profile")
    public String memberView(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        model.addAttribute("member", member);
        return "editProfile";
    }

    @PostMapping(value = "/update-profile")
    public String memberEdit(@RequestBody Member member) {
        Member dbmember = memberService.findMemberByEmail(member.getEmail());
        dbmember.setFirstName(member.getFirstName());
        dbmember.setLastName(member.getLastName());
        dbmember.setPhone(member.getPhone());
        dbmember.setDescription(member.getDescription());
        memberService.update(dbmember);
        return "redirect:/home";
    }
}