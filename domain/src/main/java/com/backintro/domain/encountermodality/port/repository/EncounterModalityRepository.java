package com.backintro.domain.encountermodality.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.encountermodality.model.aggregate.EncounterModality;
import com.backintro.domain.encountermodality.model.valueobject.EncounterModalityId;

public interface EncounterModalityRepository {
    EncounterModality save(EncounterModality aggregate);
    Optional<EncounterModality> findById(EncounterModalityId id);
    List<EncounterModality> findAll();
    void delete(EncounterModality aggregate);
}
