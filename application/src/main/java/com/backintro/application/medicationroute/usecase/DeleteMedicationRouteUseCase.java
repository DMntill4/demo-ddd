package com.backintro.application.medicationroute.usecase;

import com.backintro.application.medicationroute.exception.MedicationRouteNotFoundApplicationException;
import com.backintro.domain.medicationroute.model.aggregate.MedicationRoute;
import com.backintro.domain.medicationroute.model.valueobject.MedicationRouteId;
import com.backintro.domain.medicationroute.port.repository.MedicationRouteRepository;

public class DeleteMedicationRouteUseCase {
    private final MedicationRouteRepository repository;

    public DeleteMedicationRouteUseCase(MedicationRouteRepository repository) {
        this.repository = repository;
    }

    public void execute(MedicationRouteId id) {
        MedicationRoute aggregate = repository.findById(id)
                .orElseThrow(() -> new MedicationRouteNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
