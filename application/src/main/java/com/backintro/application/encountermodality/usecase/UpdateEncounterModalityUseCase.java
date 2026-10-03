package com.backintro.application.encountermodality.usecase;

import com.backintro.application.encountermodality.command.UpdateEncounterModalityCommand;
import com.backintro.application.encountermodality.dto.EncounterModalityResponse;
import com.backintro.application.encountermodality.exception.EncounterModalityNotFoundApplicationException;
import com.backintro.domain.encountermodality.model.aggregate.EncounterModality;
import com.backintro.domain.encountermodality.port.repository.EncounterModalityRepository;

public class UpdateEncounterModalityUseCase {
    private final EncounterModalityRepository repository;

    public UpdateEncounterModalityUseCase(EncounterModalityRepository repository) {
        this.repository = repository;
    }

    public EncounterModalityResponse execute(UpdateEncounterModalityCommand command) {
        EncounterModality aggregate = repository.findById(command.id())
                .orElseThrow(() -> new EncounterModalityNotFoundApplicationException(command.id()));
        aggregate.update(command.code(), command.name());
        EncounterModality saved = repository.save(aggregate);
        return EncounterModalityResponse.fromDomain(saved);
    }
}
