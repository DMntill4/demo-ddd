package com.backintro.application.chatparticipant.usecase;

import com.backintro.application.chatparticipant.exception.ChatParticipantNotFoundApplicationException;
import com.backintro.domain.chatparticipant.model.aggregate.ChatParticipant;
import com.backintro.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.backintro.domain.chatparticipant.port.repository.ChatParticipantRepository;

public class DeleteChatParticipantUseCase {
    private final ChatParticipantRepository repository;

    public DeleteChatParticipantUseCase(ChatParticipantRepository repository) {
        this.repository = repository;
    }

    public void execute(ChatParticipantId id) {
        ChatParticipant aggregate = repository.findById(id)
                .orElseThrow(() -> new ChatParticipantNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
