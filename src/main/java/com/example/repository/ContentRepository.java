package com.example.repository;


import com.example.model.entity.Content;
import com.example.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
    List<Content> findByMember(Member member);

    List<Content> findByMemberAndTitle(Member member, String title);

    Content findContentById(int id);
}
