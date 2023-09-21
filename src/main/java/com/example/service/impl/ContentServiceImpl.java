package com.example.service.impl;

import com.example.repository.ContentRepository;
import com.example.repository.MemberRepository;
import com.example.model.entity.Content;
import com.example.model.entity.Member;
import com.example.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    ContentRepository contentRepository;

    @Autowired
    MemberRepository memberRepository;


    @Override
    public List<Content> findByMember(int memberId) {
        Member member = new Member();
        member.setId(memberId);

        return contentRepository.findByMember(member);
    }

    @Override
    public List<Content> findAll() {
        return contentRepository.findAll();
    }

    @Override
    public List<Content> findByMemberAndTitle(int memberId, String title) {
        Member member = new Member();
        member.setId(memberId);
        return contentRepository.findByMemberAndTitle(member, title);
    }

    @Override
    public boolean save(Content content, int memberId) {
        Member member = memberRepository.findMemberById(memberId);
        if (member != null) {
            content.setMember(member);
            contentRepository.save(content);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Content content) {
        int id = content.getId();
        Optional<Content> result = contentRepository.findById(id);
        if (result.isPresent()) {
            Content content1 = result.get();
            content1.setTitle(content.getTitle());
            content1.setBrief(content.getBrief());
            content1.setContent(content.getContent());
            contentRepository.save(content1);
            return true;
        }
        return false;
    }

    @Override
    public void delete(int id) {
        contentRepository.deleteById(id);
    }

    @Override
    public Content findById(int id) {
        return contentRepository.findContentById(id);
    }
}
