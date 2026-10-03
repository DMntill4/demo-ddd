package com.backintro.application.riskassessment.usecase;

import com.backintro.application.riskassessment.exception.RiskAssessmentNotFoundApplicationException;
import com.backintro.domain.riskassessment.model.aggregate.RiskAssessment;
import com.backintro.domain.riskassessment.model.valueobject.RiskAssessmentId;
import com.backintro.domain.riskassessment.port.repository.RiskAssessmentRepository;

public class DeleteRiskAssessmentUseCase {
    private final RiskAssessmentRepository repository;

    public DeleteRiskAssessmentUseCase(RiskAssessmentRepository repository) {
        this.repository = repository;
    }

    public void execute(RiskAssessmentId id) {
        RiskAssessment aggregate = repository.findById(id)
                .orElseThrow(() -> new RiskAssessmentNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
