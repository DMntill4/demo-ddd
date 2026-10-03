package com.backintro.application.chatconversation.usecase;

import com.backintro.application.chatconversation.command.RegisterChatConversationCommand;
import com.backintro.application.chatconversation.dto.ChatConversationResponse;
import com.backintro.domain.chatconversation.model.aggregate.ChatConversation;
import com.backintro.domain.chatconversation.port.repository.ChatConversationRepository;

public class RegisterChatConversationUseCase {
    private final ChatConversationRepository repository;

    public RegisterChatConversationUseCase(ChatConversationRepository repository) {
        this.repository = repository;
    }

    public ChatConversationResponse execute(RegisterChatConversationCommand command) {
        ChatConversation aggregate = ChatConversation.register(command.conversationStatusId(), command.priorityId(), command.lastMessageAt(), command.closed(), command.closedAt(), command.closedBy());
        ChatConversation saved = repository.save(aggregate);
        return ChatConversationResponse.fromDomain(saved);
    }
}
