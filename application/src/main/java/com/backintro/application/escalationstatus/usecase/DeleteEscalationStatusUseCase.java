package com.backintro.application.escalationstatus.usecase;

import com.backintro.application.escalationstatus.exception.EscalationStatusNotFoundApplicationException;
import com.backintro.domain.escalationstatus.model.aggregate.EscalationStatus;
import com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId;
import com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository;

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
