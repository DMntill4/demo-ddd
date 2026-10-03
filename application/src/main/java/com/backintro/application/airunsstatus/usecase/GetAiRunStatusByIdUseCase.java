package com.backintro.application.airunsstatus.usecase;

import com.backintro.application.airunsstatus.dto.AiRunStatusResponse;
import com.backintro.application.airunsstatus.exception.AiRunStatusNotFoundApplicationException;
import com.backintro.domain.airunsstatus.model.valueobject.AiRunStatusId;
import com.backintro.domain.airunsstatus.port.repository.AiRunStatusRepository;

public class GetAiRunStatusByIdUseCase {
    private final AiRunStatusRepository repository;

    public GetAiRunStatusByIdUseCase(AiRunStatusRepository repository) {
        this.repository = repository;
    }

    public AiRunStatusResponse execute(AiRunStatusId id) {
        return repository.findById(id)
                .map(AiRunStatusResponse::fromDomain)
                .orElseThrow(() -> new AiRunStatusNotFoundApplicationException(id));
    }
}
