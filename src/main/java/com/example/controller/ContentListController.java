package com.example.controller;

import com.example.model.entity.Content;
//import com.example.model.mapper.ContentMapper;
import com.example.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContentListController {
    @Autowired
    ContentService contentService;

//    @Autowired
//    private ContentMapper contentMapper;

    @GetMapping(value = "/contents")
    public String showContent(Model model){
        List<Content> contentList = contentService.findAll();
        model.addAttribute("contentList", contentList);
        return "home";
    }

    @GetMapping(value = "/contents/{id}")
    public String showContentById(Model model, @PathVariable int id){
        Content contentList = contentService.findById(id);
        model.addAttribute("contentList", contentList);
        return "home";
    }
//
//    @GetMapping(value = "/editContent")
//    public String viewContent (HttpServletRequest req, Model model) {
//        HttpSession httpSession = req.getSession();
//        MemberDTO memberDTO = (MemberDTO) httpSession.getAttribute("member");
//        model.addAttribute("member", memberDTO);
//
//        ContentDTO contentDTO = new ContentDTO();
//        model.addAttribute("content", contentDTO);
//
//        return "editContent";
//    }

    @GetMapping(value = "/delete-content{id}")
    public String deleteContent (Model model, @RequestParam int id) {
        Content content = (Content) contentService.findById(id);
        if (content != null) {
            contentService.delete(id);
            return "redirect:/contents";
        }
        return "home";
    }

}
