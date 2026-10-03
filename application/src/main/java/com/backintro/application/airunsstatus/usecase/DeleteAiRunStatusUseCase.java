package com.backintro.application.airunsstatus.usecase;

import com.backintro.application.airunsstatus.exception.AiRunStatusNotFoundApplicationException;
import com.backintro.domain.airunsstatus.model.aggregate.AiRunStatus;
import com.backintro.domain.airunsstatus.model.valueobject.AiRunStatusId;
import com.backintro.domain.airunsstatus.port.repository.AiRunStatusRepository;

public class DeleteAiRunStatusUseCase {
    private final AiRunStatusRepository repository;

    public DeleteAiRunStatusUseCase(AiRunStatusRepository repository) {
        this.repository = repository;
    }

    public void execute(AiRunStatusId id) {
        AiRunStatus aggregate = repository.findById(id)
                .orElseThrow(() -> new AiRunStatusNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
