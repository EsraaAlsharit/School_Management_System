package com.Esraa.project.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Esraa.project.models.LoginManager;
import com.Esraa.project.models.LoginUser;
import com.Esraa.project.models.Manager;
import com.Esraa.project.models.Student;
import com.Esraa.project.models.Subject;
import com.Esraa.project.models.Teacher;
import com.Esraa.project.models.User;
import com.Esraa.project.services.GuardiansService;
import com.Esraa.project.services.ManagerServices;
import com.Esraa.project.services.StudentServices;
import com.Esraa.project.services.SubjectServices;
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
    UserService userServ;
    @Autowired
    ManagerServices ManagerServ;
    @Autowired
    SubjectServices subService;

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("user_id") == null
                && session.getAttribute("teacher_id") == null
                && session.getAttribute("student_id") == null
                && session.getAttribute("admin_id") == null) {
            model.addAttribute("newUser", new User());
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        } else {
            return "redirect:/index";
        }
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null
                || session.getAttribute("teacher_id") != null
                || session.getAttribute("student_id") != null
                || session.getAttribute("admin_id") != null) {
            // session.removeAttribute("user_id");
            session.invalidate();// destroy all
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
        }
        if (session.getAttribute("admin_id") != null) {
            Manager manager = ManagerServ.findManagerBy((Long) session.getAttribute("admin_id"));
            model.addAttribute("manger", manager);
            model.addAttribute("students", studentService.allStudents());
            model.addAttribute("users", userServ.AllUsers());
            model.addAttribute("subjects", subService.AllSubjects());
            model.addAttribute("teachers", teacherService.allTeachers());
            return "adminHome.jsp";
        } else {
            return "redirect:/";
        }
    }

    // admin || manager
    @GetMapping("/admin")
    public String adminForm(Model model, HttpSession session) {
        if (session.getAttribute("user_id") == null
                && session.getAttribute("teacher_id") == null
                && session.getAttribute("student_id") == null
                && session.getAttribute("admin_id") == null) {
            model.addAttribute("newUser", new Manager());
            model.addAttribute("newLogin", new LoginManager());
            return "admins.jsp";
        } else {
            return "redirect:/index";
        }
    }

    @PostMapping("/login/admin")
    public String adminLogin(@Valid @ModelAttribute("newLogin") LoginManager newLogin,
            BindingResult result, Model model, HttpSession session) {
        Manager manager = ManagerServ.login(newLogin, result);
        if (result.hasErrors()) {
            model.addAttribute("newUser", new Manager());
            return "admins.jsp";
        }
        session.setAttribute("admin_id", manager.getId());
        return "redirect:/";
    }

    @GetMapping("/teacher/{id}")
    public String Teacher(Model model, HttpSession session,@PathVariable("id") Long id) {
        if (session.getAttribute("admin_id") == null) {
            model.addAttribute("teacher", teacherService.findTeacherBy(id));
            return "Teacher.jsp";
        } else {
            return "redirect:/index";
        }
    }
    @GetMapping("/student/{id}")
    public String Student(Model model, HttpSession session,@PathVariable("id") Long id) {
        if (session.getAttribute("admin_id") == null) {
            model.addAttribute("student", studentService.findStudentBy(id));
            return "Student.jsp";
        } else {
            return "redirect:/index";
        }
    }

    @PostMapping("/register/admin")
    public String adminRegister(@Valid @ModelAttribute("newUser") Manager manger,
            BindingResult result, Model model, HttpSession session) {
        ManagerServ.register(manger, result);
        if (result.hasErrors()) {
            model.addAttribute("newLogin", new LoginManager());
            return "admins.jsp";
        }
        session.setAttribute("admin_id", manger.getId());
        return "redirect:/";
    }
    // subject

    @GetMapping("/add/subject")
    public String newSubject(@ModelAttribute("subject") Subject subject, Model model) {
        return "addSubject.jsp";
    }

    @PostMapping("/add/subject")
    public String addSubject(@Valid @ModelAttribute("subject") Subject subject, BindingResult result) {
        if (result.hasErrors()) {
            return "addSubject.jsp";
        } else {
            subService.creatSubject(subject);
            return "teacherHome.jsp";
        }
    }

    @PostMapping("/role/{id}")
    public String newSubject(@PathVariable("id") Long id, @RequestParam("role") String role, Model model) {
        User user = userServ.findUserBy(id);
        if (role.equals("student")) {
            Student student = new Student();
            student.setEmail(user.getEmail());
            student.setfName(user.getfName());
            student.setlName(user.getlName());
            student.setPassword(user.getPassword());
            studentService.createStudent(student);
            userServ.deleteUser(id);
        } else if (role.equals("teacher")) {
            Teacher teacher = new Teacher();
            teacher.setEmail(user.getEmail());
            teacher.setfName(user.getfName());
            teacher.setlName(user.getlName());
            teacher.setPassword(user.getPassword());
            teacherService.createTeacher(teacher);
            userServ.deleteUser(id);
        }
        return "redirect:/index";
    }

}
