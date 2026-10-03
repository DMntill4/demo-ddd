package com.backintro.application.escalationsstatus.usecase;

import com.backintro.application.escalationsstatus.command.UpdateEscalationStatusCommand;
import com.backintro.application.escalationsstatus.dto.EscalationStatusResponse;
import com.backintro.application.escalationsstatus.exception.EscalationStatusNotFoundApplicationException;
import com.backintro.domain.escalationsstatus.model.aggregate.EscalationStatus;
import com.backintro.domain.escalationsstatus.port.repository.EscalationStatusRepository;

public class UpdateEscalationStatusUseCase {
    private final EscalationStatusRepository repository;

    public UpdateEscalationStatusUseCase(EscalationStatusRepository repository) {
        this.repository = repository;
    }

    public EscalationStatusResponse execute(UpdateEscalationStatusCommand command) {
        EscalationStatus aggregate = repository.findById(command.id())
                .orElseThrow(() -> new EscalationStatusNotFoundApplicationException(command.id()));
        aggregate.update(command.nameStatus());
        EscalationStatus saved = repository.save(aggregate);
        return EscalationStatusResponse.fromDomain(saved);
    }
}
