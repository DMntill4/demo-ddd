package com.backintro.application.escalationsstatus.usecase;

import com.backintro.application.escalationsstatus.command.RegisterEscalationStatusCommand;
import com.backintro.application.escalationsstatus.dto.EscalationStatusResponse;
import com.backintro.domain.escalationsstatus.model.aggregate.EscalationStatus;
import com.backintro.domain.escalationsstatus.port.repository.EscalationStatusRepository;

public class RegisterEscalationStatusUseCase {
    private final EscalationStatusRepository repository;

    public RegisterEscalationStatusUseCase(EscalationStatusRepository repository) {
        this.repository = repository;
    }

    public EscalationStatusResponse execute(RegisterEscalationStatusCommand command) {
        EscalationStatus aggregate = EscalationStatus.register(command.nameStatus());
        EscalationStatus saved = repository.save(aggregate);
        return EscalationStatusResponse.fromDomain(saved);
    }
}
