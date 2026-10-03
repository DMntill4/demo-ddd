package com.backintro.application.encountertype.usecase;

import java.util.List;
import com.backintro.application.encountertype.dto.EncounterTypeResponse;
import com.backintro.domain.encountertype.port.repository.EncounterTypeRepository;

public class ListEncounterTypeUseCase {
    private final EncounterTypeRepository repository;

    public ListEncounterTypeUseCase(EncounterTypeRepository repository) {
        this.repository = repository;
    }

    public List<EncounterTypeResponse> execute() {
        return repository.findAll()
                .stream()
                .map(EncounterTypeResponse::fromDomain)
                .toList();
    }
}
