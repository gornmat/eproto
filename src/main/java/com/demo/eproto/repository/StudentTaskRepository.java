package com.demo.eproto.repository;

import com.demo.eproto.model.StudentTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentTaskRepository extends JpaRepository<StudentTask, Long> {

}
