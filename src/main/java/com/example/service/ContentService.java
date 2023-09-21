package com.example.service;

import com.example.model.entity.Content;

import java.util.List;

public interface ContentService {

    List<Content> findByMember(int memberId);

    List<Content> findAll ();

    List<Content> findByMemberAndTitle(int memberId, String title);

    boolean save(Content content, int memberId);

    boolean update(Content content);


    void delete(int id);

    Content findById(int id);


}
