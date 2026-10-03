package com.backintro.application.treatmentplan.usecase;

import java.util.List;
import com.backintro.application.treatmentplan.dto.TreatmentPlanResponse;
import com.backintro.domain.treatmentplan.port.repository.TreatmentPlanRepository;

public class ListTreatmentPlanUseCase {
    private final TreatmentPlanRepository repository;

    public ListTreatmentPlanUseCase(TreatmentPlanRepository repository) {
        this.repository = repository;
    }

    public List<TreatmentPlanResponse> execute() {
        return repository.findAll()
                .stream()
                .map(TreatmentPlanResponse::fromDomain)
                .toList();
    }
}
