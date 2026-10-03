package com.backintro.application.riskassessment.usecase;

import com.backintro.application.riskassessment.command.RegisterRiskAssessmentCommand;
import com.backintro.application.riskassessment.dto.RiskAssessmentResponse;
import com.backintro.domain.riskassessment.model.aggregate.RiskAssessment;
import com.backintro.domain.riskassessment.port.repository.RiskAssessmentRepository;

public class RegisterRiskAssessmentUseCase {
    private final RiskAssessmentRepository repository;

    public RegisterRiskAssessmentUseCase(RiskAssessmentRepository repository) {
        this.repository = repository;
    }

    public RiskAssessmentResponse execute(RegisterRiskAssessmentCommand command) {
        RiskAssessment aggregate = RiskAssessment.register(command.encounterId(), command.riskLevelId(), command.suicidalIdeation(), command.suicidePlan(), command.suicideIntent(), command.selfHarm(), command.harmToOthers(), command.protectiveFactors(), command.riskFactors(), command.clinicalActions(), command.observations(), command.assessedAt(), command.assessedBy());
        RiskAssessment saved = repository.save(aggregate);
        return RiskAssessmentResponse.fromDomain(saved);
    }
}
