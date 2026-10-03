package com.backintro.application.encounter.usecase;

import java.util.List;
import com.backintro.application.encounter.dto.EncounterResponse;
import com.backintro.domain.encounter.port.repository.EncounterRepository;

public class ListEncounterUseCase {
    private final EncounterRepository repository;

    public ListEncounterUseCase(EncounterRepository repository) {
        this.repository = repository;
    }

    public List<EncounterResponse> execute() {
        return repository.findAll()
                .stream()
                .map(EncounterResponse::fromDomain)
                .toList();
    }
}
