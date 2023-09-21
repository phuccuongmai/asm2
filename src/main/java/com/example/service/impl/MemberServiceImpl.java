package com.example.service.impl;

import com.example.model.entity.Member;
import com.example.repository.MemberRepository;
import com.example.service.MemberService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public boolean save(Member member) {
        try {
            if (member != null) {
                String hashedPassword = BCrypt.hashpw(member.getPassword(), BCrypt.gensalt());
                member.setPassword(hashedPassword);
                memberRepository.save(member);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Member member) {
        int id = member.getId();
        Optional<Member> result = memberRepository.findById(id);
        if (result.isPresent()) {
            Member member1 = result.get();
            member1.setFirstName(member.getFirstName());
            member1.setLastName(member.getLastName());
            member1.setPhone(member.getPhone());
            member1.setDescription(member.getDescription());
            memberRepository.save(member1);
            return true;
        }
        return false;
    }

    @Override
    public void delete(int id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Member findMemberByUserName(String username) {
       return memberRepository.findMemberByUserName(username);
    }

    @Override
    public Member findMemberByEmail(String email) {
        return memberRepository.findMemberByEmail(email);
    }
}
