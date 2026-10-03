package com.backintro.application.treatmentstatus.usecase;

import com.backintro.application.treatmentstatus.command.RegisterTreatmentStatusCommand;
import com.backintro.application.treatmentstatus.dto.TreatmentStatusResponse;
import com.backintro.domain.treatmentstatus.model.aggregate.TreatmentStatus;
import com.backintro.domain.treatmentstatus.port.repository.TreatmentStatusRepository;

public class RegisterTreatmentStatusUseCase {
    private final TreatmentStatusRepository repository;

    public RegisterTreatmentStatusUseCase(TreatmentStatusRepository repository) {
        this.repository = repository;
    }

    public TreatmentStatusResponse execute(RegisterTreatmentStatusCommand command) {
        if (repository.existsByCode(command.code())) {
            throw new IllegalArgumentException("TreatmentStatus code already exists: " + command.code());
        }
        TreatmentStatus aggregate = TreatmentStatus.register(command.name(), command.code());
        TreatmentStatus saved = repository.save(aggregate);
        return TreatmentStatusResponse.fromDomain(saved);
    }
}
