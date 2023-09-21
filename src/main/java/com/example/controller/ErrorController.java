package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public String handleError(Model model) {
        String errorMessage = "Page not found";
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

}