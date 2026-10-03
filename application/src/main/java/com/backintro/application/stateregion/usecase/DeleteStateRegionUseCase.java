package com.backintro.application.stateregion.usecase;

import com.backintro.application.stateregion.exception.StateRegionNotFoundApplicationException;
import com.backintro.domain.stateregion.model.aggregate.StateRegion;
import com.backintro.domain.stateregion.model.valueobject.StateRegionId;
import com.backintro.domain.stateregion.port.repository.StateRegionRepository;

public class DeleteStateRegionUseCase {
    private final StateRegionRepository repository;

    public DeleteStateRegionUseCase(StateRegionRepository repository) {
        this.repository = repository;
    }

    public void execute(StateRegionId id) {
        StateRegion aggregate = repository.findById(id)
                .orElseThrow(() -> new StateRegionNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
