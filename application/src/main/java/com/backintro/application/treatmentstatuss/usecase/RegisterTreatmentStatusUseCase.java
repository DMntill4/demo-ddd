package com.backintro.application.treatmentstatuss.usecase;

import com.backintro.application.treatmentstatuss.command.RegisterTreatmentStatusCommand;
import com.backintro.application.treatmentstatuss.dto.TreatmentStatusResponse;
import com.backintro.domain.treatmentstatuss.model.aggregate.TreatmentStatus;
import com.backintro.domain.treatmentstatuss.port.repository.TreatmentStatusRepository;

public class RegisterTreatmentStatusUseCase {
    private final TreatmentStatusRepository repository;

    public RegisterTreatmentStatusUseCase(TreatmentStatusRepository repository) {
        this.repository = repository;
    }

    public TreatmentStatusResponse execute(RegisterTreatmentStatusCommand command) {
        TreatmentStatus aggregate = TreatmentStatus.register(command.code(), command.name());
        TreatmentStatus saved = repository.save(aggregate);
        return TreatmentStatusResponse.fromDomain(saved);
    }
}
