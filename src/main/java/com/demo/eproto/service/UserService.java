package com.demo.eproto.service;

import com.demo.eproto.exception.UserNotFoundException;
import com.demo.eproto.model.User;
import com.demo.eproto.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
    private final UserRepository repository;

    public void createUser(User user) {
        var password = crypt.encode(user.getPassword());
        user.setPassword(password);
        user.setEnabled(true);
        repository.save(user);
    }

    public User getUserByName(String userName) {
        return repository.getUserByUserName(userName).orElseThrow(UserNotFoundException::new);
    }

    public List<User> getUsersByClazz(String clazz) {
        return repository.getAllByClazzAndRole(clazz, "ROLE_USER");
    }
}
