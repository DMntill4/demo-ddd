package com.backintro.application.escalationstatus.usecase;

import com.backintro.application.escalationstatus.command.RegisterEscalationStatusCommand;
import com.backintro.application.escalationstatus.dto.EscalationStatusResponse;
import com.backintro.domain.escalationstatus.model.aggregate.EscalationStatus;
import com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository;

public class RegisterEscalationStatusUseCase {
    private final EscalationStatusRepository repository;

    public RegisterEscalationStatusUseCase(EscalationStatusRepository repository) {
        this.repository = repository;
    }

    public EscalationStatusResponse execute(RegisterEscalationStatusCommand command) {
        if (repository.existsByCode(command.code())) {
            throw new IllegalArgumentException("EscalationStatus code already exists: " + command.code());
        }
        EscalationStatus aggregate = EscalationStatus.register(command.name(), command.code());
        EscalationStatus saved = repository.save(aggregate);
        return EscalationStatusResponse.fromDomain(saved);
    }
}
