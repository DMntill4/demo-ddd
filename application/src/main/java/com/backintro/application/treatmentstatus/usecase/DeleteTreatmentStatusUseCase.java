package com.backintro.application.treatmentstatus.usecase;

import com.backintro.application.treatmentstatus.exception.TreatmentStatusNotFoundApplicationException;
import com.backintro.domain.treatmentstatus.model.aggregate.TreatmentStatus;
import com.backintro.domain.treatmentstatus.model.valueobject.TreatmentStatusId;
import com.backintro.domain.treatmentstatus.port.repository.TreatmentStatusRepository;

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
