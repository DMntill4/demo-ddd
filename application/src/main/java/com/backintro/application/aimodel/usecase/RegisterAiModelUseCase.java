package com.backintro.application.aimodel.usecase;

import com.backintro.application.aimodel.command.RegisterAiModelCommand;
import com.backintro.application.aimodel.dto.AiModelResponse;
import com.backintro.domain.aimodel.model.aggregate.AiModel;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;

public class RegisterAiModelUseCase {
    private final AiModelRepository repository;

    public RegisterAiModelUseCase(AiModelRepository repository) {
        this.repository = repository;
    }

    public AiModelResponse execute(RegisterAiModelCommand command) {
        AiModel aggregate = AiModel.register(command.providerModelId(), command.nameModel(), command.modelKey(), command.inputTokenPrice(), command.outputTokenPrice(), command.maxTokens(), command.contextWindow());
        AiModel saved = repository.save(aggregate);
        return AiModelResponse.fromDomain(saved);
    }
}
