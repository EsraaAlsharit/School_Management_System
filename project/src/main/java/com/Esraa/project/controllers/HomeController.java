package com.Esraa.project.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Esraa.project.services.GuardiansService;
import com.Esraa.project.services.StudentServices;
import com.Esraa.project.services.TeacherServices;

@Controller
public class HomeController {

    @Autowired
    StudentServices studentService;

    @Autowired
    TeacherServices teacherService;

    @Autowired
    GuardiansService guardiansService;

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("user_id") == null) {
//             model.addAttribute("newUser", new User());
//             model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        } else {
            return "redirect:/";
        }
    }
}
