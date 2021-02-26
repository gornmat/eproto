package com.demo.eproto.repository;

import com.demo.eproto.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> getAllByIdParentAndEnabled(Long id, boolean enabled);

}
