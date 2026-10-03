package com.backintro.application.medicationroute.usecase;

import com.backintro.application.medicationroute.command.RegisterMedicationRouteCommand;
import com.backintro.application.medicationroute.dto.MedicationRouteResponse;
import com.backintro.domain.medicationroute.model.aggregate.MedicationRoute;
import com.backintro.domain.medicationroute.port.repository.MedicationRouteRepository;

public class RegisterMedicationRouteUseCase {
    private final MedicationRouteRepository repository;

    public RegisterMedicationRouteUseCase(MedicationRouteRepository repository) {
        this.repository = repository;
    }

    public MedicationRouteResponse execute(RegisterMedicationRouteCommand command) {
        MedicationRoute aggregate = MedicationRoute.register(command.code(), command.name());
        MedicationRoute saved = repository.save(aggregate);
        return MedicationRouteResponse.fromDomain(saved);
    }
}
