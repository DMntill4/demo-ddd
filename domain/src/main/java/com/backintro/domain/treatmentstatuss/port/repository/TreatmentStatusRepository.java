package com.backintro.domain.treatmentstatuss.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.treatmentstatuss.model.aggregate.TreatmentStatus;
import com.backintro.domain.treatmentstatuss.model.valueobject.TreatmentStatusId;

public interface TreatmentStatusRepository {
    TreatmentStatus save(TreatmentStatus aggregate);
    Optional<TreatmentStatus> findById(TreatmentStatusId id);
    List<TreatmentStatus> findAll();
    void delete(TreatmentStatus aggregate);
}
