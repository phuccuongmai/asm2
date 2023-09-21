package com.example.service;



import com.example.model.entity.Member;

public interface MemberService {
    boolean save(Member member);

    boolean update(Member member);

    void delete(int id);

    Member findMemberByUserName(String username);

    Member findMemberByEmail(String email);
}
