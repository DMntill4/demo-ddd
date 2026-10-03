package com.backintro.application.chatairunmetric.usecase;

import com.backintro.application.chatairunmetric.command.UpdateChatAiRunMetricCommand;
import com.backintro.application.chatairunmetric.dto.ChatAiRunMetricResponse;
import com.backintro.application.chatairunmetric.exception.ChatAiRunMetricNotFoundApplicationException;
import com.backintro.domain.chatairunmetric.model.aggregate.ChatAiRunMetric;
import com.backintro.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;

public class UpdateChatAiRunMetricUseCase {
    private final ChatAiRunMetricRepository repository;

    public UpdateChatAiRunMetricUseCase(ChatAiRunMetricRepository repository) {
        this.repository = repository;
    }

    public ChatAiRunMetricResponse execute(UpdateChatAiRunMetricCommand command) {
        ChatAiRunMetric aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ChatAiRunMetricNotFoundApplicationException(command.id()));
        aggregate.update(command.aiRunId(), command.promptTokens(), command.completionTokens(), command.totalTokens(), command.cost());
        ChatAiRunMetric saved = repository.save(aggregate);
        return ChatAiRunMetricResponse.fromDomain(saved);
    }
}
