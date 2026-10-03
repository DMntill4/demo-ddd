package com.backintro.application.treatmentstatuss.usecase;

import com.backintro.application.treatmentstatuss.command.UpdateTreatmentStatusCommand;
import com.backintro.application.treatmentstatuss.dto.TreatmentStatusResponse;
import com.backintro.application.treatmentstatuss.exception.TreatmentStatusNotFoundApplicationException;
import com.backintro.domain.treatmentstatuss.model.aggregate.TreatmentStatus;
import com.backintro.domain.treatmentstatuss.port.repository.TreatmentStatusRepository;

public class UpdateTreatmentStatusUseCase {
    private final TreatmentStatusRepository repository;

    public UpdateTreatmentStatusUseCase(TreatmentStatusRepository repository) {
        this.repository = repository;
    }

    public TreatmentStatusResponse execute(UpdateTreatmentStatusCommand command) {
        TreatmentStatus aggregate = repository.findById(command.id())
                .orElseThrow(() -> new TreatmentStatusNotFoundApplicationException(command.id()));
        aggregate.update(command.code(), command.name());
        TreatmentStatus saved = repository.save(aggregate);
        return TreatmentStatusResponse.fromDomain(saved);
    }
}
