package com.backintro.application.treatmentstatuss.usecase;

import com.backintro.application.treatmentstatuss.exception.TreatmentStatusNotFoundApplicationException;
import com.backintro.domain.treatmentstatuss.model.aggregate.TreatmentStatus;
import com.backintro.domain.treatmentstatuss.model.valueobject.TreatmentStatusId;
import com.backintro.domain.treatmentstatuss.port.repository.TreatmentStatusRepository;

public class DeleteTreatmentStatusUseCase {
    private final TreatmentStatusRepository repository;

    public DeleteTreatmentStatusUseCase(TreatmentStatusRepository repository) {
        this.repository = repository;
    }

    public void execute(TreatmentStatusId id) {
        TreatmentStatus aggregate = repository.findById(id)
                .orElseThrow(() -> new TreatmentStatusNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
