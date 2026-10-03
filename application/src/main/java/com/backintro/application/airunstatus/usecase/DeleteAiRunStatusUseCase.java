package com.backintro.application.airunstatus.usecase;

import com.backintro.application.airunstatus.exception.AiRunStatusNotFoundApplicationException;
import com.backintro.domain.airunstatus.model.aggregate.AiRunStatus;
import com.backintro.domain.airunstatus.model.valueobject.AiRunStatusId;
import com.backintro.domain.airunstatus.port.repository.AiRunStatusRepository;

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
