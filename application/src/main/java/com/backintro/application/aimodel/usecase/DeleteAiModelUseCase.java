package com.backintro.application.aimodel.usecase;

import com.backintro.application.aimodel.exception.AiModelNotFoundApplicationException;
import com.backintro.domain.aimodel.model.aggregate.AiModel;
import com.backintro.domain.aimodel.model.valueobject.AiModelId;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;

public class DeleteAiModelUseCase {
    private final AiModelRepository repository;

    public DeleteAiModelUseCase(AiModelRepository repository) {
        this.repository = repository;
    }

    public void execute(AiModelId id) {
        AiModel aggregate = repository.findById(id)
                .orElseThrow(() -> new AiModelNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
