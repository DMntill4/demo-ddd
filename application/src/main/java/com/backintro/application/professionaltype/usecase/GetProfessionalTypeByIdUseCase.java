package com.backintro.application.professionaltype.usecase;

import com.backintro.application.professionaltype.dto.ProfessionalTypeResponse;
import com.backintro.application.professionaltype.exception.ProfessionalTypeNotFoundApplicationException;
import com.backintro.domain.professionaltype.model.valueobject.ProfessionalTypeId;
import com.backintro.domain.professionaltype.port.repository.ProfessionalTypeRepository;

public class GetProfessionalTypeByIdUseCase {
    private final ProfessionalTypeRepository repository;

    public GetProfessionalTypeByIdUseCase(ProfessionalTypeRepository repository) {
        this.repository = repository;
    }

    public ProfessionalTypeResponse execute(ProfessionalTypeId id) {
        return repository.findById(id)
                .map(ProfessionalTypeResponse::fromDomain)
                .orElseThrow(() -> new ProfessionalTypeNotFoundApplicationException(id));
    }
}
