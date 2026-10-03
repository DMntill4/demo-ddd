package com.backintro.application.assessmenttype.usecase;

import com.backintro.application.assessmenttype.exception.AssessmentTypeNotFoundApplicationException;
import com.backintro.domain.assessmenttype.model.aggregate.AssessmentType;
import com.backintro.domain.assessmenttype.model.valueobject.AssessmentTypeId;
import com.backintro.domain.assessmenttype.port.repository.AssessmentTypeRepository;

public class DeleteAssessmentTypeUseCase {
    private final AssessmentTypeRepository repository;

    public DeleteAssessmentTypeUseCase(AssessmentTypeRepository repository) {
        this.repository = repository;
    }

    public void execute(AssessmentTypeId id) {
        AssessmentType aggregate = repository.findById(id)
                .orElseThrow(() -> new AssessmentTypeNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
