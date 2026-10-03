package com.backintro.application.airunstatus.usecase;

import com.backintro.application.airunstatus.command.UpdateAiRunStatusCommand;
import com.backintro.application.airunstatus.dto.AiRunStatusResponse;
import com.backintro.application.airunstatus.exception.AiRunStatusNotFoundApplicationException;
import com.backintro.domain.airunstatus.model.aggregate.AiRunStatus;
import com.backintro.domain.airunstatus.port.repository.AiRunStatusRepository;

public class UpdateAiRunStatusUseCase {
    private final AiRunStatusRepository repository;

    public UpdateAiRunStatusUseCase(AiRunStatusRepository repository) {
        this.repository = repository;
    }

    public AiRunStatusResponse execute(UpdateAiRunStatusCommand command) {
        AiRunStatus aggregate = repository.findById(command.id())
                .orElseThrow(() -> new AiRunStatusNotFoundApplicationException(command.id()));
        aggregate.update(command.name(), command.code());
        AiRunStatus saved = repository.save(aggregate);
        return AiRunStatusResponse.fromDomain(saved);
    }
}
