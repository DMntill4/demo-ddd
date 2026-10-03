package com.backintro.application.treatmentgoalstatus.usecase;

import com.backintro.application.treatmentgoalstatus.dto.TreatmentGoalStatusResponse;
import com.backintro.application.treatmentgoalstatus.exception.TreatmentGoalStatusNotFoundApplicationException;
import com.backintro.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;
import com.backintro.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;

public class GetTreatmentGoalStatusByIdUseCase {
    private final TreatmentGoalStatusRepository repository;

    public GetTreatmentGoalStatusByIdUseCase(TreatmentGoalStatusRepository repository) {
        this.repository = repository;
    }

    public TreatmentGoalStatusResponse execute(TreatmentGoalStatusId id) {
        return repository.findById(id)
                .map(TreatmentGoalStatusResponse::fromDomain)
                .orElseThrow(() -> new TreatmentGoalStatusNotFoundApplicationException(id));
    }
}
