package com.company.app.controllers;

import com.company.app.entities.Chat;
import com.company.app.entities.Message;
import com.company.app.entities.User;
import com.company.app.services.ChatService;
import com.company.app.services.MessageService;
import com.company.app.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(userService.getusers());
    }

    @PostMapping(value = "/users/add")
    public ResponseEntity createUser(@RequestBody User user) {
        User result = userService.save(user);
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/chats/add")
    public ResponseEntity createChat(@RequestBody Chat chat) {
        Chat createChat = chatService.save(chat);
        return ResponseEntity.ok(createChat);
    }

    @PostMapping(value = "/message/add")
    public ResponseEntity message(@RequestBody Message message) {
        Message sendMessage = messageService.save(message);
        return ResponseEntity.ok(sendMessage);
    }

//    @GetMapping(value = "/chats/get")
//    public ResponseEntity getAllChats(){
//        return ResponseEntity.ok();
//    }


//    @GetMapping(value = "/message/get")
//    public ResponseEntity getMessage(){
//        return ResponseEntity.ok();
//    }




}
