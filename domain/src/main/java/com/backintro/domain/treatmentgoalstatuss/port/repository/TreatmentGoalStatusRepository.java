package com.backintro.domain.treatmentgoalstatuss.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.treatmentgoalstatuss.model.aggregate.TreatmentGoalStatus;
import com.backintro.domain.treatmentgoalstatuss.model.valueobject.TreatmentGoalStatusId;

public interface TreatmentGoalStatusRepository {
    TreatmentGoalStatus save(TreatmentGoalStatus aggregate);
    Optional<TreatmentGoalStatus> findById(TreatmentGoalStatusId id);
    List<TreatmentGoalStatus> findAll();
    void delete(TreatmentGoalStatus aggregate);
}
