package com.backintro.application.treatmentgoalstatus.usecase;

import com.backintro.application.treatmentgoalstatus.exception.TreatmentGoalStatusNotFoundApplicationException;
import com.backintro.domain.treatmentgoalstatus.model.aggregate.TreatmentGoalStatus;
import com.backintro.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;
import com.backintro.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;

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
