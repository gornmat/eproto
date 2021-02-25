package com.demo.eproto.service;

import com.demo.eproto.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

//    public User getAccount(Long id) {
//        return repository.findById(id).orElseThrow(AccountNotFoundException::new);
//    }
//
//    public void createAccount(User user) {
//        repository.save(user);
//    }
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
