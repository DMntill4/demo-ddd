package com.backintro.application.encounterstatus.usecase;

import com.backintro.application.encounterstatus.command.RegisterEncounterStatusCommand;
import com.backintro.application.encounterstatus.dto.EncounterStatusResponse;
import com.backintro.domain.encounterstatus.model.aggregate.EncounterStatus;
import com.backintro.domain.encounterstatus.port.repository.EncounterStatusRepository;

public class RegisterEncounterStatusUseCase {
    private final EncounterStatusRepository repository;

    public RegisterEncounterStatusUseCase(EncounterStatusRepository repository) {
        this.repository = repository;
    }

    public EncounterStatusResponse execute(RegisterEncounterStatusCommand command) {
        if (repository.existsByCode(command.code())) {
            throw new IllegalArgumentException("EncounterStatus code already exists: " + command.code());
        }
        EncounterStatus aggregate = EncounterStatus.register(command.name(), command.code());
        EncounterStatus saved = repository.save(aggregate);
        return EncounterStatusResponse.fromDomain(saved);
    }
}
