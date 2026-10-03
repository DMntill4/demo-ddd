package com.backintro.application.riskassessment.usecase;

import com.backintro.application.riskassessment.command.UpdateRiskAssessmentCommand;
import com.backintro.application.riskassessment.dto.RiskAssessmentResponse;
import com.backintro.application.riskassessment.exception.RiskAssessmentNotFoundApplicationException;
import com.backintro.domain.riskassessment.model.aggregate.RiskAssessment;
import com.backintro.domain.riskassessment.port.repository.RiskAssessmentRepository;

public class UpdateRiskAssessmentUseCase {
    private final RiskAssessmentRepository repository;

    public UpdateRiskAssessmentUseCase(RiskAssessmentRepository repository) {
        this.repository = repository;
    }

    public RiskAssessmentResponse execute(UpdateRiskAssessmentCommand command) {
        RiskAssessment aggregate = repository.findById(command.id())
                .orElseThrow(() -> new RiskAssessmentNotFoundApplicationException(command.id()));
        aggregate.update(command.encounterId(), command.riskLevelId(), command.suicidalIdeation(), command.suicidePlan(), command.suicideIntent(), command.selfHarm(), command.harmToOthers(), command.protectiveFactors(), command.riskFactors(), command.clinicalActions(), command.observations(), command.assessedAt(), command.assessedBy());
        RiskAssessment saved = repository.save(aggregate);
        return RiskAssessmentResponse.fromDomain(saved);
    }
}
