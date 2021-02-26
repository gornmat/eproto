package com.demo.eproto.repository;

import com.demo.eproto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserByUserName(String userName);

    List<User> getAllByClazzAndRole(String clazz, String role);
}
