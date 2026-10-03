package com.backintro.application.chatparticipant.usecase;

import com.backintro.application.chatparticipant.command.RegisterChatParticipantCommand;
import com.backintro.application.chatparticipant.dto.ChatParticipantResponse;
import com.backintro.domain.chatparticipant.model.aggregate.ChatParticipant;
import com.backintro.domain.chatparticipant.port.repository.ChatParticipantRepository;

public class RegisterChatParticipantUseCase {
    private final ChatParticipantRepository repository;

    public RegisterChatParticipantUseCase(ChatParticipantRepository repository) {
        this.repository = repository;
    }

    public ChatParticipantResponse execute(RegisterChatParticipantCommand command) {
        ChatParticipant aggregate = ChatParticipant.register(command.conversationId(), command.participantTypeId(), command.patientId(), command.professionalId());
        ChatParticipant saved = repository.save(aggregate);
        return ChatParticipantResponse.fromDomain(saved);
    }
}
