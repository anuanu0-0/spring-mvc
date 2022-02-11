package com.example.springmvc.RegexValidation;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class LoginController {

    @GetMapping("/")
    public String getForm(User user) {
        return "login";
    }

    @PostMapping("/")
    public String login(@Valid User user, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "login";
        } else {
            model.addAttribute("message", "Guest login successful ...");
            return "login";
        }

    }
}