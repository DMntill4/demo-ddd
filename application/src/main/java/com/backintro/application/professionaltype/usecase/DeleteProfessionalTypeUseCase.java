package com.backintro.application.professionaltype.usecase;

import com.backintro.application.professionaltype.exception.ProfessionalTypeNotFoundApplicationException;
import com.backintro.domain.professionaltype.model.aggregate.ProfessionalType;
import com.backintro.domain.professionaltype.model.valueobject.ProfessionalTypeId;
import com.backintro.domain.professionaltype.port.repository.ProfessionalTypeRepository;

public class DeleteProfessionalTypeUseCase {
    private final ProfessionalTypeRepository repository;

    public DeleteProfessionalTypeUseCase(ProfessionalTypeRepository repository) {
        this.repository = repository;
    }

    public void execute(ProfessionalTypeId id) {
        ProfessionalType aggregate = repository.findById(id)
                .orElseThrow(() -> new ProfessionalTypeNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
