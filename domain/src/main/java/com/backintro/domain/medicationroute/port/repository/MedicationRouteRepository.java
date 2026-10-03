package com.backintro.domain.medicationroute.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.medicationroute.model.aggregate.MedicationRoute;
import com.backintro.domain.medicationroute.model.valueobject.MedicationRouteId;

public interface MedicationRouteRepository {
    MedicationRoute save(MedicationRoute aggregate);
    Optional<MedicationRoute> findById(MedicationRouteId id);
    List<MedicationRoute> findAll();
    void delete(MedicationRoute aggregate);
}
