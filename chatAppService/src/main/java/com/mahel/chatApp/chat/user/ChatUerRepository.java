package com.mahel.chatApp.chat.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatUerRepository extends JpaRepository<ChatUser, String> {

    List<ChatUser> findAllByStatus(Status status);
}
