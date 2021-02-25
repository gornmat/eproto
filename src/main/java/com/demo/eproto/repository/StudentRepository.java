package com.demo.eproto.repository;

import com.demo.eproto.model.Student;
import com.demo.eproto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> getStudentByIdParent(Long idParent);

}