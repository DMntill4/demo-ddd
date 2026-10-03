package com.backintro.application.chatairun.usecase;

import java.util.List;
import com.backintro.application.chatairun.dto.ChatAiRunResponse;
import com.backintro.domain.chatairun.port.repository.ChatAiRunRepository;

public class ListChatAiRunUseCase {
    private final ChatAiRunRepository repository;

    public ListChatAiRunUseCase(ChatAiRunRepository repository) {
        this.repository = repository;
    }

    public List<ChatAiRunResponse> execute() {
        return repository.findAll()
                .stream()
                .map(ChatAiRunResponse::fromDomain)
                .toList();
    }
}
