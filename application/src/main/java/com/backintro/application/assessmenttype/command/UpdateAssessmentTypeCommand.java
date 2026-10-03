package com.backintro.application.assessmenttype.command;

import com.backintro.domain.assessmenttype.model.valueobject.AssessmentTypeId;

public record UpdateAssessmentTypeCommand(AssessmentTypeId id, String code, String name, String description) {
}
