package com.backintro.application.chatairunmetric.usecase;

import java.util.List;
import com.backintro.application.chatairunmetric.dto.ChatAiRunMetricResponse;
import com.backintro.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;

public class ListChatAiRunMetricUseCase {
    private final ChatAiRunMetricRepository repository;

    public ListChatAiRunMetricUseCase(ChatAiRunMetricRepository repository) {
        this.repository = repository;
    }

    public List<ChatAiRunMetricResponse> execute() {
        return repository.findAll()
                .stream()
                .map(ChatAiRunMetricResponse::fromDomain)
                .toList();
    }
}
