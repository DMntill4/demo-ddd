package com.backintro.application.professional.usecase;

import com.backintro.application.professional.exception.ProfessionalNotFoundApplicationException;
import com.backintro.domain.professional.model.aggregate.Professional;
import com.backintro.domain.professional.model.valueobject.ProfessionalId;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;

public class DeleteProfessionalUseCase {
    private final ProfessionalRepository repository;

    public DeleteProfessionalUseCase(ProfessionalRepository repository) {
        this.repository = repository;
    }

    public void execute(ProfessionalId id) {
        Professional aggregate = repository.findById(id)
                .orElseThrow(() -> new ProfessionalNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
