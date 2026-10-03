package com.backintro.application.riskassessment.usecase;

import com.backintro.application.riskassessment.dto.RiskAssessmentResponse;
import com.backintro.application.riskassessment.exception.RiskAssessmentNotFoundApplicationException;
import com.backintro.domain.riskassessment.model.valueobject.RiskAssessmentId;
import com.backintro.domain.riskassessment.port.repository.RiskAssessmentRepository;

public class GetRiskAssessmentByIdUseCase {
    private final RiskAssessmentRepository repository;

    public GetRiskAssessmentByIdUseCase(RiskAssessmentRepository repository) {
        this.repository = repository;
    }

    public RiskAssessmentResponse execute(RiskAssessmentId id) {
        return repository.findById(id)
                .map(RiskAssessmentResponse::fromDomain)
                .orElseThrow(() -> new RiskAssessmentNotFoundApplicationException(id));
    }
}
