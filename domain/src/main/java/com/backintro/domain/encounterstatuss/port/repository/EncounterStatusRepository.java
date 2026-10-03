package com.backintro.domain.encounterstatuss.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.encounterstatuss.model.aggregate.EncounterStatus;
import com.backintro.domain.encounterstatuss.model.valueobject.EncounterStatusId;

public interface EncounterStatusRepository {
    EncounterStatus save(EncounterStatus aggregate);
    Optional<EncounterStatus> findById(EncounterStatusId id);
    List<EncounterStatus> findAll();
    void delete(EncounterStatus aggregate);
}
