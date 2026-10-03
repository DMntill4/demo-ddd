package com.backintro.application.treatmentgoalstatuss.usecase;

import com.backintro.application.treatmentgoalstatuss.command.UpdateTreatmentGoalStatusCommand;
import com.backintro.application.treatmentgoalstatuss.dto.TreatmentGoalStatusResponse;
import com.backintro.application.treatmentgoalstatuss.exception.TreatmentGoalStatusNotFoundApplicationException;
import com.backintro.domain.treatmentgoalstatuss.model.aggregate.TreatmentGoalStatus;
import com.backintro.domain.treatmentgoalstatuss.port.repository.TreatmentGoalStatusRepository;

public class UpdateTreatmentGoalStatusUseCase {
    private final TreatmentGoalStatusRepository repository;

    public UpdateTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository repository) {
        this.repository = repository;
    }

    public TreatmentGoalStatusResponse execute(UpdateTreatmentGoalStatusCommand command) {
        TreatmentGoalStatus aggregate = repository.findById(command.id())
                .orElseThrow(() -> new TreatmentGoalStatusNotFoundApplicationException(command.id()));
        aggregate.update(command.code(), command.name());
        TreatmentGoalStatus saved = repository.save(aggregate);
        return TreatmentGoalStatusResponse.fromDomain(saved);
    }
}
