package com.backintro.application.encounterstatus.usecase;

import com.backintro.application.encounterstatus.dto.EncounterStatusResponse;
import com.backintro.application.encounterstatus.exception.EncounterStatusNotFoundApplicationException;
import com.backintro.domain.encounterstatus.model.valueobject.EncounterStatusId;
import com.backintro.domain.encounterstatus.port.repository.EncounterStatusRepository;

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
