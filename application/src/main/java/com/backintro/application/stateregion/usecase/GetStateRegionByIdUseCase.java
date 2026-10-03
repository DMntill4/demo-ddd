package com.backintro.application.stateregion.usecase;

import com.backintro.application.stateregion.dto.StateRegionResponse;
import com.backintro.application.stateregion.exception.StateRegionNotFoundApplicationException;
import com.backintro.domain.stateregion.model.valueobject.StateRegionId;
import com.backintro.domain.stateregion.port.repository.StateRegionRepository;

public class GetStateRegionByIdUseCase {
    private final StateRegionRepository repository;

    public GetStateRegionByIdUseCase(StateRegionRepository repository) {
        this.repository = repository;
    }

    public StateRegionResponse execute(StateRegionId id) {
        return repository.findById(id)
                .map(StateRegionResponse::fromDomain)
                .orElseThrow(() -> new StateRegionNotFoundApplicationException(id));
    }
}
