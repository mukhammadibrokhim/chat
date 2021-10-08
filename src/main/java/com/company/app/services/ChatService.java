package com.company.app.services;

import com.company.app.entities.Chat;
import com.company.app.repositories.ChatRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public Chat save(Chat chat) {
        return chatRepository.save(chat);
    }
}
