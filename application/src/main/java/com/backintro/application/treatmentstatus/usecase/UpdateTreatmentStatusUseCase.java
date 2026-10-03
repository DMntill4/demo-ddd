package com.backintro.application.treatmentstatus.usecase;

import com.backintro.application.treatmentstatus.command.UpdateTreatmentStatusCommand;
import com.backintro.application.treatmentstatus.dto.TreatmentStatusResponse;
import com.backintro.application.treatmentstatus.exception.TreatmentStatusNotFoundApplicationException;
import com.backintro.domain.treatmentstatus.model.aggregate.TreatmentStatus;
import com.backintro.domain.treatmentstatus.port.repository.TreatmentStatusRepository;

public class UpdateTreatmentStatusUseCase {
    private final TreatmentStatusRepository repository;

    public UpdateTreatmentStatusUseCase(TreatmentStatusRepository repository) {
        this.repository = repository;
    }

    public TreatmentStatusResponse execute(UpdateTreatmentStatusCommand command) {
        TreatmentStatus aggregate = repository.findById(command.id())
                .orElseThrow(() -> new TreatmentStatusNotFoundApplicationException(command.id()));
        aggregate.update(command.name(), command.code());
        TreatmentStatus saved = repository.save(aggregate);
        return TreatmentStatusResponse.fromDomain(saved);
    }
}
