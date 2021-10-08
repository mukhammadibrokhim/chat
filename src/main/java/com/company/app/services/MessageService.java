package com.company.app.services;

import com.company.app.entities.Message;
import com.company.app.repositories.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    public Message save(Message message){
        return messageRepository.save(message);
    }
}
