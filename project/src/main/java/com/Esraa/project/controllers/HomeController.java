package com.Esraa.project.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Esraa.project.models.LoginUser;
import com.Esraa.project.models.User;
import com.Esraa.project.services.GuardiansService;
import com.Esraa.project.services.StudentServices;
import com.Esraa.project.services.UserService;
import com.Esraa.project.services.TeacherServices;

@Controller
public class HomeController {

    @Autowired
    StudentServices studentService;

    @Autowired
    TeacherServices teacherService;

    @Autowired
    GuardiansService guardiansService;

    @Autowired
    private UserService userServ;

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("user_id") == null) {
            model.addAttribute("newUser", new User());
            model.addAttribute("newLogin", new LoginUser());
            return "forms.jsp";
        } else {
            return "redirect:/shows";
        }
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            session.removeAttribute("user_id");
            // session.invalidate();//destroy all
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

    // @PostMapping("/register")
    // public String register(@Valid @ModelAttribute("newTeacher") Teacher newUser,
    // BindingResult result, Model model, HttpSession session) {
    // teacherService.register(newUser, result);
    // if (result.hasErrors()) {
    // model.addAttribute("newLogin", new LoginUser());
    // return "forms.jsp";
    // }
    // session.setAttribute("user_id", newUser.getId());
    // return "redirect:/shows";
    // }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser,
            BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if (result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "forms.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/shows";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
            BindingResult result, Model model, HttpSession session) {
        userServ.login(newLogin, result, session);
        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "forms.jsp";
        }

        return "redirect:/shows";
    }

}
