package com.backintro.application.treatmentgoal.usecase;

import com.backintro.application.treatmentgoal.command.UpdateTreatmentGoalCommand;
import com.backintro.application.treatmentgoal.dto.TreatmentGoalResponse;
import com.backintro.application.treatmentgoal.exception.TreatmentGoalNotFoundApplicationException;
import com.backintro.domain.treatmentgoal.model.aggregate.TreatmentGoal;
import com.backintro.domain.treatmentgoal.port.repository.TreatmentGoalRepository;

public class UpdateTreatmentGoalUseCase {
    private final TreatmentGoalRepository repository;

    public UpdateTreatmentGoalUseCase(TreatmentGoalRepository repository) {
        this.repository = repository;
    }

    public TreatmentGoalResponse execute(UpdateTreatmentGoalCommand command) {
        TreatmentGoal aggregate = repository.findById(command.id())
                .orElseThrow(() -> new TreatmentGoalNotFoundApplicationException(command.id()));
        aggregate.update(command.treatmentPlanId(), command.description(), command.targetDate(), command.completedAt(), command.notes(), command.treatmentGoalStatusId());
        TreatmentGoal saved = repository.save(aggregate);
        return TreatmentGoalResponse.fromDomain(saved);
    }
}
