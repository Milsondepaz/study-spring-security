package com.milsondev.studyspringsecurity.controller;

import com.milsondev.studyspringsecurity.models.User;
import com.milsondev.studyspringsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/registration")
public class UserRegistrationController {

    private final UserService userService;

    @Autowired
    public UserRegistrationController(final UserService userService ){
        this.userService = userService;
    }

    @ModelAttribute("user")
    public User userRegistration () {
        return new User();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", userRegistration ());
        return "registration";
    }

    @PostMapping
    public String registrationUser(@ModelAttribute ("user") User user ) {
        userService.save(user);
        return "redirect:/api/v1/registration?success";
    }



}
