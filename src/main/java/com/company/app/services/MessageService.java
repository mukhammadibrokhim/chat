package com.company.app.services;

import com.company.app.entities.Chat;
import com.company.app.entities.Message;
import com.company.app.entities.User;
import com.company.app.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final ChatService chatService;
    private final UserService userService;

    public MessageService(MessageRepository messageRepository, ChatService chatService, UserService userService) {
        this.messageRepository = messageRepository;
        this.chatService = chatService;
        this.userService = userService;
    }


    public Message save(Message message) {
        message.setCreatedAt(new Date());
        return messageRepository.save(message);
    }

    public List<Message> messageList() {
        return messageRepository.findAll();
    }

    public ArrayList getAllMessagesDateDesc(Chat chat) {
        List<Message> messages = messageRepository.getAllByChatOrderByCreatedAtDesc(chat);
        for (Message message : messages) {
            if (message.getChat().getId().equals(chat.getId())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(messages);
                return arrayList;
            }
        }
        return null;
    }
}
