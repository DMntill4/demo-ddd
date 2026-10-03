package com.backintro.application.riskassessment.usecase;

import java.util.List;
import com.backintro.application.riskassessment.dto.RiskAssessmentResponse;
import com.backintro.domain.riskassessment.port.repository.RiskAssessmentRepository;

public class ListRiskAssessmentUseCase {
    private final RiskAssessmentRepository repository;

    public ListRiskAssessmentUseCase(RiskAssessmentRepository repository) {
        this.repository = repository;
    }

    public List<RiskAssessmentResponse> execute() {
        return repository.findAll()
                .stream()
                .map(RiskAssessmentResponse::fromDomain)
                .toList();
    }
}
