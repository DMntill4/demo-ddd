package com.backintro.application.stateregion.usecase;

import java.util.List;
import com.backintro.application.stateregion.dto.StateRegionResponse;
import com.backintro.domain.stateregion.port.repository.StateRegionRepository;

public class ListStateRegionUseCase {
    private final StateRegionRepository repository;

    public ListStateRegionUseCase(StateRegionRepository repository) {
        this.repository = repository;
    }

    public List<StateRegionResponse> execute() {
        return repository.findAll()
                .stream()
                .map(StateRegionResponse::fromDomain)
                .toList();
    }
}
