package com.example.validator;

import com.example.model.entity.Member;
import com.example.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MemberValidator implements Validator {

    @Autowired
    private MemberService memberService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Member.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Member member = (Member) target;

        // Kiểm tra dưới username đã tồn tại hay chưa
        if (memberService.findMemberByUserName(member.getUserName()) != null) {
            errors.rejectValue("userName", "error.userName", "Username already exists!");
        }

        // Kiểm tra dưới email đã tồn tại hay chưa
        if (memberService.findMemberByEmail(member.getEmail()) != null) {
            errors.rejectValue("email", "error.email", "Email already exists!");
        }

        // Kiểm tra mật khẩu và mật khẩu xác nhận
        if (!member.getPassword().equals(member.getPassword())) {
            errors.rejectValue("rePassword", "error.rePassword", "Password and RePassword do not match!");
        }
    }
}

