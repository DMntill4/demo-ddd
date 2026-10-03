package com.backintro.application.assessmenttype.usecase;

import java.util.List;
import com.backintro.application.assessmenttype.dto.AssessmentTypeResponse;
import com.backintro.domain.assessmenttype.port.repository.AssessmentTypeRepository;

public class ListAssessmentTypeUseCase {
    private final AssessmentTypeRepository repository;

    public ListAssessmentTypeUseCase(AssessmentTypeRepository repository) {
        this.repository = repository;
    }

    public List<AssessmentTypeResponse> execute() {
        return repository.findAll()
                .stream()
                .map(AssessmentTypeResponse::fromDomain)
                .toList();
    }
}
