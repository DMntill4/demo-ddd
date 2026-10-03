package com.backintro.application.professionaltype.usecase;

import com.backintro.application.professionaltype.command.RegisterProfessionalTypeCommand;
import com.backintro.application.professionaltype.dto.ProfessionalTypeResponse;
import com.backintro.domain.professionaltype.model.aggregate.ProfessionalType;
import com.backintro.domain.professionaltype.port.repository.ProfessionalTypeRepository;

public class RegisterProfessionalTypeUseCase {
    private final ProfessionalTypeRepository repository;

    public RegisterProfessionalTypeUseCase(ProfessionalTypeRepository repository) {
        this.repository = repository;
    }

    public ProfessionalTypeResponse execute(RegisterProfessionalTypeCommand command) {
        ProfessionalType aggregate = ProfessionalType.register(command.name());
        ProfessionalType saved = repository.save(aggregate);
        return ProfessionalTypeResponse.fromDomain(saved);
    }
}
