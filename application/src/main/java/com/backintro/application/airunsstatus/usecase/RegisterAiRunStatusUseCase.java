package com.backintro.application.airunsstatus.usecase;

import com.backintro.application.airunsstatus.command.RegisterAiRunStatusCommand;
import com.backintro.application.airunsstatus.dto.AiRunStatusResponse;
import com.backintro.domain.airunsstatus.model.aggregate.AiRunStatus;
import com.backintro.domain.airunsstatus.port.repository.AiRunStatusRepository;

public class RegisterAiRunStatusUseCase {
    private final AiRunStatusRepository repository;

    public RegisterAiRunStatusUseCase(AiRunStatusRepository repository) {
        this.repository = repository;
    }

    public AiRunStatusResponse execute(RegisterAiRunStatusCommand command) {
        AiRunStatus aggregate = AiRunStatus.register(command.nameStatus());
        AiRunStatus saved = repository.save(aggregate);
        return AiRunStatusResponse.fromDomain(saved);
    }
}
