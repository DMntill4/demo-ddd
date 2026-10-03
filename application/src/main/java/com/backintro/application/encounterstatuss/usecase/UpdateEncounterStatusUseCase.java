package com.backintro.application.encounterstatuss.usecase;

import com.backintro.application.encounterstatuss.command.UpdateEncounterStatusCommand;
import com.backintro.application.encounterstatuss.dto.EncounterStatusResponse;
import com.backintro.application.encounterstatuss.exception.EncounterStatusNotFoundApplicationException;
import com.backintro.domain.encounterstatuss.model.aggregate.EncounterStatus;
import com.backintro.domain.encounterstatuss.port.repository.EncounterStatusRepository;

public class UpdateEncounterStatusUseCase {
    private final EncounterStatusRepository repository;

    public UpdateEncounterStatusUseCase(EncounterStatusRepository repository) {
        this.repository = repository;
    }

    public EncounterStatusResponse execute(UpdateEncounterStatusCommand command) {
        EncounterStatus aggregate = repository.findById(command.id())
                .orElseThrow(() -> new EncounterStatusNotFoundApplicationException(command.id()));
        aggregate.update(command.code(), command.name());
        EncounterStatus saved = repository.save(aggregate);
        return EncounterStatusResponse.fromDomain(saved);
    }
}
