package com.demo.eproto.controller;

import com.demo.eproto.model.Student;
import com.demo.eproto.model.User;
import com.demo.eproto.service.StudentService;
import com.demo.eproto.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class AppController {

    private final UserService userService;
    private final StudentService studentService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping({"/index", "/"})
    public ModelAndView index() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var user = userService.getUserByName(authentication.getName());
        var role = authentication.getAuthorities().stream().findFirst().get().toString();

        ModelAndView mav = new ModelAndView("index");
        if ("ROLE_ADMIN".equals(role)) {
            //wyswietlanie nauczyciel
        }

        if ("ROLE_USER".equals(role)) {
            var student = studentService.getStudentByIdParent(user.getId());
            mav.addObject("student", student);
        }

        return mav;
    }

    @RequestMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("createAccount")
    public String createAccount(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "login";
    }

    @PostMapping("saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/";
    }
}
