package com.backintro.application.assessmenttype.usecase;

import com.backintro.application.assessmenttype.dto.AssessmentTypeResponse;
import com.backintro.application.assessmenttype.exception.AssessmentTypeNotFoundApplicationException;
import com.backintro.domain.assessmenttype.model.valueobject.AssessmentTypeId;
import com.backintro.domain.assessmenttype.port.repository.AssessmentTypeRepository;

public class GetAssessmentTypeByIdUseCase {
    private final AssessmentTypeRepository repository;

    public GetAssessmentTypeByIdUseCase(AssessmentTypeRepository repository) {
        this.repository = repository;
    }

    public AssessmentTypeResponse execute(AssessmentTypeId id) {
        return repository.findById(id)
                .map(AssessmentTypeResponse::fromDomain)
                .orElseThrow(() -> new AssessmentTypeNotFoundApplicationException(id));
    }
}
