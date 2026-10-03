package com.backintro.application.chatconversation.usecase;

import com.backintro.application.chatconversation.exception.ChatConversationNotFoundApplicationException;
import com.backintro.domain.chatconversation.model.aggregate.ChatConversation;
import com.backintro.domain.chatconversation.model.valueobject.ChatConversationId;
import com.backintro.domain.chatconversation.port.repository.ChatConversationRepository;

public class DeleteChatConversationUseCase {
    private final ChatConversationRepository repository;

    public DeleteChatConversationUseCase(ChatConversationRepository repository) {
        this.repository = repository;
    }

    public void execute(ChatConversationId id) {
        ChatConversation aggregate = repository.findById(id)
                .orElseThrow(() -> new ChatConversationNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
