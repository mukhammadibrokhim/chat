package com.company.app.repositories;

import com.company.app.entities.Chat;
import com.company.app.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> getAllByChatOrderByCreatedAtDesc(Chat chat);
}
