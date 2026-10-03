package com.backintro.application.encounterstatus.usecase;

import com.backintro.application.encounterstatus.exception.EncounterStatusNotFoundApplicationException;
import com.backintro.domain.encounterstatus.model.aggregate.EncounterStatus;
import com.backintro.domain.encounterstatus.model.valueobject.EncounterStatusId;
import com.backintro.domain.encounterstatus.port.repository.EncounterStatusRepository;

public class DeleteEncounterStatusUseCase {
    private final EncounterStatusRepository repository;

    public DeleteEncounterStatusUseCase(EncounterStatusRepository repository) {
        this.repository = repository;
    }

    public void execute(EncounterStatusId id) {
        EncounterStatus aggregate = repository.findById(id)
                .orElseThrow(() -> new EncounterStatusNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
