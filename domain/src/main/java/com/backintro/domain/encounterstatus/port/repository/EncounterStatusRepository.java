package com.backintro.domain.encounterstatus.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.encounterstatus.model.aggregate.EncounterStatus;
import com.backintro.domain.encounterstatus.model.valueobject.EncounterStatusId;

public interface EncounterStatusRepository {
    EncounterStatus save(EncounterStatus aggregate);
    Optional<EncounterStatus> findById(EncounterStatusId id);
    List<EncounterStatus> findAll();
    boolean existsByCode(String code);
    void delete(EncounterStatus aggregate);
}
