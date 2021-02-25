package com.demo.eproto.controller;

import com.demo.eproto.model.User;
import com.demo.eproto.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@AllArgsConstructor
public class ViewController {

    private static final Logger LOGGER = Logger.getLogger(ViewController.class.getName());
    private final UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping({"/index", "/"})
    public String index() {
        return "index";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("createAccount")
    public String createStudent(@ModelAttribute("user") User user) {
        LOGGER.info("TEST");
        userService.createAccount(user);
        return "login";
    }


    //View -- START
//TMP
//    @GetMapping("indexView")
//    public String index() {
//        return "index";
//    }
//
//    @GetMapping("loginView")
//    public String login(Model model) {
//        AccountDTO accountDTO = new AccountDTO();
//        model.addAttribute("accountDTO", accountDTO);
//        return "login";
//    }
//


    //NOT TMP
//    @GetMapping("portalTeacher")
//    public String loginTeacher() {
//        return "portalTeacher";
//    }

    //View -- STOP
    //Account -- START

//    TMP
//    @PostMapping("createAccount")
//    public String createStudent(Account account) {
//        accountService.createAccount(account);
//        return "register";
//    }
//
//    @GetMapping("userLogin")
//    public String login(Model model, AccountDTO accountDTO) {
//        if (!accountService.login(accountDTO)) {
//            return "register";
//        }
//        if(accountService.isTeacher(accountDTO.getLogin())) {
//            return "portalTeacher";
//        } else {
//            Account account = accountService.getAccountByLogin(accountDTO);
//
//            return "portalParent";
//        }
//    }

    //Account -- STOP
    //Student -- START

//    @GetMapping("portalParent")
//    public String loginParent(@ModelAttribute Account account, Model model) {
//        var student = studentService.getStudentByParent(account.getId());
//        model.addAttribute("student", student);
//
//        return "portalParent";
//    }

    //Student -- STOP
}
