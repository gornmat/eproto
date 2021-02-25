package com.demo.eproto.service;

import com.demo.eproto.model.User;
import com.demo.eproto.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
    private final UserRepository repository;

    //    public User getAccount(Long id) {
//        return repository.findById(id).orElseThrow(AccountNotFoundException::new);
//    }
//
    public void createAccount(User user) {
        var password = crypt.encode(user.getPassword());
        user.setPassword(password);
        user.setEnabled(true);
        repository.save(user);
    }
//
//    public User getAccountByLogin(AccountDTO accountDTO) {
//        return repository.getAccountByLogin(accountDTO.getLogin())
//                .orElse(new User());
//    }
//
//    public boolean login(AccountDTO accountDTO) {
//        User existingUser = repository.getAccountByLogin(accountDTO.getLogin()).orElseThrow(AccountNotFoundException::new);
//        return existingUser.getPassword().equals(accountDTO.getPassword());
//    }
//
//    public boolean isTeacher (String login) {
//        return repository.getAccountByLogin(login)
//                .map(User::isTeacher)
//                .orElseThrow(AccountNotFoundException::new);
//    }
}
