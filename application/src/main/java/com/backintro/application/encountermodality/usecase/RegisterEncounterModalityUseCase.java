package com.backintro.application.encountermodality.usecase;

import com.backintro.application.encountermodality.command.RegisterEncounterModalityCommand;
import com.backintro.application.encountermodality.dto.EncounterModalityResponse;
import com.backintro.domain.encountermodality.model.aggregate.EncounterModality;
import com.backintro.domain.encountermodality.port.repository.EncounterModalityRepository;

public class RegisterEncounterModalityUseCase {
    private final EncounterModalityRepository repository;

    public RegisterEncounterModalityUseCase(EncounterModalityRepository repository) {
        this.repository = repository;
    }

    public EncounterModalityResponse execute(RegisterEncounterModalityCommand command) {
        EncounterModality aggregate = EncounterModality.register(command.code(), command.name());
        EncounterModality saved = repository.save(aggregate);
        return EncounterModalityResponse.fromDomain(saved);
    }
}
