package com.backintro.domain.encountertype.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.encountertype.model.aggregate.EncounterType;
import com.backintro.domain.encountertype.model.valueobject.EncounterTypeId;

public interface EncounterTypeRepository {
    EncounterType save(EncounterType aggregate);
    Optional<EncounterType> findById(EncounterTypeId id);
    List<EncounterType> findAll();
    void delete(EncounterType aggregate);
}
