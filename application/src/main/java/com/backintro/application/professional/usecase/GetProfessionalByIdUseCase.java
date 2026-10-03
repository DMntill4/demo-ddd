package com.backintro.application.professional.usecase;

import com.backintro.application.professional.dto.ProfessionalResponse;
import com.backintro.application.professional.exception.ProfessionalNotFoundApplicationException;
import com.backintro.domain.professional.model.valueobject.ProfessionalId;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;

public class GetProfessionalByIdUseCase {
    private final ProfessionalRepository repository;

    public GetProfessionalByIdUseCase(ProfessionalRepository repository) {
        this.repository = repository;
    }

    public ProfessionalResponse execute(ProfessionalId id) {
        return repository.findById(id)
                .map(ProfessionalResponse::fromDomain)
                .orElseThrow(() -> new ProfessionalNotFoundApplicationException(id));
    }
}
