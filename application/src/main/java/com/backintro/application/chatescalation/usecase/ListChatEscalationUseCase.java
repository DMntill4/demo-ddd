package com.backintro.application.chatescalation.usecase;

import java.util.List;
import com.backintro.application.chatescalation.dto.ChatEscalationResponse;
import com.backintro.domain.chatescalation.port.repository.ChatEscalationRepository;

public class ListChatEscalationUseCase {
    private final ChatEscalationRepository repository;

    public ListChatEscalationUseCase(ChatEscalationRepository repository) {
        this.repository = repository;
    }

    public List<ChatEscalationResponse> execute() {
        return repository.findAll()
                .stream()
                .map(ChatEscalationResponse::fromDomain)
                .toList();
    }
}
