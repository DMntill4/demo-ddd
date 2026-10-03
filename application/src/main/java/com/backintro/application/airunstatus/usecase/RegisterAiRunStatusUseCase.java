package com.backintro.application.airunstatus.usecase;

import com.backintro.application.airunstatus.command.RegisterAiRunStatusCommand;
import com.backintro.application.airunstatus.dto.AiRunStatusResponse;
import com.backintro.domain.airunstatus.model.aggregate.AiRunStatus;
import com.backintro.domain.airunstatus.port.repository.AiRunStatusRepository;

public class RegisterAiRunStatusUseCase {
    private final AiRunStatusRepository repository;

    public RegisterAiRunStatusUseCase(AiRunStatusRepository repository) {
        this.repository = repository;
    }

    public AiRunStatusResponse execute(RegisterAiRunStatusCommand command) {
        if (repository.existsByCode(command.code())) {
            throw new IllegalArgumentException("AiRunStatus code already exists: " + command.code());
        }
        AiRunStatus aggregate = AiRunStatus.register(command.name(), command.code());
        AiRunStatus saved = repository.save(aggregate);
        return AiRunStatusResponse.fromDomain(saved);
    }
}
