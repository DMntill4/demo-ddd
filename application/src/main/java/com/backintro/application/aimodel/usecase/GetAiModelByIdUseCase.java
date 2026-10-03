package com.backintro.application.aimodel.usecase;

import com.backintro.application.aimodel.dto.AiModelResponse;
import com.backintro.application.aimodel.exception.AiModelNotFoundApplicationException;
import com.backintro.domain.aimodel.model.valueobject.AiModelId;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;

public class GetAiModelByIdUseCase {
    private final AiModelRepository repository;

    public GetAiModelByIdUseCase(AiModelRepository repository) {
        this.repository = repository;
    }

    public AiModelResponse execute(AiModelId id) {
        return repository.findById(id)
                .map(AiModelResponse::fromDomain)
                .orElseThrow(() -> new AiModelNotFoundApplicationException(id));
    }
}
