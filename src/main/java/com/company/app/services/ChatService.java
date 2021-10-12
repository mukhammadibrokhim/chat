package com.company.app.services;

import com.company.app.entities.Chat;
import com.company.app.entities.User;
import com.company.app.repositories.ChatRepository;
import com.company.app.repositories.MessageRepository;
import com.company.app.repositories.UserRepository;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final UserService userService;

    public ChatService(ChatRepository chatRepository, UserRepository userRepository, MessageRepository messageRepository, UserService userService) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

    public Optional<Chat> getOne(Integer id) {
        return chatRepository.findById(id);
    }

    public Chat save(Chat chat) {
        chat.setCreatedAt(new Date());
        return chatRepository.save(chat);
    }

    public Object getAllChats(User user) {
        List<Chat> chats = chatRepository.findAllByUsersOrderByCreatedAtDesc(user);
        for (Chat chat : chats) {
            if (chat.getUsers().contains(user)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(chats);
                return arrayList;
            }
        }
        return null;
    }
}
