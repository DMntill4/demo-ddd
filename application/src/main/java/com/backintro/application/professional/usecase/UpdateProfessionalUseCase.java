package com.backintro.application.professional.usecase;

import com.backintro.application.professional.command.UpdateProfessionalCommand;
import com.backintro.application.professional.dto.ProfessionalResponse;
import com.backintro.application.professional.exception.ProfessionalNotFoundApplicationException;
import com.backintro.domain.professional.model.aggregate.Professional;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;

public class UpdateProfessionalUseCase {
    private final ProfessionalRepository repository;

    public UpdateProfessionalUseCase(ProfessionalRepository repository) {
        this.repository = repository;
    }

    public ProfessionalResponse execute(UpdateProfessionalCommand command) {
        Professional aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ProfessionalNotFoundApplicationException(command.id()));
        aggregate.update(command.documentTypeId(), command.documentNumber(), command.firstName(), command.lastName(), command.professionalTypeId(), command.licenseNumber(), command.cityId());
        Professional saved = repository.save(aggregate);
        return ProfessionalResponse.fromDomain(saved);
    }
}
