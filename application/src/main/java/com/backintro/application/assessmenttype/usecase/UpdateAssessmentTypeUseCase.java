package com.backintro.application.assessmenttype.usecase;

import com.backintro.application.assessmenttype.command.UpdateAssessmentTypeCommand;
import com.backintro.application.assessmenttype.dto.AssessmentTypeResponse;
import com.backintro.application.assessmenttype.exception.AssessmentTypeNotFoundApplicationException;
import com.backintro.domain.assessmenttype.model.aggregate.AssessmentType;
import com.backintro.domain.assessmenttype.port.repository.AssessmentTypeRepository;

public class UpdateAssessmentTypeUseCase {
    private final AssessmentTypeRepository repository;

    public UpdateAssessmentTypeUseCase(AssessmentTypeRepository repository) {
        this.repository = repository;
    }

    public AssessmentTypeResponse execute(UpdateAssessmentTypeCommand command) {
        AssessmentType aggregate = repository.findById(command.id())
                .orElseThrow(() -> new AssessmentTypeNotFoundApplicationException(command.id()));
        aggregate.update(command.code(), command.name(), command.description());
        AssessmentType saved = repository.save(aggregate);
        return AssessmentTypeResponse.fromDomain(saved);
    }
}
