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
import com.Esraa.project.models.Student;
import com.Esraa.project.models.Teacher;
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
            return "index.jsp";
        } else {
            return "redirect:/index";
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

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser,
            BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if (result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/index";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
            BindingResult result, Model model, HttpSession session) {
        userServ.login(newLogin, result, session);
        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        return "redirect:/index";
    }

    @GetMapping("/index") // add form
    public String New(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            User user = userServ.findUserBy((Long) session.getAttribute("user_id"));
            model.addAttribute("User", user);
            return "userHome.jsp";
        }
        if (session.getAttribute("teacher_id") != null) {
            Teacher teacher = teacherService.findTeacherBy((Long) session.getAttribute("teacher_id"));
            model.addAttribute("Teacher", teacher);
            return "teacherHome.jsp";
        }
        if (session.getAttribute("student_id") != null) {
            Student student = studentService.findStudentBy((Long) session.getAttribute("student_id"));
            model.addAttribute("Student", student);
            return "studentHome.jsp";
        } else {
            return "redirect:/";
        }
    }

}
