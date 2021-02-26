package com.demo.eproto.service;

import com.demo.eproto.model.Message;
import com.demo.eproto.model.User;
import com.demo.eproto.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MessageService {

    private final MessageRepository repository;

    public void sendMessage(List<User> parents, String message, User teacher) {
        List<Message> messages = new ArrayList<>();
        parents.forEach(parent -> {
            var newMessage = new Message();
            newMessage.setIdTeacher(teacher.getId());
            newMessage.setIdParent(parent.getId());
            newMessage.setMessageText(message);
            newMessage.setEnabled(true);
            messages.add(newMessage);
        });
        repository.saveAll(messages);
    }

    public List<Message> getMessages(Long id) {
        return repository.getAllByIdParentAndEnabled(id, true);
    }

    public void readMessage(Long id) {
        var message = repository.findById(id).get();
        message.setEnabled(false);
        repository.save(message);
    }

}
