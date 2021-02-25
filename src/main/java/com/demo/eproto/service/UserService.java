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

    public void createUser(User user) {
        var password = crypt.encode(user.getPassword());
        user.setPassword(password);
        user.setEnabled(true);
        repository.save(user);
    }
}
