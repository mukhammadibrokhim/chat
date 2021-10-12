package com.company.app.repositories;

import com.company.app.entities.Chat;
import com.company.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
    List<Chat> findAllByUsersOrderByCreatedAtDesc(User user);
}
