package com.mahel.chatApp.chat.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatUserController {

    private final ChatUserService chatUserService;

    @MessageMapping("/user.addUser")
    @SendTo("/user/topic")
    public ChatUser addChatUser(@PathVariable ChatUser chatUser) {
        chatUserService.saveChatUser(chatUser);
        return chatUser;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/topic")
    public ChatUser disconnect(@PathVariable ChatUser chatUser) {
        chatUserService.disconnect(chatUser);
        return chatUser;
    }

    @GetMapping("/users")
     public ResponseEntity<List<ChatUser>> findConnectedUsers() {
        return ResponseEntity.ok(chatUserService.findConnectedUsers());
     }
 }
