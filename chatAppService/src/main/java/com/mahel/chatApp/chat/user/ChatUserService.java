package com.mahel.chatApp.chat.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatUserService {

    @Autowired
    private ChatUerRepository chatUerRepository;

    public void saveChatUser(ChatUser chatUser) {
        chatUser.setStatus(Status.ONLINE);
        chatUerRepository.save(chatUser);
    }

    public void disconnect(ChatUser chatUser) {
       var storedChatUser = chatUerRepository.findById(chatUser.getNickname())
               .orElse(null);
       if (storedChatUser != null) {
           storedChatUser.setStatus(Status.OFFLINE);
           chatUerRepository.save(storedChatUser);
       }
    }

    public List<ChatUser> findConnectedUsers() {
        return  chatUerRepository.findAllByStatus(Status.ONLINE);
    }
}
