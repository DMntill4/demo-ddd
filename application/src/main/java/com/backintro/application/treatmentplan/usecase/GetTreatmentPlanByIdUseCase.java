package com.backintro.application.treatmentplan.usecase;

import com.backintro.application.treatmentplan.dto.TreatmentPlanResponse;
import com.backintro.application.treatmentplan.exception.TreatmentPlanNotFoundApplicationException;
import com.backintro.domain.treatmentplan.model.valueobject.TreatmentPlanId;
import com.backintro.domain.treatmentplan.port.repository.TreatmentPlanRepository;

public class GetTreatmentPlanByIdUseCase {
    private final TreatmentPlanRepository repository;

    public GetTreatmentPlanByIdUseCase(TreatmentPlanRepository repository) {
        this.repository = repository;
    }

    public TreatmentPlanResponse execute(TreatmentPlanId id) {
        return repository.findById(id)
                .map(TreatmentPlanResponse::fromDomain)
                .orElseThrow(() -> new TreatmentPlanNotFoundApplicationException(id));
    }
}
