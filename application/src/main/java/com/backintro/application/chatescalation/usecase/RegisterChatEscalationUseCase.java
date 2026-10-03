package com.backintro.application.chatescalation.usecase;

import com.backintro.application.chatescalation.command.RegisterChatEscalationCommand;
import com.backintro.application.chatescalation.dto.ChatEscalationResponse;
import com.backintro.domain.chatescalation.model.aggregate.ChatEscalation;
import com.backintro.domain.chatescalation.port.repository.ChatEscalationRepository;

public class RegisterChatEscalationUseCase {
    private final ChatEscalationRepository repository;

    public RegisterChatEscalationUseCase(ChatEscalationRepository repository) {
        this.repository = repository;
    }

    public ChatEscalationResponse execute(RegisterChatEscalationCommand command) {
        ChatEscalation aggregate = ChatEscalation.register(command.conversationId(), command.statusId(), command.fromAi(), command.reason());
        ChatEscalation saved = repository.save(aggregate);
        return ChatEscalationResponse.fromDomain(saved);
    }
}
