package com.backintro.application.chatparticipant.usecase;

import com.backintro.application.chatparticipant.dto.ChatParticipantResponse;
import com.backintro.application.chatparticipant.exception.ChatParticipantNotFoundApplicationException;
import com.backintro.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.backintro.domain.chatparticipant.port.repository.ChatParticipantRepository;

public class GetChatParticipantByIdUseCase {
    private final ChatParticipantRepository repository;

    public GetChatParticipantByIdUseCase(ChatParticipantRepository repository) {
        this.repository = repository;
    }

    public ChatParticipantResponse execute(ChatParticipantId id) {
        return repository.findById(id)
                .map(ChatParticipantResponse::fromDomain)
                .orElseThrow(() -> new ChatParticipantNotFoundApplicationException(id));
    }
}
