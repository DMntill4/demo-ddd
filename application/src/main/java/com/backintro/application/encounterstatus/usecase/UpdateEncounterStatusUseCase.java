package com.backintro.application.encounterstatus.usecase;

import com.backintro.application.encounterstatus.command.UpdateEncounterStatusCommand;
import com.backintro.application.encounterstatus.dto.EncounterStatusResponse;
import com.backintro.application.encounterstatus.exception.EncounterStatusNotFoundApplicationException;
import com.backintro.domain.encounterstatus.model.aggregate.EncounterStatus;
import com.backintro.domain.encounterstatus.port.repository.EncounterStatusRepository;

public class UpdateEncounterStatusUseCase {
    private final EncounterStatusRepository repository;

    public UpdateEncounterStatusUseCase(EncounterStatusRepository repository) {
        this.repository = repository;
    }

    public EncounterStatusResponse execute(UpdateEncounterStatusCommand command) {
        EncounterStatus aggregate = repository.findById(command.id())
                .orElseThrow(() -> new EncounterStatusNotFoundApplicationException(command.id()));
        aggregate.update(command.name(), command.code());
        EncounterStatus saved = repository.save(aggregate);
        return EncounterStatusResponse.fromDomain(saved);
    }
}
