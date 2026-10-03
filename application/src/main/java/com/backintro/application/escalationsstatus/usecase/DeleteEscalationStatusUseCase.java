package com.backintro.application.escalationsstatus.usecase;

import com.backintro.application.escalationsstatus.exception.EscalationStatusNotFoundApplicationException;
import com.backintro.domain.escalationsstatus.model.aggregate.EscalationStatus;
import com.backintro.domain.escalationsstatus.model.valueobject.EscalationStatusId;
import com.backintro.domain.escalationsstatus.port.repository.EscalationStatusRepository;

public class DeleteEscalationStatusUseCase {
    private final EscalationStatusRepository repository;

    public DeleteEscalationStatusUseCase(EscalationStatusRepository repository) {
        this.repository = repository;
    }

    public void execute(EscalationStatusId id) {
        EscalationStatus aggregate = repository.findById(id)
                .orElseThrow(() -> new EscalationStatusNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
