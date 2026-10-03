package com.backintro.application.airunstatus.usecase;

import com.backintro.application.airunstatus.dto.AiRunStatusResponse;
import com.backintro.application.airunstatus.exception.AiRunStatusNotFoundApplicationException;
import com.backintro.domain.airunstatus.model.valueobject.AiRunStatusId;
import com.backintro.domain.airunstatus.port.repository.AiRunStatusRepository;

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
