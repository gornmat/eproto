package com.demo.eproto.controller;

import com.demo.eproto.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class ViewController {

    private final UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping({ "/index", "/" })
    public String index() {
        return "index";
    }

    @RequestMapping("/register")
    public String register() {
//        Account account = new Account();
//        model.addAttribute("account", account);
        return "register";
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
