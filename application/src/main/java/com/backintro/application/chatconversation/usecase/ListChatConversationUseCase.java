package com.backintro.application.chatconversation.usecase;

import java.util.List;
import com.backintro.application.chatconversation.dto.ChatConversationResponse;
import com.backintro.domain.chatconversation.port.repository.ChatConversationRepository;

public class ListChatConversationUseCase {
    private final ChatConversationRepository repository;

    public ListChatConversationUseCase(ChatConversationRepository repository) {
        this.repository = repository;
    }

    public List<ChatConversationResponse> execute() {
        return repository.findAll()
                .stream()
                .map(ChatConversationResponse::fromDomain)
                .toList();
    }
}
