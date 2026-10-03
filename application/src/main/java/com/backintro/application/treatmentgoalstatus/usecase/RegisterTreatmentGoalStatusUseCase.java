package com.backintro.application.treatmentgoalstatus.usecase;

import com.backintro.application.treatmentgoalstatus.command.RegisterTreatmentGoalStatusCommand;
import com.backintro.application.treatmentgoalstatus.dto.TreatmentGoalStatusResponse;
import com.backintro.domain.treatmentgoalstatus.model.aggregate.TreatmentGoalStatus;
import com.backintro.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;

public class RegisterTreatmentGoalStatusUseCase {
    private final TreatmentGoalStatusRepository repository;

    public RegisterTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository repository) {
        this.repository = repository;
    }

    public TreatmentGoalStatusResponse execute(RegisterTreatmentGoalStatusCommand command) {
        if (repository.existsByCode(command.code())) {
            throw new IllegalArgumentException("TreatmentGoalStatus code already exists: " + command.code());
        }
        TreatmentGoalStatus aggregate = TreatmentGoalStatus.register(command.name(), command.code());
        TreatmentGoalStatus saved = repository.save(aggregate);
        return TreatmentGoalStatusResponse.fromDomain(saved);
    }
}
