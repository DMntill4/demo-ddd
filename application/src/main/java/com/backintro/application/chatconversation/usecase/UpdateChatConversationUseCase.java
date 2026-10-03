package com.backintro.application.chatconversation.usecase;

import com.backintro.application.chatconversation.command.UpdateChatConversationCommand;
import com.backintro.application.chatconversation.dto.ChatConversationResponse;
import com.backintro.application.chatconversation.exception.ChatConversationNotFoundApplicationException;
import com.backintro.domain.chatconversation.model.aggregate.ChatConversation;
import com.backintro.domain.chatconversation.port.repository.ChatConversationRepository;

public class UpdateChatConversationUseCase {
    private final ChatConversationRepository repository;

    public UpdateChatConversationUseCase(ChatConversationRepository repository) {
        this.repository = repository;
    }

    public ChatConversationResponse execute(UpdateChatConversationCommand command) {
        ChatConversation aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ChatConversationNotFoundApplicationException(command.id()));
        aggregate.update(command.conversationStatusId(), command.priorityId(), command.lastMessageAt(), command.closed(), command.closedAt(), command.closedBy());
        ChatConversation saved = repository.save(aggregate);
        return ChatConversationResponse.fromDomain(saved);
    }
}
