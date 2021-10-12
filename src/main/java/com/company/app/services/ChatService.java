package com.company.app.services;

import com.company.app.entities.Chat;
import com.company.app.entities.User;
import com.company.app.repositories.ChatRepository;
import com.company.app.repositories.MessageRepository;
import com.company.app.repositories.UserRepository;
import org.springframework.data.domain.Sort;
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

    public Chat getChat(Integer id) {
        return chatRepository.getById(id);

    }

    public User getChatList(User user) {
        User user1 = userRepository.getById(user.getId());
        List<Chat> chat = chatRepository.findAllByOrderByCreatedAtDesc();
        for (int i = 0; i < chat.size(); i++) {


            if (user1.getCreatedAt().compareTo(chat.get(i)))
                return user1;
        }
    }
}
