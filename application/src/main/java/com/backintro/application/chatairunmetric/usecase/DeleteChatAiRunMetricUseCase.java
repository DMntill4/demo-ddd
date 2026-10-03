package com.backintro.application.chatairunmetric.usecase;

import com.backintro.application.chatairunmetric.exception.ChatAiRunMetricNotFoundApplicationException;
import com.backintro.domain.chatairunmetric.model.aggregate.ChatAiRunMetric;
import com.backintro.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;
import com.backintro.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;

public class DeleteChatAiRunMetricUseCase {
    private final ChatAiRunMetricRepository repository;

    public DeleteChatAiRunMetricUseCase(ChatAiRunMetricRepository repository) {
        this.repository = repository;
    }

    public void execute(ChatAiRunMetricId id) {
        ChatAiRunMetric aggregate = repository.findById(id)
                .orElseThrow(() -> new ChatAiRunMetricNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
