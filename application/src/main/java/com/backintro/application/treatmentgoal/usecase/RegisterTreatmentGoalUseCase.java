package com.backintro.application.treatmentgoal.usecase;

import com.backintro.application.treatmentgoal.command.RegisterTreatmentGoalCommand;
import com.backintro.application.treatmentgoal.dto.TreatmentGoalResponse;
import com.backintro.domain.treatmentgoal.model.aggregate.TreatmentGoal;
import com.backintro.domain.treatmentgoal.port.repository.TreatmentGoalRepository;

public class RegisterTreatmentGoalUseCase {
    private final TreatmentGoalRepository repository;

    public RegisterTreatmentGoalUseCase(TreatmentGoalRepository repository) {
        this.repository = repository;
    }

    public TreatmentGoalResponse execute(RegisterTreatmentGoalCommand command) {
        TreatmentGoal aggregate = TreatmentGoal.register(command.treatmentPlanId(), command.description(), command.targetDate(), command.completedAt(), command.notes(), command.treatmentGoalStatusId());
        TreatmentGoal saved = repository.save(aggregate);
        return TreatmentGoalResponse.fromDomain(saved);
    }
}
