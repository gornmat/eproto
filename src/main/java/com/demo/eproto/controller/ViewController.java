package com.demo.eproto.controller;

import com.demo.eproto.model.Account;
import com.demo.eproto.model.AccountDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("login")
    public String login(Model model) {
        AccountDTO accountDTO = new AccountDTO();
        model.addAttribute("accountDTO", accountDTO);
        return "login";
    }

    @GetMapping("register")
    public String register(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "register";
    }

    @GetMapping("portalTeacher")
    public String loginTeacher() {
        return "portalTeacher";
    }

    @GetMapping("portalParent")
    public String loginParent() {
        return "portalParent";
    }

}
