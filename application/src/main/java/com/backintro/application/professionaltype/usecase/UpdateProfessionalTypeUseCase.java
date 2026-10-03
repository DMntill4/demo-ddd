package com.backintro.application.professionaltype.usecase;

import com.backintro.application.professionaltype.command.UpdateProfessionalTypeCommand;
import com.backintro.application.professionaltype.dto.ProfessionalTypeResponse;
import com.backintro.application.professionaltype.exception.ProfessionalTypeNotFoundApplicationException;
import com.backintro.domain.professionaltype.model.aggregate.ProfessionalType;
import com.backintro.domain.professionaltype.port.repository.ProfessionalTypeRepository;

public class UpdateProfessionalTypeUseCase {
    private final ProfessionalTypeRepository repository;

    public UpdateProfessionalTypeUseCase(ProfessionalTypeRepository repository) {
        this.repository = repository;
    }

    public ProfessionalTypeResponse execute(UpdateProfessionalTypeCommand command) {
        ProfessionalType aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ProfessionalTypeNotFoundApplicationException(command.id()));
        aggregate.update(command.name());
        ProfessionalType saved = repository.save(aggregate);
        return ProfessionalTypeResponse.fromDomain(saved);
    }
}
