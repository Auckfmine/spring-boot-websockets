package com.auckfmine.chat.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String chatId;
    Long senderId;
    Long recipientId;
    String senderName;
    String recipientName;
    String content;
    Date timestamp;
    @Enumerated(EnumType.STRING)
    MessageStatus status;
}
