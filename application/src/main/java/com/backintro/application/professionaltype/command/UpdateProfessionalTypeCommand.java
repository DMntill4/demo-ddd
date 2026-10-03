package com.backintro.application.professionaltype.command;

import com.backintro.domain.professionaltype.model.valueobject.ProfessionalTypeId;

public record UpdateProfessionalTypeCommand(ProfessionalTypeId id, String name) {
}
