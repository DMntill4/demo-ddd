package com.backintro.application.encountertype.usecase;

import com.backintro.application.encountertype.command.UpdateEncounterTypeCommand;
import com.backintro.application.encountertype.dto.EncounterTypeResponse;
import com.backintro.application.encountertype.exception.EncounterTypeNotFoundApplicationException;
import com.backintro.domain.encountertype.model.aggregate.EncounterType;
import com.backintro.domain.encountertype.port.repository.EncounterTypeRepository;

public class UpdateEncounterTypeUseCase {
    private final EncounterTypeRepository repository;

    public UpdateEncounterTypeUseCase(EncounterTypeRepository repository) {
        this.repository = repository;
    }

    public EncounterTypeResponse execute(UpdateEncounterTypeCommand command) {
        EncounterType aggregate = repository.findById(command.id())
                .orElseThrow(() -> new EncounterTypeNotFoundApplicationException(command.id()));
        aggregate.update(command.code(), command.name());
        EncounterType saved = repository.save(aggregate);
        return EncounterTypeResponse.fromDomain(saved);
    }
}
