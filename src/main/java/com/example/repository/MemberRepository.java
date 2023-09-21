package com.example.repository;

import com.example.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findMemberByUserName(String userName);
    Member findMemberById(int id);

    Member findMemberByEmail(String email);
}
