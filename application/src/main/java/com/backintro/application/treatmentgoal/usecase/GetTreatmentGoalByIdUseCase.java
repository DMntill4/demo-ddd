package com.backintro.application.treatmentgoal.usecase;

import com.backintro.application.treatmentgoal.dto.TreatmentGoalResponse;
import com.backintro.application.treatmentgoal.exception.TreatmentGoalNotFoundApplicationException;
import com.backintro.domain.treatmentgoal.model.valueobject.TreatmentGoalId;
import com.backintro.domain.treatmentgoal.port.repository.TreatmentGoalRepository;

public class GetTreatmentGoalByIdUseCase {
    private final TreatmentGoalRepository repository;

    public GetTreatmentGoalByIdUseCase(TreatmentGoalRepository repository) {
        this.repository = repository;
    }

    public TreatmentGoalResponse execute(TreatmentGoalId id) {
        return repository.findById(id)
                .map(TreatmentGoalResponse::fromDomain)
                .orElseThrow(() -> new TreatmentGoalNotFoundApplicationException(id));
    }
}
