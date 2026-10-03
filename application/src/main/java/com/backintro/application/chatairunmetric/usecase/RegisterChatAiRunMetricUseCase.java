package com.backintro.application.chatairunmetric.usecase;

import com.backintro.application.chatairunmetric.command.RegisterChatAiRunMetricCommand;
import com.backintro.application.chatairunmetric.dto.ChatAiRunMetricResponse;
import com.backintro.domain.chatairunmetric.model.aggregate.ChatAiRunMetric;
import com.backintro.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;

public class RegisterChatAiRunMetricUseCase {
    private final ChatAiRunMetricRepository repository;

    public RegisterChatAiRunMetricUseCase(ChatAiRunMetricRepository repository) {
        this.repository = repository;
    }

    public ChatAiRunMetricResponse execute(RegisterChatAiRunMetricCommand command) {
        ChatAiRunMetric aggregate = ChatAiRunMetric.register(command.aiRunId(), command.promptTokens(), command.completionTokens(), command.totalTokens(), command.cost());
        ChatAiRunMetric saved = repository.save(aggregate);
        return ChatAiRunMetricResponse.fromDomain(saved);
    }
}
