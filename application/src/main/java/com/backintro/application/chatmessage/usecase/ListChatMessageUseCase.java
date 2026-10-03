package com.backintro.application.chatmessage.usecase;

import java.util.List;
import com.backintro.application.chatmessage.dto.ChatMessageResponse;
import com.backintro.domain.chatmessage.port.repository.ChatMessageRepository;

public class ListChatMessageUseCase {
    private final ChatMessageRepository repository;

    public ListChatMessageUseCase(ChatMessageRepository repository) {
        this.repository = repository;
    }

    public List<ChatMessageResponse> execute() {
        return repository.findAll()
                .stream()
                .map(ChatMessageResponse::fromDomain)
                .toList();
    }
}
