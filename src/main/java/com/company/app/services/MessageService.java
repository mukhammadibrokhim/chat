package com.company.app.services;

import com.company.app.entities.Chat;
import com.company.app.entities.Message;
import com.company.app.entities.User;
import com.company.app.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    public Message save(Message message) {
        message.setCreatedAt(new Date());
        return messageRepository.save(message);
    }

    public List<Message> messageList(){
        return messageRepository.findAll();
    }

//    public Message getAllMessagesDateDesc(){
//
//
//
//    }
}
