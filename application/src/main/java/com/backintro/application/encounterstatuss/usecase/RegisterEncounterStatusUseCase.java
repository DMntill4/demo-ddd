package com.backintro.application.encounterstatuss.usecase;

import com.backintro.application.encounterstatuss.command.RegisterEncounterStatusCommand;
import com.backintro.application.encounterstatuss.dto.EncounterStatusResponse;
import com.backintro.domain.encounterstatuss.model.aggregate.EncounterStatus;
import com.backintro.domain.encounterstatuss.port.repository.EncounterStatusRepository;

public class RegisterEncounterStatusUseCase {
    private final EncounterStatusRepository repository;

    public RegisterEncounterStatusUseCase(EncounterStatusRepository repository) {
        this.repository = repository;
    }

    public EncounterStatusResponse execute(RegisterEncounterStatusCommand command) {
        EncounterStatus aggregate = EncounterStatus.register(command.code(), command.name());
        EncounterStatus saved = repository.save(aggregate);
        return EncounterStatusResponse.fromDomain(saved);
    }
}
