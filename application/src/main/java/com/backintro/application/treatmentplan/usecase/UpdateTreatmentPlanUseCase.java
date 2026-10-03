package com.backintro.application.treatmentplan.usecase;

import com.backintro.application.treatmentplan.command.UpdateTreatmentPlanCommand;
import com.backintro.application.treatmentplan.dto.TreatmentPlanResponse;
import com.backintro.application.treatmentplan.exception.TreatmentPlanNotFoundApplicationException;
import com.backintro.domain.treatmentplan.model.aggregate.TreatmentPlan;
import com.backintro.domain.treatmentplan.port.repository.TreatmentPlanRepository;

public class UpdateTreatmentPlanUseCase {
    private final TreatmentPlanRepository repository;

    public UpdateTreatmentPlanUseCase(TreatmentPlanRepository repository) {
        this.repository = repository;
    }

    public TreatmentPlanResponse execute(UpdateTreatmentPlanCommand command) {
        TreatmentPlan aggregate = repository.findById(command.id())
                .orElseThrow(() -> new TreatmentPlanNotFoundApplicationException(command.id()));
        aggregate.update(command.encounterId(), command.professionalId(), command.title(), command.description(), command.startDate(), command.endDate(), command.treatmentStatusId());
        TreatmentPlan saved = repository.save(aggregate);
        return TreatmentPlanResponse.fromDomain(saved);
    }
}
