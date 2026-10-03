package com.backintro.application.treatmentgoalstatus.usecase;

import com.backintro.application.treatmentgoalstatus.command.UpdateTreatmentGoalStatusCommand;
import com.backintro.application.treatmentgoalstatus.dto.TreatmentGoalStatusResponse;
import com.backintro.application.treatmentgoalstatus.exception.TreatmentGoalStatusNotFoundApplicationException;
import com.backintro.domain.treatmentgoalstatus.model.aggregate.TreatmentGoalStatus;
import com.backintro.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;

public class UpdateTreatmentGoalStatusUseCase {
    private final TreatmentGoalStatusRepository repository;

    public UpdateTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository repository) {
        this.repository = repository;
    }

    public TreatmentGoalStatusResponse execute(UpdateTreatmentGoalStatusCommand command) {
        TreatmentGoalStatus aggregate = repository.findById(command.id())
                .orElseThrow(() -> new TreatmentGoalStatusNotFoundApplicationException(command.id()));
        aggregate.update(command.name(), command.code());
        TreatmentGoalStatus saved = repository.save(aggregate);
        return TreatmentGoalStatusResponse.fromDomain(saved);
    }
}
