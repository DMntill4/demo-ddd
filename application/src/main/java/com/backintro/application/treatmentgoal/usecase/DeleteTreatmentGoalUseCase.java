package com.backintro.application.treatmentgoal.usecase;

import com.backintro.application.treatmentgoal.exception.TreatmentGoalNotFoundApplicationException;
import com.backintro.domain.treatmentgoal.model.aggregate.TreatmentGoal;
import com.backintro.domain.treatmentgoal.model.valueobject.TreatmentGoalId;
import com.backintro.domain.treatmentgoal.port.repository.TreatmentGoalRepository;

public class DeleteTreatmentGoalUseCase {
    private final TreatmentGoalRepository repository;

    public DeleteTreatmentGoalUseCase(TreatmentGoalRepository repository) {
        this.repository = repository;
    }

    public void execute(TreatmentGoalId id) {
        TreatmentGoal aggregate = repository.findById(id)
                .orElseThrow(() -> new TreatmentGoalNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
