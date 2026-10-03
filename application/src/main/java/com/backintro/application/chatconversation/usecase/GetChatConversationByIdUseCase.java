package com.backintro.application.chatconversation.usecase;

import com.backintro.application.chatconversation.dto.ChatConversationResponse;
import com.backintro.application.chatconversation.exception.ChatConversationNotFoundApplicationException;
import com.backintro.domain.chatconversation.model.valueobject.ChatConversationId;
import com.backintro.domain.chatconversation.port.repository.ChatConversationRepository;

public class GetChatConversationByIdUseCase {
    private final ChatConversationRepository repository;

    public GetChatConversationByIdUseCase(ChatConversationRepository repository) {
        this.repository = repository;
    }

    public ChatConversationResponse execute(ChatConversationId id) {
        return repository.findById(id)
                .map(ChatConversationResponse::fromDomain)
                .orElseThrow(() -> new ChatConversationNotFoundApplicationException(id));
    }
}
