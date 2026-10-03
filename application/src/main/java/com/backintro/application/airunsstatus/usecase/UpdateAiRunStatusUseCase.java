package com.backintro.application.airunsstatus.usecase;

import com.backintro.application.airunsstatus.command.UpdateAiRunStatusCommand;
import com.backintro.application.airunsstatus.dto.AiRunStatusResponse;
import com.backintro.application.airunsstatus.exception.AiRunStatusNotFoundApplicationException;
import com.backintro.domain.airunsstatus.model.aggregate.AiRunStatus;
import com.backintro.domain.airunsstatus.port.repository.AiRunStatusRepository;

public class UpdateAiRunStatusUseCase {
    private final AiRunStatusRepository repository;

    public UpdateAiRunStatusUseCase(AiRunStatusRepository repository) {
        this.repository = repository;
    }

    public AiRunStatusResponse execute(UpdateAiRunStatusCommand command) {
        AiRunStatus aggregate = repository.findById(command.id())
                .orElseThrow(() -> new AiRunStatusNotFoundApplicationException(command.id()));
        aggregate.update(command.nameStatus());
        AiRunStatus saved = repository.save(aggregate);
        return AiRunStatusResponse.fromDomain(saved);
    }
}
