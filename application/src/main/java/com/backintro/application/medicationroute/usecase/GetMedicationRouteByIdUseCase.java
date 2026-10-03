package com.backintro.application.medicationroute.usecase;

import com.backintro.application.medicationroute.dto.MedicationRouteResponse;
import com.backintro.application.medicationroute.exception.MedicationRouteNotFoundApplicationException;
import com.backintro.domain.medicationroute.model.valueobject.MedicationRouteId;
import com.backintro.domain.medicationroute.port.repository.MedicationRouteRepository;

public class GetMedicationRouteByIdUseCase {
    private final MedicationRouteRepository repository;

    public GetMedicationRouteByIdUseCase(MedicationRouteRepository repository) {
        this.repository = repository;
    }

    public MedicationRouteResponse execute(MedicationRouteId id) {
        return repository.findById(id)
                .map(MedicationRouteResponse::fromDomain)
                .orElseThrow(() -> new MedicationRouteNotFoundApplicationException(id));
    }
}
