package com.backintro.application.chatparticipant.usecase;

import java.util.List;
import com.backintro.application.chatparticipant.dto.ChatParticipantResponse;
import com.backintro.domain.chatparticipant.port.repository.ChatParticipantRepository;

public class ListChatParticipantUseCase {
    private final ChatParticipantRepository repository;

    public ListChatParticipantUseCase(ChatParticipantRepository repository) {
        this.repository = repository;
    }

    public List<ChatParticipantResponse> execute() {
        return repository.findAll()
                .stream()
                .map(ChatParticipantResponse::fromDomain)
                .toList();
    }
}
