package com.auckfmine.chat.repositories;

import com.auckfmine.chat.entities.ChatMessage;
import com.auckfmine.chat.entities.MessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage,Long> {
    long countBySenderIdAndRecipientIdAndStatus(Long senderId, Long recipientId, MessageStatus status);
    List<ChatMessage> findByChatId(String chatId);
}
