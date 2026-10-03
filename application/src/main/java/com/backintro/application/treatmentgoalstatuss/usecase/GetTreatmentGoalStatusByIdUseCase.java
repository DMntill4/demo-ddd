package com.backintro.application.treatmentgoalstatuss.usecase;

import com.backintro.application.treatmentgoalstatuss.dto.TreatmentGoalStatusResponse;
import com.backintro.application.treatmentgoalstatuss.exception.TreatmentGoalStatusNotFoundApplicationException;
import com.backintro.domain.treatmentgoalstatuss.model.valueobject.TreatmentGoalStatusId;
import com.backintro.domain.treatmentgoalstatuss.port.repository.TreatmentGoalStatusRepository;

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
