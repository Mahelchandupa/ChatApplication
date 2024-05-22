package com.mahel.chatApp.chat.chatmessage;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessageNotification {
    private String id;
    private String senderId;
    private String recipientId;
    private String content;
}
