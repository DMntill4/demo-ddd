package com.backintro.application.aimodel.usecase;

import com.backintro.application.aimodel.command.UpdateAiModelCommand;
import com.backintro.application.aimodel.dto.AiModelResponse;
import com.backintro.application.aimodel.exception.AiModelNotFoundApplicationException;
import com.backintro.domain.aimodel.model.aggregate.AiModel;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;

public class UpdateAiModelUseCase {
    private final AiModelRepository repository;

    public UpdateAiModelUseCase(AiModelRepository repository) {
        this.repository = repository;
    }

    public AiModelResponse execute(UpdateAiModelCommand command) {
        AiModel aggregate = repository.findById(command.id())
                .orElseThrow(() -> new AiModelNotFoundApplicationException(command.id()));
        aggregate.update(command.providerModelId(), command.nameModel(), command.modelKey(), command.inputTokenPrice(), command.outputTokenPrice(), command.maxTokens(), command.contextWindow());
        AiModel saved = repository.save(aggregate);
        return AiModelResponse.fromDomain(saved);
    }
}
