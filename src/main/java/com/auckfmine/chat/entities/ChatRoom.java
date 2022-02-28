package com.auckfmine.chat.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)


public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String chatId;
    Long senderId;
    Long recipientId;
}
