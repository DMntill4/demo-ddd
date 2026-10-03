package com.backintro.application.encounterstatuss.usecase;

import java.util.List;
import com.backintro.application.encounterstatuss.dto.EncounterStatusResponse;
import com.backintro.domain.encounterstatuss.port.repository.EncounterStatusRepository;

public class ListEncounterStatusUseCase {
    private final EncounterStatusRepository repository;

    public ListEncounterStatusUseCase(EncounterStatusRepository repository) {
        this.repository = repository;
    }

    public List<EncounterStatusResponse> execute() {
        return repository.findAll()
                .stream()
                .map(EncounterStatusResponse::fromDomain)
                .toList();
    }
}
