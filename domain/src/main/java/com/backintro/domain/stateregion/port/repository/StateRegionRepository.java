package com.backintro.domain.stateregion.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.stateregion.model.aggregate.StateRegion;
import com.backintro.domain.stateregion.model.valueobject.StateRegionId;

public interface StateRegionRepository {
    StateRegion save(StateRegion aggregate);
    Optional<StateRegion> findById(StateRegionId id);
    List<StateRegion> findAll();
    void delete(StateRegion aggregate);
}
