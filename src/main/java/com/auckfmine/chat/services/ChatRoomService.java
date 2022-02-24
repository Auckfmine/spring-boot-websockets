package com.auckfmine.chat.services;

import com.auckfmine.chat.entities.ChatRoom;
import com.auckfmine.chat.repositories.ChatRoomRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChatRoomService {
    @Autowired
    private ChatRoomRepository chatRoomRepository;

    public Optional<String> getChatId(
            Long senderId, Long recipientId, boolean createIfNotExist) {

        ChatRoom chatRoom = chatRoomRepository.findBySenderIdAndRecipientId(senderId, recipientId).orElse(null);
        if (chatRoom != null) {
            return Optional.of(chatRoom.getChatId());

        } else {

            if (!createIfNotExist) {
                return Optional.empty();
            }
            var chatId =
                    String.format("%s_%s", senderId, recipientId);

            ChatRoom senderRecipient = ChatRoom
                    .builder()
                    .chatId(chatId)
                    .senderId(senderId)
                    .recipientId(recipientId)
                    .build();

            ChatRoom recipientSender = ChatRoom
                    .builder()
                    .chatId(chatId)
                    .senderId(recipientId)
                    .recipientId(senderId)
                    .build();
            chatRoomRepository.save(senderRecipient);
            chatRoomRepository.save(recipientSender);

            return Optional.of(chatId);

        }


    }
}
