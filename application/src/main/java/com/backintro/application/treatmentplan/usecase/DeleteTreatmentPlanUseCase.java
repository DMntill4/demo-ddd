package com.backintro.application.treatmentplan.usecase;

import com.backintro.application.treatmentplan.exception.TreatmentPlanNotFoundApplicationException;
import com.backintro.domain.treatmentplan.model.aggregate.TreatmentPlan;
import com.backintro.domain.treatmentplan.model.valueobject.TreatmentPlanId;
import com.backintro.domain.treatmentplan.port.repository.TreatmentPlanRepository;

public class DeleteTreatmentPlanUseCase {
    private final TreatmentPlanRepository repository;

    public DeleteTreatmentPlanUseCase(TreatmentPlanRepository repository) {
        this.repository = repository;
    }

    public void execute(TreatmentPlanId id) {
        TreatmentPlan aggregate = repository.findById(id)
                .orElseThrow(() -> new TreatmentPlanNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
