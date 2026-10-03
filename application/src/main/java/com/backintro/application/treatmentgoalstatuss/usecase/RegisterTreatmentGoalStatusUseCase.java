package com.backintro.application.treatmentgoalstatuss.usecase;

import com.backintro.application.treatmentgoalstatuss.command.RegisterTreatmentGoalStatusCommand;
import com.backintro.application.treatmentgoalstatuss.dto.TreatmentGoalStatusResponse;
import com.backintro.domain.treatmentgoalstatuss.model.aggregate.TreatmentGoalStatus;
import com.backintro.domain.treatmentgoalstatuss.port.repository.TreatmentGoalStatusRepository;

public class RegisterTreatmentGoalStatusUseCase {
    private final TreatmentGoalStatusRepository repository;

    public RegisterTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository repository) {
        this.repository = repository;
    }

    public TreatmentGoalStatusResponse execute(RegisterTreatmentGoalStatusCommand command) {
        TreatmentGoalStatus aggregate = TreatmentGoalStatus.register(command.code(), command.name());
        TreatmentGoalStatus saved = repository.save(aggregate);
        return TreatmentGoalStatusResponse.fromDomain(saved);
    }
}
