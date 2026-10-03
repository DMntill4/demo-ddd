package com.backintro.application.treatmentgoalstatuss.usecase;

import com.backintro.application.treatmentgoalstatuss.exception.TreatmentGoalStatusNotFoundApplicationException;
import com.backintro.domain.treatmentgoalstatuss.model.aggregate.TreatmentGoalStatus;
import com.backintro.domain.treatmentgoalstatuss.model.valueobject.TreatmentGoalStatusId;
import com.backintro.domain.treatmentgoalstatuss.port.repository.TreatmentGoalStatusRepository;

public class DeleteTreatmentGoalStatusUseCase {
    private final TreatmentGoalStatusRepository repository;

    public DeleteTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository repository) {
        this.repository = repository;
    }

    public void execute(TreatmentGoalStatusId id) {
        TreatmentGoalStatus aggregate = repository.findById(id)
                .orElseThrow(() -> new TreatmentGoalStatusNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
