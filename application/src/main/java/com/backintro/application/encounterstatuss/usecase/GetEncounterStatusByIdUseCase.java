package com.backintro.application.encounterstatuss.usecase;

import com.backintro.application.encounterstatuss.dto.EncounterStatusResponse;
import com.backintro.application.encounterstatuss.exception.EncounterStatusNotFoundApplicationException;
import com.backintro.domain.encounterstatuss.model.valueobject.EncounterStatusId;
import com.backintro.domain.encounterstatuss.port.repository.EncounterStatusRepository;

public class GetEncounterStatusByIdUseCase {
    private final EncounterStatusRepository repository;

    public GetEncounterStatusByIdUseCase(EncounterStatusRepository repository) {
        this.repository = repository;
    }

    public EncounterStatusResponse execute(EncounterStatusId id) {
        return repository.findById(id)
                .map(EncounterStatusResponse::fromDomain)
                .orElseThrow(() -> new EncounterStatusNotFoundApplicationException(id));
    }
}
