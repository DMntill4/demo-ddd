package com.backintro.application.assessmenttype.usecase;

import com.backintro.application.assessmenttype.command.RegisterAssessmentTypeCommand;
import com.backintro.application.assessmenttype.dto.AssessmentTypeResponse;
import com.backintro.domain.assessmenttype.model.aggregate.AssessmentType;
import com.backintro.domain.assessmenttype.port.repository.AssessmentTypeRepository;

public class RegisterAssessmentTypeUseCase {
    private final AssessmentTypeRepository repository;

    public RegisterAssessmentTypeUseCase(AssessmentTypeRepository repository) {
        this.repository = repository;
    }

    public AssessmentTypeResponse execute(RegisterAssessmentTypeCommand command) {
        AssessmentType aggregate = AssessmentType.register(command.code(), command.name(), command.description());
        AssessmentType saved = repository.save(aggregate);
        return AssessmentTypeResponse.fromDomain(saved);
    }
}
