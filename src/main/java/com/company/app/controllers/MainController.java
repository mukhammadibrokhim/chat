package com.company.app.controllers;

import com.company.app.entities.Chat;
import com.company.app.entities.Message;
import com.company.app.entities.User;
import com.company.app.services.ChatService;
import com.company.app.services.MessageService;
import com.company.app.services.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainController {

    private final UserService userService;
    private final ChatService chatService;
    private final MessageService messageService;

    public MainController(UserService userService, ChatService chatService, MessageService messageService) {
        this.userService = userService;
        this.chatService = chatService;
        this.messageService = messageService;

    }

    @GetMapping("/getAllUsers")
    public ResponseEntity getUser() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping(value = "/users/add")
    public ResponseEntity createUser(@RequestBody User user) {
        User result = userService.save(user);
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/chats/add")
    public ResponseEntity createChat(@RequestBody Chat chat) {
        Chat chat1 = chatService.save(chat);
        return ResponseEntity.ok(chat1);
    }

    @PostMapping(value = "/message/add")
    public ResponseEntity messageSend(@RequestBody Message message) {
        Message sendMessage = messageService.save(message);
        return ResponseEntity.ok(sendMessage);
    }

    @PostMapping(value = "/chats/get")
    public ResponseEntity getAllChats(@RequestBody User user) {
        return ResponseEntity.ok(chatService.getAllChats(user));
    }


    @PostMapping(value = "/message/get")
    public ResponseEntity getMessage(@RequestBody Chat chat) {
        return ResponseEntity.ok(messageService.getAllMessagesDateDesc(chat));
    }


}
