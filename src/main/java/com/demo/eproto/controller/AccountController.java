package com.demo.eproto.controller;

import com.demo.eproto.model.Account;
import com.demo.eproto.model.AccountDTO;
import com.demo.eproto.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping("createAccount")
    public String createStudent(@ModelAttribute Account account) {
        service.createAccount(account);
        return "register";
    }

    @GetMapping("userLogin")
    public String login(@ModelAttribute AccountDTO accountDTO) {
        if (!service.login(accountDTO)) {
            return "register";
        }
        return service.isTeacher(accountDTO.getLogin()) ?
                "portalTeacher" :
                "portalParent";
//        return "portalTeacher";
//        return "portalParent";
    }

//    @GetMapping
//    public Account getAccount(@RequestParam("id") Long id) {
//        return service.getAccount(id);
//    }

//    @GetMapping("/register")
//    public String register() {
////    public String register(Model model, @RequestParam("id") Long id) {
////        var acc = service.getAccount(id);
////        model.addAttribute("accName", acc.getLogin());
//        return "register";
//    }

}
