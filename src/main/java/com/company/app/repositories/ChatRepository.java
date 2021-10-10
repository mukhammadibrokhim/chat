package com.company.app.repositories;

import com.company.app.entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {

//    @Query(value = "SELECT * FROM chat ORDER BY created_at DESC")
    @Query(
            value = "SELECT * FROM chat u WHERE u.createdAt = ?1",
            nativeQuery = true)
    List<Chat> getAllByCreatedAt();
}
