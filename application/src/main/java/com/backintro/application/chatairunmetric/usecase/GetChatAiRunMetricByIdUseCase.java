package com.backintro.application.chatairunmetric.usecase;

import com.backintro.application.chatairunmetric.dto.ChatAiRunMetricResponse;
import com.backintro.application.chatairunmetric.exception.ChatAiRunMetricNotFoundApplicationException;
import com.backintro.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;
import com.backintro.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;

public class GetChatAiRunMetricByIdUseCase {
    private final ChatAiRunMetricRepository repository;

    public GetChatAiRunMetricByIdUseCase(ChatAiRunMetricRepository repository) {
        this.repository = repository;
    }

    public ChatAiRunMetricResponse execute(ChatAiRunMetricId id) {
        return repository.findById(id)
                .map(ChatAiRunMetricResponse::fromDomain)
                .orElseThrow(() -> new ChatAiRunMetricNotFoundApplicationException(id));
    }
}
