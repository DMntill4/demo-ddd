package com.backintro.application.treatmentplan.usecase;

import com.backintro.application.treatmentplan.command.RegisterTreatmentPlanCommand;
import com.backintro.application.treatmentplan.dto.TreatmentPlanResponse;
import com.backintro.domain.treatmentplan.model.aggregate.TreatmentPlan;
import com.backintro.domain.treatmentplan.port.repository.TreatmentPlanRepository;

public class RegisterTreatmentPlanUseCase {
    private final TreatmentPlanRepository repository;

    public RegisterTreatmentPlanUseCase(TreatmentPlanRepository repository) {
        this.repository = repository;
    }

    public TreatmentPlanResponse execute(RegisterTreatmentPlanCommand command) {
        TreatmentPlan aggregate = TreatmentPlan.register(command.encounterId(), command.professionalId(), command.title(), command.description(), command.startDate(), command.endDate(), command.treatmentStatusId());
        TreatmentPlan saved = repository.save(aggregate);
        return TreatmentPlanResponse.fromDomain(saved);
    }
}
